package com.bootcamp.demo.demo_external_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class UserDto {  //low case of "to", prevent name-crash with DTO
  private Long id;
  private String name;   //let customer require only these attributes
  private String email;
  private String phone;
}
