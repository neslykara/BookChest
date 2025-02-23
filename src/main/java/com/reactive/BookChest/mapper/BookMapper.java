package com.reactive.BookChest.mapper;

import com.reactive.BookChest.dto.request.BookRequest;
import com.reactive.BookChest.dto.response.BookResponse;
import com.reactive.BookChest.entity.businnes.Author;
import com.reactive.BookChest.entity.businnes.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book mapBookRequestToBook(BookRequest bookRequest){
        return Book.builder()
                .title(bookRequest.getTitle())
                .author(bookRequest.getAuthor())
                .publishedYear(bookRequest.getPublishedYear())
                .pageCount(bookRequest.getPageCount())
                .build();
    }

    public BookResponse mapBookToBookResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publishedYear(book.getPublishedYear())
                .pageCount(book.getPageCount())
                .build();

    }


}
