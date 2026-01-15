package com.bootcamp.demo_calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_calculator.model.Cat;


@RestController
public class CatController {
  @Autowired //Injection
  private Cat cat;

  @GetMapping(value = "/cat/sum/{x}/{y}")
  public int sum(@PathVariable int x, @PathVariable int y) {
      return this.cat.sum(x,y);   //only need one cat
      //return new Cat().sum(x,y); //<- in java, have to create new cat -> memory demanding
  }
  
}
