package com.bootcamp.demo.demo_basic_api.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Student {
  private String name;
  private Long id;
  private String clazz; //not duplicate with class (keyword)
  private LocalDate dob;
  
}
