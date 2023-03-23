package com.example.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class AuthFilter extends AbstractGatewayFilterFactory {

    private final WebClient.Builder webClientBuilder;

    public AuthFilter(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public GatewayFilter apply(Object config) {
        for (int i = 0; i < 1; i++)
            System.out.println("first filter");

        return ((exchange, chain) -> {
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
                throw new RuntimeException("dont have token");

            String[] partsOfToken = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0)
                    .split(" ");

            if (partsOfToken.length != 2 || !partsOfToken[0].equals("Bearer"))
                throw new RuntimeException("invalid token");

            return webClientBuilder.build()
                    .post()
                    .uri("http://auth-service/auth/validate?token=" + partsOfToken[1])
                    .retrieve()
                    .bodyToMono(Long.class)
                    .map(a -> {
                        exchange.getRequest()
                                .mutate()
                                .header("user-id", String.valueOf(a));
                        return exchange;
                    }).flatMap(chain::filter);
        });
    }
}
