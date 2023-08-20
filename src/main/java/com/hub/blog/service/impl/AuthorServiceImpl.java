package com.hub.blog.service.impl;

import com.hub.blog.entity.Author;
import com.hub.blog.repository.AuthorRepository;
import com.hub.blog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
}
