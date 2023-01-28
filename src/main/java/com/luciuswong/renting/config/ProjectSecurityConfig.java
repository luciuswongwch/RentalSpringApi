package com.luciuswong.renting.config;

import com.luciuswong.renting.constants.RentingSpringConstants;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .ignoringRequestMatchers(PathRequest.toH2Console())
                .and().authorizeHttpRequests()
                .requestMatchers("/admin/**").hasRole(RentingSpringConstants.ADMIN_ROLE)
                .requestMatchers("/api/**").permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll()
                .and().httpBasic();
        http.headers().frameOptions().disable();
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
