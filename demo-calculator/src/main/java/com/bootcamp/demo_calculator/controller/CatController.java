package com.bootcamp.demo_calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_calculator.model.Cat;


@RestController
public class CatController {

  //! CatController Bean depends on Cat Bean
  //! Refer the reference to the bean in spring context
  @Autowired //!Injection
  private Cat cat;

  @GetMapping(value = "/cat/sum/{x}/{y}")
  public int sum(@PathVariable int x, @PathVariable int y) {
      return this.cat.sum(x,y);   //!only need one cat
      //return new Cat().sum(x,y); //<- without spring, have to create new cat -> memory demanding
                                   //! not use spring -> demand memory -> $ to buy more RAM
                                  //! use spring -> save memory -> economy!

      //!this.cat -> cat in bean (autowired + component)
      //! Null pointer exceprtion if Cat Bean is not ready (now Cat Bean is ready with autowire/component)
  }
  
}
