package com.hub.blog.controller;

import com.hub.blog.entity.Author;
import com.hub.blog.repository.AuthorRepository;
import com.hub.blog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        try {
            Author authorObj = authorService.addAuthor(author);
            return new ResponseEntity<>(authorObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
