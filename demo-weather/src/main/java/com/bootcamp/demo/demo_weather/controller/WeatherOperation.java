package com.bootcamp.demo.demo_weather.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo.demo_weather.dto.WeatherDto;


public interface WeatherOperation {
  @GetMapping(value = "/weathers")
  List<WeatherDto> getWeathers();
  
}
