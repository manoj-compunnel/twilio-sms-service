package com.compunnel.twilioservice.controller;

import com.compunnel.twilioservice.entity.TwilioClient;
import com.compunnel.twilioservice.repository.TwilioClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TwilioClientRepository twilioClientRepository;

    @PostMapping("/test")
    public Flux<TwilioClient> getData() {
        return twilioClientRepository.findAll();
    }
}
