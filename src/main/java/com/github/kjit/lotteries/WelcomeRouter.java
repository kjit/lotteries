package com.github.kjit.lotteries;

import com.github.kjit.lotteries.api.JackpotHandler;
import com.github.kjit.lotteries.api.WelcomeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WelcomeRouter {

    @Bean
    public RouterFunction<ServerResponse> route(WelcomeHandler handler, JackpotHandler jackpotHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/"), handler::hello)
                .andRoute(RequestPredicates.GET("/jackpot"), jackpotHandler::hello);
    }
}
