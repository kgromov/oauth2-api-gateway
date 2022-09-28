package oauth2.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("address-service", r -> r.path("/api/address", "/api/address/**")
                        .filters(GatewayFilterSpec::tokenRelay)
                        .uri("lb://address-service/api"))
                .route("person-service", r -> r.path("/api/person", "/api/person/**")
                        .filters(GatewayFilterSpec::tokenRelay)
                        .uri("lb://person-service/api"))
                .route("pc-name", r -> r.path("/")
                        .filters(f -> f.setHostHeader("localhost"))
                        .uri("lb://localhost"))
                .build();
    }
}

