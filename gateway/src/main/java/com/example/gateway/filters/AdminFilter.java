package com.example.gateway.filters;


import org.bouncycastle.mime.Headers;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class AdminFilter extends AbstractGatewayFilterFactory {


    private final WebClient.Builder webClientBuilder;

    public AdminFilter(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public GatewayFilter apply(Object config) {
        for (int i = 0; i < 1; i++)
            System.out.println("second filter");

        return ((exchange, chain) -> {
            HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
            if (requestHeaders.get("user-id").isEmpty())
                throw new RuntimeException("dont have user-id");

            String userRole = webClientBuilder.build()
                    .post()
                    .uri("http://user-service/users/role")
                    .retrieve()
                    .bodyToMono(String.class).toString();
            if (userRole.equals("ROLE_ADMIN"))
                return chain.filter(exchange);

            throw new RuntimeException("try to get access to admin resources but dont have grant on it");
        });
    }
}
