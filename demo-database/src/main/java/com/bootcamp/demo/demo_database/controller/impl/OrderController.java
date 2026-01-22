package com.bootcamp.demo.demo_database.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.demo_database.controller.OrderOperation;
import com.bootcamp.demo.demo_database.entity.CustomerEntity;
import com.bootcamp.demo.demo_database.entity.OrderEntity;
import com.bootcamp.demo.demo_database.service.OrderService;

@RestController

public class OrderController implements OrderOperation{
  @Autowired
  private OrderService orderService;

  @Override
   public OrderEntity create(Long customerId, OrderEntity orderEntity){
//     CustomerEntity customerEntity = this.customerRepository.findById(customerId).orElseThrow(() -> new IllegalArgumentException("Customer Id Not Found"));
//  return this.orderRepository.save(orderEntity);
return this.orderService.create(orderEntity);
}

   
}