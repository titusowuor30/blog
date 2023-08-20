package com.hub.blog.service.impl;

import com.hub.blog.entity.Comment;
import com.hub.blog.entity.Post;
import com.hub.blog.repository.CommentRepository;
import com.hub.blog.repository.PostRepository;
import com.hub.blog.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addCommentToPost(Long postId, Comment comment) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            comment.setPost(post);
            commentRepository.save(comment);
            return commentRepository.save(comment);
        } else {
            throw new EntityNotFoundException("Post not found with id: " + postId);
        }
    }
}
