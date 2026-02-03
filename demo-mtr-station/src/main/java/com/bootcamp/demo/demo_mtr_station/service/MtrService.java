package com.bootcamp.demo.demo_mtr_station.service;

import java.util.List;
import java.util.Map;

import com.bootcamp.demo.demo_mtr_station.entity.LineEntity;
import com.bootcamp.demo.demo_mtr_station.entity.StationEntity;
import com.bootcamp.demo.demo_mtr_station.model.Train;
import com.bootcamp.demo.demo_mtr_station.model.dto.ScheduleDTO;


public interface MtrService {
  LineEntity saveLine(String lineCode, String lineDesc);
  StationEntity saveStation(String lineCode, String StationCode, String StationDesc, String prevCode, String nextCode);
  void deleteAllLines();  
  void deleteAllStations();

  // void deleteByStationCode(String code);
  // void deleteByLineCode(String code);

  // StationEntity getByStationCode (String code);

  ScheduleDTO getSchedule(String lineCode, String stationCode);

  //"TKO", Train Object;
  Map<String, List<Train>>getScheduleMap(String lineCode, String stationCode);
  
  List<ScheduleDTO> getByLine(String lineCode);
  

  //!part3 solution
  List<StationEntity> getStations(String lineCode);
}
