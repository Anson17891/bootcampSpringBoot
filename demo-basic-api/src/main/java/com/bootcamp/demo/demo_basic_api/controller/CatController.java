package com.bootcamp.demo.demo_basic_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_basic_api.model.Cat;




@Controller
@ResponseBody

public class CatController {
  @GetMapping("/cat/createCat/{name}/{age}")
  public Cat createCat(@PathVariable String name, @PathVariable Integer age) {
      return new Cat(name, age); //{"name":"Steven","age":3}
  }

  //return Cat[], input one cat
  @GetMapping("/cat/createCats/{name}/{age}")
  public Cat[] createCats(@PathVariable String name, @PathVariable Integer age) {
    // Cat[] cats = new Cat[5];
    // String[] names = {name,name,name,name,name};
    // int[] ages = {age,age,age,age,age};
    // for(int i = 0; i<cats.length;i++){
    // cats[i] = new Cat(names[i], ages[i]);
    // }
    //   return cats;
     return new Cat[] {new Cat(name, age)};
  }

  //Class -> LocalDate, LocalDayTime, BigDecimal, double...
  
  
}
