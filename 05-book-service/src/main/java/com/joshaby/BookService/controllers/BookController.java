package com.joshaby.BookService.controllers;

import com.joshaby.BookService.models.Book;
import com.joshaby.BookService.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-service")
@RequiredArgsConstructor
public class BookController {

    private final Environment environment;

    private final BookRepository repository;

    @GetMapping("/{id}/{currency}")
    public Book find(@PathVariable Long id, @PathVariable String currency) {

        String port = environment.getProperty("local.server.port");
        Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setEnvironment(port);
        return book;
    }
}
