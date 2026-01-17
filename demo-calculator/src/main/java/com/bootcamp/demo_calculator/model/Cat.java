package com.bootcamp.demo_calculator.model;

import org.springframework.stereotype.Component;
//stateless  : no attribute to use, methods in the object have no dependency with the object
                                         //object is just a container of methods
@Component  //! Create a bean of cat, put in spring context
//if no @Component, only @Autowired -> error (application fail to start)
public class Cat {
  public int sum(int x, int y){ //! instance method but not using Cat's attribute
    return x+y;                 //! see DemoStatic.java
  }
  //in java, object have to release memory before store memory
  // in spring boot, object store in bean, wont release
  




  public static void main(String[] args) {
    new Cat().sum(1,2);

  //!without spring, using instance method without using attribute -> waste memory
  //! In Spring, Bean (Single object in memory - aka Spring Context)
      // @Autowired private Cat cat
      // this.cat.sum(1,2)   <-no create new Object -> not so waste memory
  }
}
