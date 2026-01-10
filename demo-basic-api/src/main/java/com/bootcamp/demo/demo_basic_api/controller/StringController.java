package com.bootcamp.demo.demo_basic_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class StringController {
  @GetMapping(value = "/string/{x}/{y}")
public String concatFirstChar(@PathVariable(value = "x") String firstWord,@PathVariable String y){
  // String z = "";
  // String space = " ";
  // String star = "*";
  //for(int i = 0; i<5; i++){
  //   for(int j = 0; j<11;j++){
  //  if(i<11/2+j)
  //}
  //}

  return ""+firstWord.charAt(0)+y.charAt(0); // input: "hello", "world" ,expect "hw"
       //firstWord.charAt(0)+y.charAt(0)+""; // input: "hello", "world" ,->"223" <-char+char=int+int
}
}
