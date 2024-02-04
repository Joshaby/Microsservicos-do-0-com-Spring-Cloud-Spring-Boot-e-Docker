package com.joshaby.BookService.controllers;

import com.joshaby.BookService.models.Book;
import com.joshaby.BookService.proxy.ExchangeProxy;
import com.joshaby.BookService.repositories.BookRepository;
import com.joshaby.BookService.controllers.response.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/book-service")
@RequiredArgsConstructor
public class BookController {

    private final Environment environment;

    private final BookRepository repository;

    private final ExchangeProxy proxy;

    @GetMapping("/{id}/{currency}")
    public Book find(@PathVariable Long id, @PathVariable String currency) {

        String port = environment.getProperty("local.server.port");
        Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        Exchange response = proxy.find(BigDecimal.valueOf(book.getPrice()), "USD", currency);

        book.setEnvironment("Book port: " + port + " Exchange port: " + response.getEnvironment());
        book.setPrice(response.getConvertedValue().doubleValue());
        return book;
    }
}
