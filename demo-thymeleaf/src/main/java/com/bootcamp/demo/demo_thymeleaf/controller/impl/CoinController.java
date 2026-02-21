package com.bootcamp.demo.demo_thymeleaf.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.demo_thymeleaf.controller.CoinOperation;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinDTO;
import com.bootcamp.demo.demo_thymeleaf.service.CoinService;

@RestController
public class CoinController implements CoinOperation{
  @Autowired
  private CoinService coinService;

  @Override
  public List<CoinDTO> refreshCoin(){
    return this.coinService.getCoins();
  }
  
}
