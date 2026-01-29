package com.bootcamp.demo.demo_mtr_station.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo.demo_mtr_station.entity.LineEntity;
import com.bootcamp.demo.demo_mtr_station.entity.StationEntity;
import com.bootcamp.demo.demo_mtr_station.repository.LineRepository;
import com.bootcamp.demo.demo_mtr_station.repository.StationRepository;
import com.bootcamp.demo.demo_mtr_station.service.MtrService;

@Service
public class MtrServiceImpl implements MtrService{
  //encapsulate appStater

  @Autowired
  private LineRepository lineRepository;

  @Autowired
  private StationRepository stationRepository;

  @Override
  public LineEntity saveLine(String lineCode, String lineDesc){
    LineEntity lineEntity = LineEntity.builder()//
                                      .code(lineCode)//
                                      .description(lineDesc)//
                                      .build();
    return this.lineRepository.save(lineEntity);
  }

  @Override
  public StationEntity saveStation(String lineCode, String stationCode, String stationDesc, String prevCode, String nextCode){
    //findByCode -> LineEntity
    //Prepare StationEntity -> set FK
    //save
   LineEntity lineEntity = this.lineRepository.findByCode(lineCode)//
                           .orElseThrow(() -> new IllegalArgumentException("Line not Found."));  //Optional -> use orElseFlow
    StationEntity stationEntity = StationEntity.builder()//
                                           .code(stationCode)//
                                           .description(stationDesc)//
                                           .lineEntity(lineEntity)//
                                           .prevCode(prevCode)//
                                           .nextCode(nextCode)//
                                           .build();
    return this.stationRepository.save(stationEntity);
  }

    @Override
    public void deleteAllLines(){
      this.lineRepository.deleteAll();

    }

    @Override
    public void deleteAllStations(){
      this.stationRepository.deleteAll();
    }

  
}
