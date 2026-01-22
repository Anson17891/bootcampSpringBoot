package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.demo_external_api.model.dto.Cat;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@Service
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {
  //https://jsonplaceholder.typicode.com/users

@Autowired
private RestTemplate restTemplate;

@Autowired
@Qualifier(value = "superCat") //<- specify the Cat bean
private Cat ijk; //only this syntax -> error, there are 2 Cat bean in AppConfig




@Override 
public List<UserDTO> getUsers(){
String url = "https://jsonplaceholder.typicode.com/users";
UserDTO[] userDTOs = new RestTemplate().getForObject(url, UserDTO[].class);
return Arrays.asList(userDTOs);
}

@Override
public Cat getCat(){
  return this.ijk;
}
}
