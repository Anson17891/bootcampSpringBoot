package com.bootcamp.demo.demo_weather.mapper;

import com.bootcamp.demo.demo_weather.dto.WeatherDto;
import com.bootcamp.demo.demo_weather.model.WeatherDTO;

public class DtoMapper {
  public WeatherDto map(WeatherDTO.WeatherForecast weatherForecast){
    return WeatherDto.builder()//
                        .forecastDate(weatherForecast.getForecastDate())//
                        .maxTempValue(weatherForecast.getMaxTemp().getValue())//
                        .maxTempUnit(weatherForecast.getMaxTemp().getUnit())//
                        .minTempValue(weatherForecast.getMinTemp().getValue())//
                        .minTempUnit(weatherForecast.getMinTemp().getUnit())//
                        .maxRhValue(weatherForecast.getMaxRh().getValue())//
                        .maxRhUnit(weatherForecast.getMaxRh().getUnit())//
                        .minRhValue(weatherForecast.getMinRh().getValue())//
                        .minRhUnit(weatherForecast.getMinRh().getUnit())//
                        .build();
  }
}


//!Solution
// @Component  //!or @Bean in config
// public class DtoMapper{
//   public WeatherDto map(NineDayDTO.ForecastDTO forecastDTO){   //for NineDayDTO, see WeatherDTO
//     return WeatherDto.builder()//
//                         .forecastDate(forecastDTO.getForecastDate())//
//                         .maxTempValue(forecastDTO.getForecastMaxTemp().getValue())//
//                         .minTempValue(forecastDTO.getForecastMinTemp().getValue())//
//                         .maxRhValue(forecastDTO.getForecastMaxRh().getValue())//
//                         .minRhValue(forecastDTO.getForecastMinRh().getValue())//
//                         .build();
//   }
// }
