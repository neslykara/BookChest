package com.reactive.BookChest.service;

import com.reactive.BookChest.dto.messages.ErrorMessages;
import com.reactive.BookChest.dto.request.BookRequest;
import com.reactive.BookChest.dto.response.BookResponse;
import com.reactive.BookChest.entity.businnes.Book;
import com.reactive.BookChest.exception.ResourceNotFoundException;
import com.reactive.BookChest.mapper.BookMapper;
import com.reactive.BookChest.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public Mono<BookResponse> saveBook(BookRequest bookRequest) {
        return bookRepository.save(bookMapper.mapBookRequestToBook(bookRequest))
                .map(bookMapper::mapBookToBookResponse);
    }

    public Mono<BookResponse> getBookById(Long bookId) {
        return isBookExistById(bookId)
                .map(bookMapper::mapBookToBookResponse);
    }

    public Mono<Book> isBookExistById(Long bookId){
        return bookRepository.findById(bookId)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_BOOK_MESSAGE,bookId))));
    }

    public Flux<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .map(bookMapper::mapBookToBookResponse);
    }
}
