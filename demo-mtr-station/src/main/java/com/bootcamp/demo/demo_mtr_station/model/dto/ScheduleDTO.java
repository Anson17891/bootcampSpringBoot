package com.bootcamp.demo.demo_mtr_station.model.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
@Getter
public class ScheduleDTO {
  //data ->Map
  //"TKL-TKO" ->key in map
  @JsonProperty(value = "sys_time")
   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime sysTime;
  @JsonProperty(value = "curr_time")
   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime currTime;
  private HashMap<String,StationDTO> data;
  private String isDelay;
  private Integer status;
  private String message;

  @Getter
  public class StationDTO{
    @JsonProperty(value = "sys_time")
   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime sysTime;
    @JsonProperty(value = "curr_time")
   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime currTime;
  @JsonProperty(value = "UP")
  private List<TrainDTO> upTrain;
  @JsonProperty(value = "DOWN")
  private List<TrainDTO> downTrain;

@Getter
  public class TrainDTO{
   private String seq;
   private String dest;
   private String plat;
   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
   private LocalDateTime time;
   private String ttnt;
   private String valid;
   private String source;
  }
 
  }
}
