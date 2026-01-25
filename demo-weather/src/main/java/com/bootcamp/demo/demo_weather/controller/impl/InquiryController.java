package com.bootcamp.demo.demo_weather.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.demo_weather.controller.InquiryOperation;
import com.bootcamp.demo.demo_weather.entity.InquiryEntity;
import com.bootcamp.demo.demo_weather.mapper.DtoMapper;
import com.bootcamp.demo.demo_weather.service.InquiryService;
import com.bootcamp.demo.demo_weather.service.WeatherService;
@RestController
public class InquiryController implements InquiryOperation{
  @Autowired
  private InquiryService inquiryService;
  @Autowired
  private WeatherService weatherService;
  @Autowired
  private DtoMapper dtoMapper;

  @Override
  public InquiryEntity create(InquiryEntity inquiryEntity) {
   return new InquiryEntity();
}
  @Override
   public InquiryEntity getById(Long id){
    return this.inquiryService.getById(id);
   }
}
