package com.bootcamp.demo.demo_weather.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo.demo_weather.entity.WeatherEntity;
import com.bootcamp.demo.demo_weather.model.WeatherDTO;
@Component
public class EntityMapper {
  public WeatherEntity map(WeatherDTO.WeatherForecast weatherForecast){
    return WeatherEntity.builder()//
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
// @Component  //or @Bean in config
// public class EntityMapper {
//   public NineDayEntity map(NineDatEneity.ForecastDTO dto){
//     return NineDatEntity.builder()//
//            .forecastDate(dto.getForecastDate())//
//            .maxTemp(BigDecimal.valueOf(dto.getForecastMaxtemp().getValue()))//
//            .minTemp(BigDecimal.valueOf(dto.getForecastinxtemp().getValue()))//
//            .maxRh(BigDecimal.valueOf(dto.getForecastMaxRh().getValue()))//
//            .minRh(BigDecimal.valueOf(dto.getForecastMinRh().getValue()))//
//            .build();
//   }
// }
