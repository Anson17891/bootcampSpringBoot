package com.bootcamp.demo.demo_basic_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

//API = Application Programming interface

//! By default, variable x is matching to the URL path variable x  (Integer x <--> {x})
// @GetMapping(value = "/calculator/sum/{x}/{y}")  //inside {} are variables
//   public int sum(@PathVariable Integer x, @PathVariable Integer y)
//! Now name the variable into other names i.e.Integer salary
//use ->  @PathVariable(value = "x") define salary is x , matches URL x (Integer salary <--> {x})
//@PathVariable(value = "x") Integer salary

public class CalculatorController {   //file name must have xxxController  
  @GetMapping(value = "/calculator/sum/{x}/{y}")  //inside {} are variables
  public int sum(@PathVariable(value = "x") Integer salary, @PathVariable(value = "y") Integer bonus){
    //must not use primitives
   //variebles may be null
    return salary + bonus;

    //access "http://localhost:8080/calculator/3/10"  -> show 13
                                      //both 3 10 are Integer, match the method sum
                                      //try @PathVariable LocalDate x -> error (3 is not LocalDate)
  }

  @GetMapping(value = "/calculator/subtract/{x}/{y}") //! cannot be same pathway as sum (->add /subtract/)
   //try: same pathway -> see gitbash, search "cause by"-> "Ambiguous mapping"
   //!not show error(red underline) on JDK
  public int subtract(@PathVariable Integer x, @PathVariable Integer y){
    return x - y;
  }
  
}
