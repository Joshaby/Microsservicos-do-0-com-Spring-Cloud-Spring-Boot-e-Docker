package com.joshaby.BookService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 180)
    private String author;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDateTime launchDate;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String title;

    @Transient
    private String currency;

    @Transient
    private String environment;
}
