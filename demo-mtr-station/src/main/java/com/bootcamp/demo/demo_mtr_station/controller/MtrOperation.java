package com.bootcamp.demo.demo_mtr_station.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.demo_mtr_station.entity.StationEntity;


@RestController
public interface MtrOperation {



  @PostMapping("/line/{code}/station")
  StationEntity createStation(@PathVariable String lineCode, @RequestBody StationEntity stationEntity); 
 //usually not directly create entity, but DTO(with desinated fields)
}
