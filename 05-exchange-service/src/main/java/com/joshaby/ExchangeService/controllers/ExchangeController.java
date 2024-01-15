package com.joshaby.ExchangeService.controllers;

import com.joshaby.ExchangeService.models.Exchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("exchange-service")
public class ExchangeController {

    @GetMapping("/{amount}/{from}/{to}")
    public Exchange find(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {
        return new Exchange(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, "PORT 8000");
    }
}
