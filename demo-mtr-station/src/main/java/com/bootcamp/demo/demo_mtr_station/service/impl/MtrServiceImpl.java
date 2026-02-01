package com.bootcamp.demo.demo_mtr_station.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.demo.demo_mtr_station.entity.LineEntity;
import com.bootcamp.demo.demo_mtr_station.entity.StationEntity;
import com.bootcamp.demo.demo_mtr_station.mapper.ModelMapper;
import com.bootcamp.demo.demo_mtr_station.model.Train;
import com.bootcamp.demo.demo_mtr_station.model.dto.ScheduleDTO;
import com.bootcamp.demo.demo_mtr_station.repository.LineRepository;
import com.bootcamp.demo.demo_mtr_station.repository.StationRepository;
import com.bootcamp.demo.demo_mtr_station.service.MtrService;

@Service
public class MtrServiceImpl implements MtrService{
  //encapsulate appStater

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private LineRepository lineRepository;

  @Autowired
  private StationRepository stationRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Value(value = "${external-api.mtr.domain}")
    private String domain;
  @Value(value = "${external-api.mtr.path-segment}")
  private String pathSegment;
  @Value(value = "${external-api.mtr.data.path}")
  private String path;

@Override
public ScheduleDTO getSchedule(String lineCode, String stationCode){
  String url = UriComponentsBuilder.newInstance()//
               .scheme("https")//
               .host(domain)//
               .pathSegment(pathSegment)//
               .path(path)//
               .queryParam("line", lineCode)//
               .queryParam("stn", stationCode)//
               .build()//
               .toUriString();
    System.out.println("url=" + url);
   ScheduleDTO scheduleDTO = this.restTemplate.getForObject(url, ScheduleDTO.class);
   return scheduleDTO;
}

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

    @Override
    public Map<String, List<Train>> getScheduleMap (String lineCode, String stationCode){
      ScheduleDTO scheduleDTO = this.getSchedule(lineCode, stationCode);

      Map<String, List<Train>> stationMap = new HashMap<>();

      String key = lineCode+"-"+stationCode;

      List<ScheduleDTO.StationDTO.TrainDTO> upTrains = scheduleDTO.getData().get(key).getUpTrain();
      List<ScheduleDTO.StationDTO.TrainDTO> downTrains = scheduleDTO.getData().get(key).getDownTrain();

     for(ScheduleDTO.StationDTO.TrainDTO trainDTO : upTrains){
      Train train = this.modelMapper.map(trainDTO,"UP");
      List<Train> trains = stationMap.getOrDefault(trainDTO.getDest(), new ArrayList<>());
      trains.add(train);
      stationMap.put(trainDTO.getDest(), trains);
     }

     for(ScheduleDTO.StationDTO.TrainDTO trainDTO : downTrains){
      Train train = this.modelMapper.map(trainDTO,"DOWN");
      List<Train> trains = stationMap.getOrDefault(trainDTO.getDest(), new ArrayList<>());
      trains.add(train);
      stationMap.put(trainDTO.getDest(), trains);
     }

     return stationMap;
    }
    // @Override
    // public void deleteByStationCode(String code){
    //   this.stationRepository.deleteByCode(code);
    // }

    @Override
    public List<ScheduleDTO> getByLine(String lineCode){
      LineEntity lineEntity = this.lineRepository.findByCode(lineCode).orElse(null);
      List<StationEntity> stationEntities = this.stationRepository.findByLineEntity(lineEntity);
      //!check each entities code
      List<ScheduleDTO> scheduleDTO = stationEntities.stream()//
                     .map(e -> this.getSchedule(lineCode, e.getCode()))//
                     .collect(Collectors.toList());
      return scheduleDTO;
      }



      
    }

