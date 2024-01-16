package com.joshaby.BookService.controllers;

import com.joshaby.BookService.models.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/book-service")
@RequiredArgsConstructor
public class BookController {

    private final Environment environment;

    @GetMapping("/{id}/{currency}")
    public Book find(@PathVariable Long id, @PathVariable String currency) {

        String port = environment.getProperty("local.server.port");
        return new Book(
                id, "Nigel Poulton", LocalDateTime.now(), 13.7, "Docker Deep Dive", currency, port);
    }
}
