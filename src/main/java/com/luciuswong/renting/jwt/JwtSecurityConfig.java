package com.luciuswong.renting.jwt;

import com.luciuswong.renting.config.CredentialsConfig;
import com.luciuswong.renting.constants.RentingSpringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class JwtSecurityConfig {
    @Autowired
    private CredentialsConfig credentialsConfig;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, HandlerMappingIntrospector introspector) throws Exception {
//        return httpSecurity
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/authenticate").permitAll()
//                        .requestMatchers(PathRequest.toH2Console()).permitAll()
//                        .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
//                        .anyRequest().authenticated())
//                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//                .httpBasic(Customizer.withDefaults())
//                .headers(header -> {header.frameOptions().sameOrigin();})
//                .build();
//    }
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        var user = User.withUsername(credentialsConfig.getUser().get("username"))
                .password("{noop}" + credentialsConfig.getUser().get("password"))
                //.passwordEncoder(str -> passwordEncoder().encode(str))
                .roles(RentingSpringConstants.DEFAULT_ROLE)
                .build();
        var admin = User.withUsername(credentialsConfig.getAdmin().get("username"))
                .password("{noop}" + credentialsConfig.getAdmin().get("password"))
                //.passwordEncoder(str -> passwordEncoder().encode(str))
                .roles(RentingSpringConstants.ADMIN_ROLE)
                .build();
        var jdbcUserDetailsManger = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManger.createUser(user);
        jdbcUserDetailsManger.createUser(admin);
        return jdbcUserDetailsManger;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        JWKSet jwkSet = new JWKSet(rsaKey());
        return (((jwkSelector, securityContext)
                -> jwkSelector.select(jwkSet)));
    }

    @Bean
    JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
        return new NimbusJwtEncoder(jwkSource);
    }

    @Bean
    JwtDecoder jwtDecoder() throws JOSEException {
        return NimbusJwtDecoder.withPublicKey(rsaKey().toRSAPublicKey()).build();
    }

    @Bean
    public RSAKey rsaKey() {
        KeyPair keyPair = keyPair();
        return new RSAKey
                .Builder((RSAPublicKey) keyPair.getPublic())
                .privateKey((RSAPrivateKey) keyPair.getPrivate())
                .keyID(UUID.randomUUID().toString())
                .build();
    }

    @Bean
    public KeyPair keyPair() {
        try {
            var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new IllegalStateException("Unable to generate an RSA Key Pair", e);
        }
    }
}
