package com.joshaby.ExchangeService.controllers;

import com.joshaby.ExchangeService.models.Exchange;
import com.joshaby.ExchangeService.repositories.ExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("exchange-service")
@RequiredArgsConstructor
public class ExchangeController {

    private final Environment environment;

    private final ExchangeRepository repository;

    @GetMapping("/{amount}/{from}/{to}")
    public Exchange find(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {

        String port = environment.getProperty("local.server.port");
        Exchange exchange = repository.findByFromAndTo(from, to).orElseThrow(
                () -> new RuntimeException("Currency Unsupported"));
        BigDecimal convertedValue = exchange.getConversionFactor().multiply(amount);
        exchange.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        exchange.setEnvironment(port);
        return exchange;
    }
}
