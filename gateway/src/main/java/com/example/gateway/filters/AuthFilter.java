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
        return ((exchange, chain) -> {
            String jwtToken = FilterUtil.retrieveTokenFromRequest(exchange.getRequest().getHeaders());

            if (exchange.getRequest().getURI().toString().contains("admin")) {
                boolean isAdmin = FilterUtil.isAdmin(jwtToken);
                if (!isAdmin)
                    throw new RuntimeException("you can not call admin functional cause u have role user");
            }
            return webClientBuilder.build()
                    .post()
                    .uri("http://localhost:8080/auth/validate?token=" + jwtToken)
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
