package com.hub.blog.service;

import com.hub.blog.entity.Comment;

public interface CommentService {

    Comment addCommentToPost(Long postId, Comment comment);
}
