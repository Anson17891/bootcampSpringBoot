package com.bootcamp.demo.demo_thymeleaf.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinDTO;
import com.bootcamp.demo.demo_thymeleaf.service.CoinService;




@Controller  // return non-json (html, xml, etc)
public class HelloworldController {

  @Autowired
  private CoinService coinService;

  @GetMapping("/hello")
  public String firstPage(Model model) {
    List<CoinDTO> coinDTOs = this.coinService.getCoins();
    model.addAttribute("coinList", coinDTOs);
    model.addAttribute("programming","Java");  
    //! Server side rendering (control front-end from server/back-end)
    //! read DB, call external api...
      return "helloworld"; //<- helloworld.html file name
      //check http://localhost:8080/hello
  }
  

  @GetMapping(value = "/coinpage")
  public String coinPage(Model model) {
      List<CoinDTO> coinDTOs = this.coinService.getCoins();
    model.addAttribute("coinList", coinDTOs);
    model.addAttribute("programming","Java"); 
    return "coinpage"; 
  }
  
  }
  
  

