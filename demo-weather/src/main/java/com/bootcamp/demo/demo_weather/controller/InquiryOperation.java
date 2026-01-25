package com.bootcamp.demo.demo_weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.demo.demo_weather.entity.InquiryEntity;

public interface InquiryOperation {
  @PostMapping(value = "/inquiry")
  InquiryEntity create(InquiryEntity inquiryEntity);

 @GetMapping(value = "/inquiry")
  InquiryEntity getById(Long id);
}

