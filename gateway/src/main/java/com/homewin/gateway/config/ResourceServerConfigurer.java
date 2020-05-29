package com.homewin.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @description:
 * @author: homewin
 * @create: 2020-05-27 15:43
 **/
@EnableWebFluxSecurity
public class ResourceServerConfigurer {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange()
                .pathMatchers("/file-service/**").permitAll()
                .anyExchange().authenticated();
        http.oauth2ResourceServer().jwt();
        return http.build();
    }
}