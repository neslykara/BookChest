package com.reactive.BookChest.controller;

import com.reactive.BookChest.dto.request.AuthorRequest;
import com.reactive.BookChest.dto.response.AuthorResponse;
import com.reactive.BookChest.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;


    @PostMapping("/save")
    public Mono<AuthorResponse> saveAuthor(@Valid @RequestBody AuthorRequest authorRequest){
        return authorService.saveAuthor(authorRequest);
    }
}
