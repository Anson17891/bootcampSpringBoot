package com.bootcampsb.demo_sbpratice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcampsb.demo_sbpratice.model.Item;


@Controller
@ResponseBody
public class ItemController {
  @GetMapping(value = "/item/{product}/{price}")
  public Item addNewItem(@PathVariable(value = "product") String x, @PathVariable(value = "price") Double y) {
      return new Item(x,y);
  }
  
}
