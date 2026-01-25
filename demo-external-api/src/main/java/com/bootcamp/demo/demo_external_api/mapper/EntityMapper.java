package com.bootcamp.demo.demo_external_api.mapper;

import com.bootcamp.demo.demo_external_api.entity.CommentEntity;
import com.bootcamp.demo.demo_external_api.entity.PostEntity;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;

public class EntityMapper {
  public UserEntity map(UserDTO userDTO){
    return UserEntity.builder()//
                     .id(userDTO.getId())//
                     .name(userDTO.getName())//
                     .street(userDTO.getAddress().getStreet())//
                     .companyName(userDTO.getCompany().getName())//
                     .build();
  }

  public PostEntity map(PostDTO postDTO){
    return PostEntity.builder()//
                     .title(postDTO.getTitle())//
                     .body(postDTO.getBody())//
                     .build();
  }

  public CommentEntity map(CommentDTO commentDTO){
    return CommentEntity.builder()//
                     .name(commentDTO.getName())//
                     .email(commentDTO.getEmail())//
                     .body(commentDTO.getBody())//
                     .build();
  }
}
