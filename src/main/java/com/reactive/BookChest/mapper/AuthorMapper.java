package com.reactive.BookChest.mapper;

import com.reactive.BookChest.dto.request.AuthorRequest;
import com.reactive.BookChest.dto.response.AuthorResponse;
import com.reactive.BookChest.entity.businnes.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public Author mapAuthorRequestToAuthor(AuthorRequest authorRequest){
        return Author.builder()
                .name(authorRequest.getName())
                .surname(authorRequest.getSurname())
                .build();
    }

    public AuthorResponse mapAuthorToAuthorResponse(Author author){
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();
    }
}
