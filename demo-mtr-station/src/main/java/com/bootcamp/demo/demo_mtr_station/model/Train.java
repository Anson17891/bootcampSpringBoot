package com.bootcamp.demo.demo_mtr_station.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
public class Train {
  private String destination;
  private LocalDateTime arriveTime;
  private String direction;


}
