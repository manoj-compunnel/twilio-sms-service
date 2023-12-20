package com.compunnel.twilioservice.repository;


import com.compunnel.twilioservice.entity.TwilioClient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TwilioClientRepository extends ReactiveCrudRepository<TwilioClient, Integer> {

    Mono<TwilioClient> findBySecretKey(String secretKey);
}
