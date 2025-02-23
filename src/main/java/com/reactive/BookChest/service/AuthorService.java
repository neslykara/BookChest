package com.reactive.BookChest.service;

import com.reactive.BookChest.dto.messages.ErrorMessages;
import com.reactive.BookChest.dto.request.AuthorRequest;
import com.reactive.BookChest.dto.response.AuthorResponse;
import com.reactive.BookChest.entity.businnes.Author;
import com.reactive.BookChest.exception.ResourceNotFoundException;
import com.reactive.BookChest.mapper.AuthorMapper;
import com.reactive.BookChest.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;





    public Mono<Author> findAuthorById(Long authorId){
        return authorRepository.findById(authorId)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(String.format(ErrorMessages.NOT_FOUND_AUTHOR_MESSAGE))));
    }

    public Mono<AuthorResponse> saveAuthor(AuthorRequest authorRequest) {
        return authorRepository.save(authorMapper.mapAuthorRequestToAuthor(authorRequest))
                .map(authorMapper::mapAuthorToAuthorResponse);
    }
}
