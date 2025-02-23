package com.reactive.BookChest.repository;

import com.reactive.BookChest.entity.businnes.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends ReactiveCrudRepository<Book,Long> {
}
