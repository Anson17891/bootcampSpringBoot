package com.bootcamp.demo.demo_mtr_station.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.demo_mtr_station.codeLib.RedisManager;

import tools.jackson.databind.ObjectMapper;
@Configuration
public class AppConfig {

  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  //!--------3/2/2026-----redis---------------
  //agent to connect data to redis
  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean 
  RedisManager redisManager(RedisConnectionFactory factory, ObjectMapper objectMapper){
    return new RedisManager(factory, objectMapper);
  }

  @Bean
  RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
    RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

}
