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
                .route("address-service", r -> r.path("/address-service/**")
                        .filters(GatewayFilterSpec::tokenRelay)
                        .uri("http://localhost:8090/address-service"))
                .route("person-service", r -> r.path("/person-service/**")
                        .filters(GatewayFilterSpec::tokenRelay)
                        .uri("http://localhost:8091/person-service"))
                .build();
    }
}
