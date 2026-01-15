package com.bootcamp.demo_calculator.model;


import lombok.Builder;
import lombok.Getter;



@Getter

@Builder

public class ApiResponse {

    public static Object builder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
  private String x;
  private String y;
  private String operation;
  private String result;
  
  
}
