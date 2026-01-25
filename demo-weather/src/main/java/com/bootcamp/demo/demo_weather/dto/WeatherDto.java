package com.bootcamp.demo.demo_weather.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDto {
  private String forecastDate;
  private String maxTempValue;
  private String maxTempUnit;
  private String minTempValue;
  private String minTempUnit;
  private String maxRhValue;
  private String maxRhUnit;
  private String minRhValue;
  private String minRhUnit;
}
