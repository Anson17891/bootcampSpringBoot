package com.bootcampsb.demo_sbpratice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcampsb.demo_sbpratice.model.Item;
import com.bootcampsb.demo_sbpratice.model.Order;




@Controller
@ResponseBody
//or @RestController
@RequestMapping(value = "/item")

public class ItemController {
  @GetMapping(value = "/{product}/{price}")
  public Item createNewItem1(@PathVariable(value = "product") String x, @PathVariable(value = "price") String y) {
    double doubleY = 0;
    try {
        doubleY = Double.parseDouble(y);
    } catch (NumberFormatException e) {
        System.out.println("Invalid format.");
    }
      return new Item(x,doubleY);
  }
  
 @PostMapping
 public Item createNewItem2(@RequestParam String x, @RequestParam String y) {
     double doubleY = 0;
    try {
        doubleY = Double.parseDouble(y);
    } catch (NumberFormatException e) {
        System.out.println("Invalid format.");
    }
      return new Item(x,doubleY);
 }

 @PutMapping(value = "/{x}/{y}")
 public Order putItemInOrder(@PathVariable String x, @RequestBody String y) {
     double doubleY = 0;
     Order order = new Order();
    try {
        doubleY = Double.parseDouble(y);
    } catch (NumberFormatException e) {
        System.out.println("Invalid format.");
    }
    Item newItem = new Item(x,doubleY);
    order.addItem(newItem);
      return order;
 }
 
}
