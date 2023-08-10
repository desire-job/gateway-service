package com.gmail.apachdima.desirejob.gatewayservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.net.URI;

@Configuration
@RequiredArgsConstructor
public class ResourceServerSecurityConfig {

    @Bean
    public SecurityWebFilterChain configureResourceServer(ServerHttpSecurity httpSecurity) {
        return httpSecurity
            .csrf().disable()
            .authorizeExchange()
            .pathMatchers("/actuator/health/**").permitAll()
            .pathMatchers("/user-service/api/v1/auth/sign-in", "/user-service/api/v1/auth/sign-up").permitAll()
            .anyExchange().authenticated()
            .and()
            .oauth2ResourceServer().jwt()
            .and().and()
            .build();
    }
}
