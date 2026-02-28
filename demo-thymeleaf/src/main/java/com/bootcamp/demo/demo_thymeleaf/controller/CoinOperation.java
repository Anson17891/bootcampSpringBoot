package com.bootcamp.demo.demo_thymeleaf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinDTO;


public interface CoinOperation {


  @CrossOrigin
  @GetMapping(value = "/refresh")
  List<CoinDTO> refreshCoin();
}
