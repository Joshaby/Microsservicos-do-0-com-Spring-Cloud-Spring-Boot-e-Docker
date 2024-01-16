package com.joshaby.BookService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;

    private String author;

    private LocalDateTime launchDate;

    private Double price;

    private String title;

    private String currency;

    private String environment;
}
