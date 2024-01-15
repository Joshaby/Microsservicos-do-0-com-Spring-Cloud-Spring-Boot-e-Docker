package com.joshaby.ExchangeService.controllers;

import com.joshaby.ExchangeService.models.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("exchange-service")
@RequiredArgsConstructor
public class ExchangeController {

    private final Environment environment;

    @GetMapping("/{amount}/{from}/{to}")
    public Exchange find(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {

        String port = environment.getProperty("local.server.port");
        return new Exchange(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, port);
    }
}
