package com.joshaby.BookService.proxy;

import com.joshaby.BookService.controllers.response.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(value = "exchange-service", path = "/exchange-service")
public interface ExchangeProxy {

    @GetMapping("/{amount}/{from}/{to}")
    Exchange find(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to);
}
