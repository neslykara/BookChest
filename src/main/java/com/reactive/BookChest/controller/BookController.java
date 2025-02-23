package com.reactive.BookChest.controller;

import com.reactive.BookChest.dto.request.BookRequest;
import com.reactive.BookChest.dto.response.BookResponse;
import com.reactive.BookChest.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/save")
    public Mono<BookResponse> saveBook(@Valid @RequestBody BookRequest bookRequest){
    return bookService.saveBook(bookRequest);
    }

    @GetMapping("/getBookById/{bookId}")
    public Mono<BookResponse>getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("/getAllBooks")
    public Flux<BookResponse>getAllBooks(){
        return bookService.getAllBooks();
    }



}
