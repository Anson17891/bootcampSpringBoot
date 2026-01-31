package com.bootcamp.demo.demo_mtr_station.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo.demo_mtr_station.controller.MtrOperation;
import com.bootcamp.demo.demo_mtr_station.dto.EarliestScheduleDTO;
import com.bootcamp.demo.demo_mtr_station.entity.StationEntity;
import com.bootcamp.demo.demo_mtr_station.model.Train;
import com.bootcamp.demo.demo_mtr_station.model.dto.ScheduleDTO;
import com.bootcamp.demo.demo_mtr_station.service.MtrService;

public class MtrController implements MtrOperation{
@Autowired
  private MtrService mtrService;

  @Override
  public StationEntity createStation(String lineCode,StationEntity stationEntity){

    return this.mtrService.saveStation(lineCode//
                                      ,stationEntity.getCode()//
                                      ,stationEntity.getDescription()//
                                      ,stationEntity.getPrevCode()//
                                      ,stationEntity.getNextCode());
  }

  @Override
  public ScheduleDTO getSchedule(String line, String station){
    return this.mtrService.getSchedule(line, station);
  }

  @Override
 public EarliestScheduleDTO getEarliestSchedule(String line, String station){
  ScheduleDTO scheduleDTO = this.mtrService.getSchedule(line,station);
      EarliestScheduleDTO earliestScheduleDTO = EarliestScheduleDTO.builder()//
                                                                  .currTime(scheduleDTO.getCurrTime())//
                                                                  .sysTime(scheduleDTO.getSysTime())//
                                                                  .currentStation(station)//
                                                                  .trains(new ArrayList<>())//  for directly add earliest train
                                                                  .build();

   Map<String, List<Train>> stationMap = this.mtrService.getScheduleMap(line,station);
   for(List<Train> trains : stationMap.values()){
    Optional<Train> earliest = trains.stream()//
    .min((t1,t2)->t1.getArriveTime().isBefore(t2.getArriveTime())?-1:1);
  
   earliest.ifPresent(e->{//
    earliestScheduleDTO.getTrains().add(e);});
    
 }
 return earliestScheduleDTO;
 }
//   @Override
//  public Map<String, List<Train>>getScheduleMap(String line, String station){
//   return this.mtrService.getScheduleMap(line, station);
//  }
}
