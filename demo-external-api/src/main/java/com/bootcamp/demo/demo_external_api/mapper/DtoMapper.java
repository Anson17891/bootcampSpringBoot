package com.bootcamp.demo.demo_external_api.mapper;

import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;


public class DtoMapper { //two methods to become bean, 1. see AppConfig

  public UserDto map(UserDTO userDTO){
      return UserDto.builder().id(userDTO.getId())//
      .email(userDTO.getEmail()).phone(userDTO.getPhone())//
      .name(userDTO.getName()).build();
  }
  
}
