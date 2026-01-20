package com.bootcamp.demo.demo_database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo.demo_database.entity.CustomerEntity;
import com.bootcamp.demo.demo_database.repository.CustomerRepository;
import com.bootcamp.demo.demo_database.service.CustomerService;

//impl = implement
@Service //!Bean
public class CustomerServiceimpl implements CustomerService {
 @Autowired   //!@service+@autowire <-> @repository    //~ @controller+@autowire <-> @service
 private CustomerRepository customerRepository;
 
//Post
 @Override
public CustomerEntity create(CustomerEntity customerEntity){
 return this.customerRepository.save(customerEntity); //auto generate id
}

//GetById
 @Override
public CustomerEntity getById(Long id){
  return this.customerRepository.findById(id).orElse(null);
}

//DeleteById
 @Override
public void deleteById(Long id){
  this.customerRepository.deleteById(id);
}

//PutById
 @Override
public CustomerEntity updateById(Long id, CustomerEntity customerEntity){
 CustomerEntity entity = this.customerRepository.findById(id).orElse(null); //usually be throw not orelse
  if(entity != null){
    entity.setDob(customerEntity.getDob());
    entity.setName(customerEntity.getName());
    return this.customerRepository.save(entity);
  }
  return null;
}
   
}
