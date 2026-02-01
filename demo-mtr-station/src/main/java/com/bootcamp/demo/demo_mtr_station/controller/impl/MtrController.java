package com.bootcamp.demo.demo_mtr_station.controller.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.demo_mtr_station.controller.MtrOperation;
import com.bootcamp.demo.demo_mtr_station.dto.EarliestScheduleDTO;
import com.bootcamp.demo.demo_mtr_station.dto.LineSignalDTO;
import com.bootcamp.demo.demo_mtr_station.entity.StationEntity;
import com.bootcamp.demo.demo_mtr_station.model.Train;
import com.bootcamp.demo.demo_mtr_station.model.dto.ScheduleDTO;
import com.bootcamp.demo.demo_mtr_station.service.MtrService;
@RestController
public class MtrController implements MtrOperation{
@Autowired
  private MtrService mtrService;

  @PostMapping("/line/{code}/station")
  @Override
  public StationEntity createStation(@PathVariable String lineCode, @RequestBody StationEntity stationEntity){

    return this.mtrService.saveStation(lineCode//
                                      ,stationEntity.getCode()//
                                      ,stationEntity.getDescription()//
                                      ,stationEntity.getPrevCode()//
                                      ,stationEntity.getNextCode());
  }
 @GetMapping("/mtr/schedule")
  @Override
  public ScheduleDTO getSchedule(@RequestParam String line, @RequestParam String station){
    return this.mtrService.getSchedule(line, station);
  }

@GetMapping("/mtr/schedulemap")
  @Override
 public EarliestScheduleDTO getEarliestSchedule(@RequestParam String line, @RequestParam String station){
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


@GetMapping("/mtr/signal")
@Override
public LineSignalDTO getLineSignal(@RequestParam String line){
   List<ScheduleDTO> scheduleDTOs = this.mtrService.getByLine(line);
   List<String> delayedStations = new ArrayList<>();
   LocalDateTime currTime = scheduleDTOs.getLast().getCurrTime();
   LocalDateTime sysTime = scheduleDTOs.getLast().getSysTime();

   for(ScheduleDTO s : scheduleDTOs){
        if(s.getIsDelay()!=null && "Y".equals(s.getIsDelay())){
          Set<String> stationCode = s.getData().keySet();
          stationCode.forEach(key -> 
            delayedStations.add(key.substring(4)));
        }
      }

   String signal = switch(delayedStations.size()){
    case 0 -> "GREEN";
    case 1 -> "YELLOW";
    default -> "RED";
   };
  
   return LineSignalDTO.builder()//
                       .line(line)//
                       .signal(signal)//
                       .delayedStations(delayedStations)//
                       .currTime(currTime)//
                       .sysTime(sysTime)//
                       .build();

}




}

