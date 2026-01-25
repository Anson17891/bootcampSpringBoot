package com.bootcamp.demo.demo_weather.model;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class InquiryDTO {
  private Long id;
  private LocalDateTime inquiryTime;

}
