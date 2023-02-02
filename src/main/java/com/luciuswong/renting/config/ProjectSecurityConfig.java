package com.luciuswong.renting.config;

import com.luciuswong.renting.constants.RentingSpringConstants;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, HandlerMappingIntrospector introspector) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                        .requestMatchers("/admin/**").hasRole(RentingSpringConstants.ADMIN_ROLE)
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/data/**").permitAll()
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .httpBasic(Customizer.withDefaults())
                .headers(header -> {header.frameOptions().sameOrigin();})
                .build();
    }
//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf()
//                .ignoringRequestMatchers(PathRequest.toH2Console())
//                .and().authorizeHttpRequests()
//                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .requestMatchers("/admin/**").hasRole(RentingSpringConstants.ADMIN_ROLE)
//                .requestMatchers("/api/**").permitAll()
//                .requestMatchers("/auth/**").permitAll()
//                .requestMatchers("/data/**").permitAll()
//                .requestMatchers(PathRequest.toH2Console()).permitAll()
//                .and().httpBasic();
//        http.headers().frameOptions().disable();
//        return http.build();
//    }



    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry corsRegistry) {
                corsRegistry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000");
            }
        };
    }
}
