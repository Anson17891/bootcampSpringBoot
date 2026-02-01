package com.bootcamp.demo.demo_mtr_station.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo.demo_mtr_station.model.Train;
import com.bootcamp.demo.demo_mtr_station.model.dto.ScheduleDTO;

@Component
public class ModelMapper {
  public Train map(ScheduleDTO.StationDTO.TrainDTO trainDTO, String direction){

    return Train.builder()//
                    .destination(trainDTO.getDest())//
                    .arriveTime(trainDTO.getTime())//
                    .direction(direction)//
                    .build();
  }
}
