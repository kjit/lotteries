package com.github.kjit.lotteries.api;

import com.github.kjit.lotteries.service.EurojackpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class JackpotHandler {

    @Autowired
    private EurojackpotService service;

    public Mono<ServerResponse> hello(ServerRequest request) {

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(service.getLatestResults()));
    }
}
