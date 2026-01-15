package com.bootcamp.demo_calculator.model;

import org.springframework.stereotype.Component;
//stateless  : no attribute to use
@Component  //! Create a bean of cat
public class Cat {
  public int sum(int x, int y){
    return x+y;
  }
  //in java, object have to release memory before store memory
  // in spring boot, object store in bean, wont release
  
}
