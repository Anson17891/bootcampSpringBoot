package com.bootcamp.demo.demo_external_api.controller.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.demo_external_api.controller.HSBCOperation;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.mapper.DtoMapper;
import com.bootcamp.demo.demo_external_api.model.dto.Cat;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@RestController
public class HSBCController implements HSBCOperation{
  @Autowired
  private JsonPlaceHolderService jsonPlaceHolderService;
  @Autowired
  private DtoMapper dtoMapper;

  @Override
  public List<UserDto> getUsers(){
    //List<A> -> List<B>  Stream

    // return this.jsonPlaceHolderService.getUsers().stream()// 
    // .map(e->
    //   {return UserDto.builder().id(e.getId())// !Too long, need a better encupsulation, see DtoMapper
    //   .email(e.getEmail()).phone(e.getPhone())//
    //   .name(e.getName()).build();
    // }).collect(Collectors.toList());
    return this.jsonPlaceHolderService.getUsers().stream()// 
    .map(e->this.dtoMapper.map(e)).collect(Collectors.toList());
  }

  @Override
  public Cat getCat(){
    return this.jsonPlaceHolderService.getCat();
  }
}
