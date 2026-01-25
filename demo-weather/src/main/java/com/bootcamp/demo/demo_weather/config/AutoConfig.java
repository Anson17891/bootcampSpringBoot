package com.bootcamp.demo.demo_weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.demo_weather.mapper.DtoMapper;
import com.bootcamp.demo.demo_weather.mapper.EntityMapper;

@Configuration
public class AutoConfig {
  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }
  

  @Bean
  public DtoMapper dtoMapper(){
    return new DtoMapper();
  }

  @Bean
  public EntityMapper entityMapper(){
    return new EntityMapper();
  }
}
