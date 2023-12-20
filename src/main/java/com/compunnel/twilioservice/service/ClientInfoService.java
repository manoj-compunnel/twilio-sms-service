package com.compunnel.twilioservice.service;

import com.compunnel.twilioservice.entity.TwilioClient;
import com.compunnel.twilioservice.repository.TwilioClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientInfoService {

    private final TwilioClientRepository twilioClientRepository;


    private Mono<TwilioClient> getClientData() {
        return null;


    }

}
