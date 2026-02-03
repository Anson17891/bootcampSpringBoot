package com.bootcamp.demo.demo_mtr_station.controller;

import com.bootcamp.demo.demo_mtr_station.dto.EarliestScheduleDTO;
import com.bootcamp.demo.demo_mtr_station.dto.LineSignalDTO;
import com.bootcamp.demo.demo_mtr_station.entity.StationEntity;
import com.bootcamp.demo.demo_mtr_station.model.dto.ScheduleDTO;

import java.util.*;


public interface MtrOperation {



  StationEntity createStation(String lineCode,StationEntity stationEntity); 
 //usually not directly create entity, but DTO(with desinated fields)


//  @GetMapping("/station")
//  StationEntity getByStationCode(@RequestParam String code);
//  @GetMapping("/line")
//  LineEntity getByLineCode(@RequestParam String code);

//  @DeleteMapping("/station/{code}")
//  void deleteByStationCode(@PathVariable String code);
//  @DeleteMapping("/line/{code}")
//  void deleteByLineCode(@PathVariable String code);
 


 ScheduleDTO getSchedule(String line, String station);
 
//  @GetMapping("/mtr/schedulemap")   //should not give customer Map with full data
//  Map<String, List<Train>> getScheduleMap(@RequestParam String line, @RequestParam String station);

EarliestScheduleDTO getEarliestSchedule(String line, String station);



LineSignalDTO getLineSignal(String line);




//!part3 solution
// @GerMapping(value = "/signal")
// SignalDto getSignal(@RequestParam String lineCode);


//------------3/2/2026------------------------


List<StationEntity> getStations(String lineCode);
}



