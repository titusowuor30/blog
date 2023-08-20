package com.hub.blog.controller;

import com.hub.blog.entity.Author;
import com.hub.blog.entity.Comment;
import com.hub.blog.service.CommentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/add/{postId}")
    public ResponseEntity<Comment> addCommentToPost(@PathVariable Long postId, @RequestBody Comment comment){
        try {
            Comment commentObj = commentService.addCommentToPost(postId,comment);
            return new ResponseEntity<>(commentObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
