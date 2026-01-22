package com.bootcamp.demo.demo_database.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo.demo_database.entity.CustomerEntity;

public interface CustomerOperation {  //!RESTful = same URI, different functions
  @PostMapping(value = "/customer")
  CustomerEntity create(@RequestBody CustomerEntity customerEntity);
  
  @GetMapping(value = "/customer")
  CustomerEntity getById(@RequestParam Long id);

  @DeleteMapping(value = "/customer")
  void deleteById(@RequestParam Long id);

  @PutMapping(value = "/cutsomer")
  CustomerEntity updateById(@RequestParam Long id, @RequestBody CustomerEntity customerEntity);
}
