package com.reactive.BookChest.repository;

import com.reactive.BookChest.entity.businnes.Author;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends ReactiveCrudRepository<Author,Long> {
}
