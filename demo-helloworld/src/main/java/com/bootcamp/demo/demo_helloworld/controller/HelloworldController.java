package com.bootcamp.demo.demo_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@ResponseBody
public class HelloworldController {
  
//   //! Bridge between client side and server side -> API
// @GetMapping(value = "/bootcamp") // "/" is needed    try: "/hongkong/bootcamp" + change web address
//   public String helloWorld(){
//     System.out.println("How are you?"); //! not shown in client side, only in gitbash/log
//     //2ms, not used in normal case
//     //-> use in error case (try/catch)
//     return "Helloworld";

//   }
    //save .java, gitbash: cd to folder, mvn spring-boot:run (run .jar)  start server
    //go to http://localhost:8080/bootcamp   <---client side
                              // ^ value = "/bootcamp"
    //localhost IP: 127.0.0.1
    //port: 8080
    //stop server: ctrl + C
    
    //  ---> : asscess  IP
    //client A ----message--->Whatsapp server----message--->clientB
    //client A <---double ticks---Whatsapp server <---Readed---clientB


    //! aws   7/2/2026------------------------
@GetMapping(value = "/hello/java") 
  public String hello(){
    return "Helloworld";
  }

  @GetMapping(value = "/hello/python") 
  public String goodbye(){
    return "GoodBye";
  }
  }

