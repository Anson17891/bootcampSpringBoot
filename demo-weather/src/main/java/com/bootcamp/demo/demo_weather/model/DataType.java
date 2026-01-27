package com.bootcamp.demo.demo_weather.model;
//!Solution


import java.util.Arrays;

import lombok.Getter;

@Getter
public enum DataType { //in case need to see others
  NINE_DAY("fnd"),;  //

  private String value;
  private DataType (String value){
    this.value = value;
  }

  //fnd->NINE_DAY
   public static DataType of(String dataType){
    return Arrays.asList(DataType.values()).stream()//
                 .filter(e-> dataType.equals(e.getValue()))//
                 .findAny()//
                 .orElseThrow(()-> new IllegalArgumentException("Invalid data type"));
  }
}
