package com.bootcamp.demo.demo_mtr_station.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.bootcamp.demo.demo_mtr_station.model.Train;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EarliestScheduleDTO { //tailor made for customer
    @JsonProperty(value = "curr_time")
   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime currTime;
  @JsonProperty(value = "sys_time")
   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime sysTime;
    private String currentStation;
    private List<Train> trains;


}
