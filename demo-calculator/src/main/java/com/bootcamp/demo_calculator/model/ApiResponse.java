package com.bootcamp.demo_calculator.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;



@Getter
@AllArgsConstructor
@Builder

public class ApiResponse {
  private final String x;
  private final String y;
  private final String operation;
  private final String result;
  
  
}
