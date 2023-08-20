package com.hub.blog.dto;

import lombok.Data;

@Data
public class PostRequestDto {
    private String title;
    private String content;
    private Long authorId;
}

