package com.example.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.apigateway.config.security.JwtAuthFilter;

@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthFilter jwtFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("insurer-service", r -> r.path("/insurance/**")
                        .filters(f -> f.stripPrefix(1)
                                .circuitBreaker(cb -> cb.setName("insuranceCb")
                                        .setFallbackUri("forward:/fallback/insurer")))
                        .uri("lb://insurer-service"))
                .build();
    }
}
