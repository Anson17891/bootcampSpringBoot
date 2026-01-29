package com.bootcamp.demo.demo_mtr_station.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.demo.demo_mtr_station.controller.MtrOperation;
import com.bootcamp.demo.demo_mtr_station.entity.StationEntity;
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
}
