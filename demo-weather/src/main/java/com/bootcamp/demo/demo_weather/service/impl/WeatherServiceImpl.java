package com.bootcamp.demo.demo_weather.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.demo.demo_weather.entity.InquiryEntity;
import com.bootcamp.demo.demo_weather.entity.WeatherEntity;
import com.bootcamp.demo.demo_weather.mapper.EntityMapper;
import com.bootcamp.demo.demo_weather.model.WeatherDTO;
import com.bootcamp.demo.demo_weather.repository.InquiryRepository;
import com.bootcamp.demo.demo_weather.repository.WeatherRepository;
import com.bootcamp.demo.demo_weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{
@Value("${weather.data.domain}")  //$ reading yml path
private String domain;
@Value("${weather.data.path}")  //$ reading yml path
private String path;

@Autowired
private RestTemplate restTemplate;
  @Autowired
private WeatherRepository weatherRepository;
@Autowired
private EntityMapper entityMapper;

@Autowired
private InquiryRepository inquiryRepository;

@Override
  public List<WeatherDTO.WeatherForecast> getWeathers(){
 String url = UriComponentsBuilder.newInstance()//
                                  .scheme("https")//
                                  .host(this.domain)//
                                  .path(this.path)//
                                  .queryParam("dataType", "fnd")//
                                  .queryParam("lang", "en")//
                                  .build()//
                                  .toUriString();
 System.out.println("url=" + url);

 List<WeatherDTO.WeatherForecast> weatherForecasts = this.restTemplate.getForObject(url, WeatherDTO.class).getWeatherForecasts();

InquiryEntity inquiry = new InquiryEntity();
inquiry.setInquiryTime(LocalDateTime.now());





 List<WeatherEntity> weatherEntities = weatherForecasts.stream()//
                                         .map(e -> this.entityMapper.map(e))//
                                         .sorted((e1,e2)->e1.getForecastDate().compareTo(e2.getForecastDate()))//
                                         .peek(e -> e.setInquiry(inquiry))//
                                         .collect(Collectors.toList());

inquiry.setWeatherEntities(weatherEntities);
inquiryRepository.save(inquiry);





return weatherForecasts;
} 
}



//!Solution
// @Servicepubic class WeatherServiceImpl implements WeatherService{
//  @Autowired
// private NineDayService nineDayService;

//   @Override
//   public WeatherDTO getWeather(DataType dataType, lang lang){
//        return switch (dataType){
//           case NINE_DAY}
//   }
// }