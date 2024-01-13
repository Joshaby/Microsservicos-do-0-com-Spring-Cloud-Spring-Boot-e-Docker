package com.joshaby.greetingservice.controllers;

import com.joshaby.greetingservice.configs.GreetingConfig;
import com.joshaby.greetingservice.entities.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
@RequiredArgsConstructor
public class GreetingController {

    private static final String template = "%s, %s!";

    private final AtomicLong counter = new AtomicLong();

    private final GreetingConfig greetingConfig;

    @GetMapping
    public Greeting greeting(@RequestParam(defaultValue = "") String name) {

        if (name.isEmpty()) name = greetingConfig.getDefaultValue();

        return new Greeting(counter.incrementAndGet(), String.format(template, greetingConfig.getGreeting(), name));
    }
}
