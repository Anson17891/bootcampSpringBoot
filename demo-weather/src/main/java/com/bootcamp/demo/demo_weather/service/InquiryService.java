package com.bootcamp.demo.demo_weather.service;

import com.bootcamp.demo.demo_weather.entity.InquiryEntity;


public interface InquiryService {
  void recordInquiry(String endpoint);
  
  InquiryEntity getById(Long id);
  
}
