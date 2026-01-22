package com.bootcamp.demo.demo_database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo.demo_database.entity.CustomerEntity;
import com.bootcamp.demo.demo_database.entity.OrderEntity;
import com.bootcamp.demo.demo_database.repository.CustomerRepository;
import com.bootcamp.demo.demo_database.repository.OrderRepository;
import com.bootcamp.demo.demo_database.service.OrderService;

@Service
public class OrderServiceimpl implements OrderService {
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private CustomerRepository customerRepository;

@Override
  public abstract OrderEntity create(OrderEntity orderEntity){
 CustomerEntity customerEntity = this.customerRepository.findById(customerId).orElseThrow(() -> new IllegalArgumentException("Customer Id Not Found"));
 return this.orderRepository.save(orderEntity);
}


}
