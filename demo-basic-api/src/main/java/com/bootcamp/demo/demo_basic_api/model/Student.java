package com.bootcamp.demo.demo_basic_api.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Student {
  private String name;
  private int sid;
  private String clazz; //not duplicate with class (keyword)
  private LocalDate dob;
  
}
