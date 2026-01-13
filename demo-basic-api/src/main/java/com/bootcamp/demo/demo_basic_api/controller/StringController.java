package com.bootcamp.demo.demo_basic_api.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.demo.demo_basic_api.model.Database;


//! RESTful API
// Resource

@Controller
@ResponseBody

public class StringController {



  @GetMapping(value = "/string/{x}/{y}")
public String concatFirstChar(@PathVariable(value = "x") String firstWord //
                             ,@PathVariable String y){
  return ""+firstWord.charAt(0)+y.charAt(0); // input: "hello", "world" ,expect "hw"
       //firstWord.charAt(0)+y.charAt(0)+""; // input: "hello", "world" ,->"223" <-char+char=int+int
}

  //API signiture definition: xxxMappint + URI path
  //~method signiture

  //! No need to use /add
// @GetMapping(value = "/database/add/{name}")

   @PostMapping(value =  "/database/{name}")
public String addName(@PathVariable String name) {
    return Database.names.add(name)? name: null;
}//try: add/Leo, add/Oscar
 
//delete Name 
//! No need to use /delete
// @GetMapping(value = "/database/delete/{name}")

@DeleteMapping(value = "/database/{name}")
public String deleteName(@PathVariable String name){
        return Database.names.remove(name)? name : null;
}
//! Use Postman

@GetMapping(value = "/database/names")
public List<String> getNames() {
    return Database.names;
}        //result: ["Leo","Oscar"]

//getNameByIndex
@GetMapping(value = "/database/{index}")
public String getNamesByIndex(@PathVariable String index) { //! by default use String  prevent error(may input other than number)
    // if(Database.names.get(index) == null){
    //   return "Not Found";
    // }
    // if(index>Database.names.size()||index<0){
    //   return "Wrong index";
    // }
    // return Database.names.get(index);

    //! String -> Integer    
    try{
      int idx = Integer.valueOf(index);
      if(idx<0 || idx>=Database.names.size())
            return "Wrong Index";
          return Database.names.get(idx);
       } catch(NumberFormatException e){
          return "Wrong Index.";
}
}



//Update name by index + new name
@PutMapping(value = "/database/{index}/{name}")
public String updateNameByIndex(@PathVariable String index, @PathVariable String name) {
    try{int idx = Integer.parseInt(index);
    if(idx<0 || idx>=Database.names.size())
      return "Wrong Index";
    Database.names.set(idx, name);
      return name;
   }catch(NumberFormatException e){
     return "Wrong Index.";
}
}


}
