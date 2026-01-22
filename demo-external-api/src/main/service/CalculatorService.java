package com.bootcamp.demo_calculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

@Service   //if no @service -> application fail to start, require a bean of type 'xxxxx.service.xxxxx'
public class CalculatorService {
  //!stateless
  public double calculate(double d1, double d2, String operation){  //! instant method + stateless class
    return switch(operation){
        case "ADD" -> BigDecimal.valueOf(d1).add(BigDecimal.valueOf(d2)).doubleValue();
        case "SUB" -> BigDecimal.valueOf(d1).subtract(BigDecimal.valueOf(d2)).doubleValue();
        case "MUL" -> BigDecimal.valueOf(d1).multiply(BigDecimal.valueOf(d2)).doubleValue();
        case "DIV" -> BigDecimal.valueOf(d1).divide(BigDecimal.valueOf(d2),5,RoundingMode.HALF_UP).doubleValue();
        default -> -1.0;
      };
  }
}
