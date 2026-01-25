package com.bootcamp.demo.demo_weather.service;

import java.util.List;

import com.bootcamp.demo.demo_weather.model.WeatherDTO;

public interface WeatherService {
  List<WeatherDTO.WeatherForecast> getWeathers();
}
