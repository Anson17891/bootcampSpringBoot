package com.bootcamp.demo.demo_mtr_station.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bootcamp.demo.demo_mtr_station.repository.LineRepository;
import com.bootcamp.demo.demo_mtr_station.repository.StationRepository;
import com.bootcamp.demo.demo_mtr_station.service.MtrService;

@Component
public class AppStarter implements CommandLineRunner{
  @Autowired
  private LineRepository lineRepository;

  @Autowired
  private StationRepository stationRepository;

  @Autowired
  private MtrService mtrService;
  
  @Override
  public void run(String... args) throws Exception{
    //! once server starts, run this programme once
    //! ->Pre-check , ensure server runs successfully 
   
    this.mtrService.deleteAllStations();
    this.mtrService.deleteAllLines();   //ensure no insert datas again and again
    

    //insert lines & stations
   this.mtrService.saveLine("AEL", "airport_express");
   this.mtrService.saveLine("TCL","tung_chung_line");

   this.mtrService.saveStation("AEL","HOK","Hong Kong",null,"KOW");
   this.mtrService.saveStation("AEL","KOW","Kowloon","HOK","TSY");
   this.mtrService.saveStation("AEL","TSY","Tsing Yi","AIR","KOW");
   this.mtrService.saveStation("AEL","AIR","Airport","TSY","AWE");
   this.mtrService.saveStation("AEL","AWE","Asiaworld Expo","AIR",null);

   this.mtrService.saveStation("TCL","HOK","Hong Kong",null,"KOW");
   this.mtrService.saveStation("TCL","KOW","Kowloon","HOK","OLY");
   this.mtrService.saveStation("TCL","OLY","Olympic","KOW","NAC");
   this.mtrService.saveStation("TCL","NAC","Nam Cheong","OLY","LAK");
   this.mtrService.saveStation("TCL","LAK","Lai King","NAC","TSY");
   this.mtrService.saveStation("TCL","TSY","Tsing Yi","LAK","SUN");
   this.mtrService.saveStation("TCL","SUN","Sunny Bay","TSY","TUC");
   this.mtrService.saveStation("TCL","TUC","Tung Chung","SUN",null);
   
   
  }
}
