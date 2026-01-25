package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.demo.demo_external_api.entity.CommentEntity;
import com.bootcamp.demo.demo_external_api.entity.PostEntity;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;
import com.bootcamp.demo.demo_external_api.mapper.EntityMapper;
import com.bootcamp.demo.demo_external_api.model.dto.Cat;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_external_api.repository.CommentRepository;
import com.bootcamp.demo.demo_external_api.repository.PostRepository;
import com.bootcamp.demo.demo_external_api.repository.UserRepository;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;


@Service
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {
  //https://jsonplaceholder.typicode.com/users

  //private static String url = "https://jsonplaceholder.typicode.com/users"; //usually in java, but not in SB
@Value("${external-api.jsonplaceholder.domain}")  //$ reading yml path
private String domain;

@Value("${external-api.jsonplaceholder.paths.user-path}")
private String userPath;

@Value("${external-api.jsonplaceholder.paths.post-path}")
private String postPath;

@Value("${external-api.jsonplaceholder.paths.comment-path}")
private String commentPath;


@Autowired
private RestTemplate restTemplate;

@Autowired
private EntityMapper entityMapper;

@Autowired
private UserRepository userRepository;

@Autowired
private PostRepository postRepository;

@Autowired
private CommentRepository commentRepository;

@Autowired
@Qualifier(value = "superCat") //<- specify the Cat bean to inject
private Cat ijk; //only this syntax -> error, there are 2 Cat bean in AppConfig can be injected




@Override 
public List<UserDTO> getUsers(){
// String url = "https://jsonplaceholder.typicode.com/users";

    String url = UriComponentsBuilder.newInstance()//
                    .scheme("https")
                    .host(this.domain)//
                    .path(this.userPath)//
                    .build()//
                    .toUriString();   //     -> form the whole url
System.out.println("url=" + url);  //for checking bug

UserDTO[] userDTOs = this.restTemplate.getForObject(url, UserDTO[].class);

//List<UserDTO> -> List<UserEntity>
//EntityMapper
List<UserEntity> userEntities = Arrays.asList(userDTOs).stream()//
                                       .map(e -> this.entityMapper.map(e))//
                                       .collect(Collectors.toList());
this.userRepository.saveAll(userEntities);
// insert DB

return Arrays.asList(userDTOs);
}

@Override
public Cat getCat(){
  return this.ijk;
}

@Override
public List<PostDTO> getPosts(){
  String url = UriComponentsBuilder.newInstance()//
                                   .scheme("https")//
                                   .host(this.domain)//
                                   .path(this.postPath)//
                                   .build()//
                                   .toUriString();
  System.out.println("url=" + url);
  PostDTO[] postDTOs = this.restTemplate.getForObject(url, PostDTO[].class);


  //! List<PostDTO> -> List<PostEntity>
List<PostEntity> postEntities = Arrays.asList(postDTOs).stream()//
                         //Find UserEntity by given user id
                                       .map(e -> {
                                       UserEntity userEntity =  this.userRepository.findById(e.getUserId())//
                                       .orElseThrow(() -> new IllegalArgumentException());
                                      PostEntity postEntity = this.entityMapper.map(e);
                                    postEntity.setUserEntity(userEntity);//set FK
                                  return postEntity;})
                                       .collect(Collectors.toList());
                                  
this.postRepository.saveAll(postEntities);

  return Arrays.asList(postDTOs);
                    
};

@Override
public List<CommentDTO> getComments(){
  String url = UriComponentsBuilder.newInstance()//
                                   .scheme("https")//
                                   .host(this.domain)//
                                   .path(this.commentPath)//
                                   .build()//
                                   .toUriString();
  System.out.println("url=" + url);
  CommentDTO[] commentDTOs;
    commentDTOs = this.restTemplate.getForObject(url, CommentDTO[].class);


 
List<CommentEntity> commentEntities = Arrays.asList(commentDTOs).stream()//
                                       .map(e -> {
                                       PostEntity postEntity =  this.postRepository.findById(e.getPostId())//
                                       .orElseThrow(() -> new IllegalArgumentException());
                                      CommentEntity commentEntity = this.entityMapper.map(e);
                                    commentEntity.setPostEntity(postEntity);//set FK
                                  return commentEntity;})
                                       .collect(Collectors.toList());
                                  
this.commentRepository.saveAll(commentEntities);

  return Arrays.asList(commentDTOs);
                    
};


}
