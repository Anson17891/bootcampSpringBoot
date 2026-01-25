package com.bootcamp.demo.demo_external_api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDto {
private Long id;
private Long postId;
private String body;
}
