package com.bootcamp.demo.demo_weather.service;

import java.util.List;

import com.bootcamp.demo.demo_weather.model.WeatherDTO;

public interface WeatherService {
  List<WeatherDTO.WeatherForecast> getWeathers();
}

//! Solution
// public interface WeatherService {
//   WeatherDTO getWeather(DataType dataType, Lang language);  //!Polymorthism to use WeatherDTO (abstract class) 
                                                               //! for further extension (different datatype/lang)
// }
