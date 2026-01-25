package com.bootcamp.demo.demo_weather.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_weather.controller.WeatherOperation;
import com.bootcamp.demo.demo_weather.dto.WeatherDto;
import com.bootcamp.demo.demo_weather.mapper.DtoMapper;
import com.bootcamp.demo.demo_weather.service.WeatherService;

@RestController
public class WeatherController implements WeatherOperation{
  @Autowired
  private WeatherService weatherService;
  @Autowired
  private DtoMapper dtoMapper;

  @Override
  public List<WeatherDto> getWeathers(){
    return this.weatherService.getWeathers().stream()//
                              .map(e -> this.dtoMapper.map(e))//
                              .collect(Collectors.toList());
  }
}
