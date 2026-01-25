package com.bootcamp.demo.demo_weather.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo.demo_weather.entity.InquiryEntity;
import com.bootcamp.demo.demo_weather.repository.InquiryRepository;
import com.bootcamp.demo.demo_weather.service.InquiryService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InquiryServiceImpl implements InquiryService{
 @Autowired
 private InquiryRepository inquiryRepository;

  @Override
  public void recordInquiry(String endpoint){
    InquiryEntity inquiryEntity = new InquiryEntity();
    inquiryEntity.setInquiryTime(LocalDateTime.now());

    inquiryRepository.save(inquiryEntity);

  }

  @Override
  public InquiryEntity getById(Long id){
    return this.inquiryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Inquiry entity not found with id: " + id));
  }
  
}
