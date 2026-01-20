package com.bootcamp.demo.demo_basic_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.demo.demo_basic_api.model.Database;
import com.bootcamp.demo.demo_basic_api.model.Student;




@Controller
@ResponseBody


public class StudentController {
private static long studentIdCounter = 0L;  //static attribute -> all class share one attribute

  //PostMapping
  @PostMapping(value = "/student")
  public Student create(@RequestBody Student student){
    student.setId(++studentIdCounter);
    return Database.students.add(student)?student:null;
  }

  @GetMapping("/student")
  public Student getById(@RequestParam Long id) {
      return Database.students.stream()//
      .filter(e -> e.getId().equals(id))//
      .findAny()//
      .orElse(null);
  }
  
  //delete
  @DeleteMapping(value = "/student")
  public void deleteById(@RequestParam Long id){  //steam not for deleting
   for(int i = 0; i< Database.students.size(); i++){
    if(Database.students.get(i).getId().equals(id)){
      Database.students.remove(i);
      return; //leave the loop (~break)
    }
   }
  }

  //Put (Update whole student by ID)
  @PutMapping("/student")
  public Student updateById(@RequestParam Long id, @RequestBody Student student) {
      Optional<Student> oStudent = Database.students.stream().filter(e -> e.getId().equals(id)).findAny(); //return optional
      if(oStudent.isPresent()){
        Database.students.removeIf(e -> e.getId().equals(id));  //not delete from sql for now //!removeIf()
        Database.students.add(student);
        return student;
      }
      return null;
  }

  //GetMapping
  @GetMapping(value = "/students")
  public List<Student> getAllStudent() {
      return Database.students;
  }
  
}
