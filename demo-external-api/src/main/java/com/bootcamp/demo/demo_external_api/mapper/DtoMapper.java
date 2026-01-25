package com.bootcamp.demo.demo_external_api.mapper;

import com.bootcamp.demo.demo_external_api.dto.CommentDto;
import com.bootcamp.demo.demo_external_api.dto.PostDto;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;


public class DtoMapper { //two methods to become bean, 1. see AppConfig

  public UserDto map(UserDTO userDTO){
      return UserDto.builder().id(userDTO.getId())//
      .email(userDTO.getEmail()).phone(userDTO.getPhone())//
      .name(userDTO.getName()).build();
  }

  public PostDto postMap(PostDTO postDTO){
    return PostDto.builder().id(postDTO.getId())//
    .title(postDTO.getTitle()).body(postDTO.getBody()).build();
  }

  public CommentDto commentMap(CommentDTO commentDTO){
    return CommentDto.builder()//
    .id(commentDTO.getId())//
    .postId(commentDTO.getPostId())//
    .body(commentDTO.getBody()).build();
  }
  
}
