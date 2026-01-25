package com.bootcamp.demo.demo_weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_weather.entity.WeatherEntity;


@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long>{
  
}
