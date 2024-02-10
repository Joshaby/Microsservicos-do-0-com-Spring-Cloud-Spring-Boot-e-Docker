package com.joshaby.BookService.controllers;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/book-service")
@Slf4j
public class FooBarController {

    @GetMapping("/foo-bar")
    @Retry(name = "default")
    public String fooBar() {
        log.info("Resquest to foo-bar is received!");
        var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        return response.getBody();
    }
}
