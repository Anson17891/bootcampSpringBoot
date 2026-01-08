package com.bootcamp.demo.demo_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@ResponseBody
public class HelloworldController {
  
@GetMapping(value = "/bootcamp") // "/" is needed
  public String hello(){
    return "Helloworld";

    //save -> .java, mvn spring-boot:run (run .jar)
    //go to http://localhost:8080/bootcamp
  }
}
