package com.bootcamp.demo.demo_mtr_station.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.demo_mtr_station.dto.EarliestScheduleDTO;
import com.bootcamp.demo.demo_mtr_station.entity.StationEntity;
import com.bootcamp.demo.demo_mtr_station.model.Train;
import com.bootcamp.demo.demo_mtr_station.model.dto.ScheduleDTO;



@RestController
public interface MtrOperation {



  @PostMapping("/line/{code}/station")
  StationEntity createStation(@PathVariable String lineCode, @RequestBody StationEntity stationEntity); 
 //usually not directly create entity, but DTO(with desinated fields)


//  @GetMapping("/station")
//  StationEntity getByStationCode(@RequestParam String code);
//  @GetMapping("/line")
//  LineEntity getByLineCode(@RequestParam String code);

//  @DeleteMapping("/station/{code}")
//  void deleteByStationCode(@PathVariable String code);
//  @DeleteMapping("/line/{code}")
//  void deleteByLineCode(@PathVariable String code);
 

 @GetMapping("/mtr/schedule")
 ScheduleDTO getSchedule(@RequestParam String line, @RequestParam String station);
 
//  @GetMapping("/mtr/schedulemap")   //should not give customer Map with full data
//  Map<String, List<Train>> getScheduleMap(@RequestParam String line, @RequestParam String station);

@GetMapping("/mtr/schedulemap")
EarliestScheduleDTO getEarliestSchedule(@RequestParam String line, @RequestParam String station);
}
