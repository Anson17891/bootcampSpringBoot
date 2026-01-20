package com.bootcamp.demo_calculator.dto;

import com.bootcamp.demo_calculator.model.ApiResponse;


//Data transfer Object
public class DTOMapper {
  public static ApiResponse map(String x, String y, String operation, String result){
    return ApiResponse.builder()//
    .x(x)//
    .y(y)//
    .operation(operation)//
    .result(result)//
    .build();
  }
  
}
