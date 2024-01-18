package com.joshaby.BookService.repositories;

import com.joshaby.BookService.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
