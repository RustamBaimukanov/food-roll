package com.own.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("greetings-service", r -> r.path("/greetings/**")
                        .uri("lb://greetings-service"))
                .route("food-service", r -> r.path("/foods/**")
                        .uri("lb://food-service"))
                .route(r -> r.path("/food-service/v3/api-docs").uri("lb://food-service"))

                .build();
    }
}