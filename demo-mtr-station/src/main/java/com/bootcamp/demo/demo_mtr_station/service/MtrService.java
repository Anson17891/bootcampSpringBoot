package com.bootcamp.demo.demo_mtr_station.service;

import com.bootcamp.demo.demo_mtr_station.entity.LineEntity;
import com.bootcamp.demo.demo_mtr_station.entity.StationEntity;

public interface MtrService {
  LineEntity saveLine(String lineCode, String lineDesc);
  StationEntity saveStation(String lineCode, String StationCode, String StationDesc, String prevCode, String nextCode);
  void deleteAllLines();  
  void deleteAllStations();
}
