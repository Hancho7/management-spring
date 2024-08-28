package com.hancho.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.hancho.management.service.SecurityConfigurationService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private SecurityConfigurationService securityConfigurationService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/sign-up").permitAll()
                        .anyRequest().authenticated())
                .userDetailsService(securityConfigurationService)
                .build();

    }

}
