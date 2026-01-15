package com.bootcamp.demo_calculator.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_calculator.dto.DTOMapper;
import com.bootcamp.demo_calculator.model.ApiRequest;
import com.bootcamp.demo_calculator.model.ApiResponse;

//Step 1 :GET /operation
//Step 2: CalculatorCoontroller Object -> call instance method calculate1
   // is the method stable?
     //stable or not-> remember result from last user(browser), which affect next result from new user
   //simutaneously 1000000users visit-> memory enough?
     //Object in spring boot -> stateless
     //if no spring boot-> create new Object x1000000 times -> memory demanded to store 10000000objects
     //Spring boot-> store Object in bean-> no need to release object's memory -> only need one object
     //see Cat, CatController
@RestController  //! @Controller + @ResponseBody

public class CalculatorController {
  @GetMapping(value = "/operation")
  public ApiResponse calculate1 (@RequestParam String x, @RequestParam String y, @RequestParam String operation) {
     double result = -1.0;
    try{
         result = calculate(Double.valueOf(x),Double.valueOf(y), operation);
      }catch(NumberFormatException e){
        //TBC
      }
      //! A Object -> B Object
       return ApiResponse.builder()//
                        .x(x)//
                        .y(y)//
                        .operation(operation)
                        .result(String.valueOf(result))//
                        .build();

      
  }

  //POST -> use RequestBody
  //http://localhost.8080/operation
  //Body,raw: { "x": "1",
  // "y": "1",
  // "operation": "ADD"}
  @PostMapping(value = "/operation")
  public ApiResponse calculate2(@RequestBody ApiRequest request) {
      double result = -1.0;
    try{
         result = calculate(Double.valueOf(request.getX()),Double.valueOf(request.getY()), request.getOperation());
      }catch(NumberFormatException e){
        //TBC
      }
       return DTOMapper.map(request.getX(), request.getY(), request.getOperation(),String.valueOf(result));

  }

  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  public ApiResponse calculate3(@PathVariable String x, @PathVariable String y, @PathVariable String operation) {
      double result = -1.0;
    try{
         result = calculate(Double.valueOf(x),Double.valueOf(x), operation);
      }catch(NumberFormatException e){
        //TBC
      }
       return ApiResponse.builder()//
                        .x(x)//
                        .y(x)//
                        .operation(operation)//
                        .result(String.valueOf(result))//
                        .build();

  }
  
  public static double calculate(double d1, double d2, String operation){
    return switch(operation){
        case "ADD" -> BigDecimal.valueOf(d1).add(BigDecimal.valueOf(d2)).doubleValue();
        case "SUB" -> BigDecimal.valueOf(d1).subtract(BigDecimal.valueOf(d2)).doubleValue();
        case "MUL" -> BigDecimal.valueOf(d1).multiply(BigDecimal.valueOf(d2)).doubleValue();
        case "DIV" -> BigDecimal.valueOf(d1).divide(BigDecimal.valueOf(d2),5,RoundingMode.HALF_UP).doubleValue();
        default -> -1.0;
      };
  }

}
