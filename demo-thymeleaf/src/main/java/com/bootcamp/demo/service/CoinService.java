package com.bootcamp.demo.service;

import java.util.List;

import com.bootcamp.demo.model.dto.CoinDTO;


public interface CoinService {
 
  List<CoinDTO> getCoins();
}
