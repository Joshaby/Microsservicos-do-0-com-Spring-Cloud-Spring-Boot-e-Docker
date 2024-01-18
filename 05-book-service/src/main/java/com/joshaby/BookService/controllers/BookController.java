package com.joshaby.BookService.controllers;

import com.joshaby.BookService.models.Book;
import com.joshaby.BookService.repositories.BookRepository;
import com.joshaby.BookService.controllers.response.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

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

        HashMap<String, String> params = new HashMap<>(){{
            put("amount", book.getPrice().toString());
            put("from", "USD");
            put("to", currency);
        }};
        ResponseEntity<Exchange> response = new RestTemplate()
                .getForEntity("http://localhost:8000/exchange-service/{amount}/{from}/{to}", Exchange.class, params);
        book.setPrice(response.getBody().getConvertedValue().doubleValue());
        return book;
    }
}
