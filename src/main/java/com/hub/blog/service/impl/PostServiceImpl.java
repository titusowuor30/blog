package com.hub.blog.service.impl;

import com.hub.blog.dto.PostRequestDto;
import com.hub.blog.entity.Author;
import com.hub.blog.entity.Post;
import com.hub.blog.repository.AuthorRepository;
import com.hub.blog.repository.PostRepository;
import com.hub.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Post addPost(PostRequestDto postRequestDto) {
        Post post = new Post();
        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());

        // Fetch author by ID or handle author details as needed
        Author author = authorRepository.findById(postRequestDto.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("Author not found"));
        post.setAuthor(author);
        return postRepository.save(post);
    }
}
