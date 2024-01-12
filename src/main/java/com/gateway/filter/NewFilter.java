package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;
@Component
public class NewFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Inside Global Filter..");
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();

        Set<String> set = headers.keySet();

        for (String s: set) {
            System.out.println(headers.getValuesAsList(s));
        }

        return chain.filter(exchange);
    }
}
