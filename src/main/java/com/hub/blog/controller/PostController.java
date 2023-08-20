package com.hub.blog.controller;

import com.hub.blog.dto.PostRequestDto;
import com.hub.blog.entity.Author;
import com.hub.blog.entity.Post;
import com.hub.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public ResponseEntity<Post> addPost(@RequestBody PostRequestDto postRequestDto) {
        try {
            Post postObj = postService.addPost(postRequestDto);
            return new ResponseEntity<>(postObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
