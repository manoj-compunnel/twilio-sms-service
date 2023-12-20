package com.compunnel.twilioservice.config;

import com.compunnel.twilioservice.entity.TwilioClient;
import com.compunnel.twilioservice.repository.TwilioClientRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SecretKeyFilter implements WebFilter {

    private final TwilioClientRepository twilioClientRepository;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String secretKey = exchange.getRequest().getHeaders().getFirst("secretKey");
        if (StringUtils.isNotBlank(secretKey)) {
            return isValidSecretKey(secretKey).flatMap(isValid -> {
                if (Boolean.TRUE.equals(isValid)) {
                    return chain.filter(exchange);
                } else {
                    return exchange.getResponse().setComplete()
                            .then(Mono.fromRunnable(() -> exchange.getResponse().setStatusCode(HttpStatusCode.valueOf(401))));
                }
            });
        } else {
            // Unauthorized response if the secret key is blank or not present
            return exchange.getResponse().setComplete()
                    .then(Mono.fromRunnable(() -> exchange.getResponse().setStatusCode(HttpStatusCode.valueOf(401))));
        }
    }

    private Mono<Boolean> isValidSecretKey(String secretKey) {
        Mono<TwilioClient> bySecretKey = twilioClientRepository.findBySecretKey(secretKey);
        return bySecretKey.map(client -> client.getSecretKey().equals(secretKey))
                .defaultIfEmpty(false);
    }
}
