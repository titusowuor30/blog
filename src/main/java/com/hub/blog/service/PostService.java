package com.hub.blog.service;

import com.hub.blog.dto.PostRequestDto;
import com.hub.blog.entity.Post;

public interface PostService {
    Post addPost(PostRequestDto postRequestDto);
}
