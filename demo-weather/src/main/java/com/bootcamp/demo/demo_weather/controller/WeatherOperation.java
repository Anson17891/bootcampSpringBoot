package com.bootcamp.demo.demo_weather.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.demo.demo_weather.dto.WeatherDto;


public interface WeatherOperation {
  @GetMapping(value = "/weathers")
  List<WeatherDto> getWeathers();
  
}


//!Solution
// public interface WeatherOperation {
//   @GetMapping(value = "/weathers")
//   List<NineDayDto> getWeathers(@RequestParam String dataType, @RequestParam String lang);

//   @GetMapping(value = "/weathers/forecast_date")
//  ResponseEntity<NineDayEntity> findByForecastDate(@RequestParam LocalDate forecastDate);

//  @GetMapping(value = "/weathers/max_degree/greater_than_equal")
//  ResponseEntity<NineDayEntity>  findByMaxTempGreaterThanEqual(@RequestParam Double degree)

//  @GetMapping(value = "/weathers/tran_time/between")
//  ResponseEntity<NineDayEntity> findByTranTimeBetween(@RequestParam LocalDateTime startDateTime, @RequestParam LocalDateTime endDateTime)



// }
