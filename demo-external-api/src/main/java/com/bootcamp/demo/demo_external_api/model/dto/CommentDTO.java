package com.bootcamp.demo.demo_external_api.model.dto;

import lombok.Getter;

@Getter
public class CommentDTO {
private Long id;

private Long postId;

private String name;
private String email;
private String body;
}
