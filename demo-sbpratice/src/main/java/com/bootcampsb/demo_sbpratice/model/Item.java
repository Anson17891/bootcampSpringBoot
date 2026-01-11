package com.bootcampsb.demo_sbpratice.model;


import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Item {
  private String name;
  private double price;
  private LocalDateTime addTime;

public Item(String name, double price){
this.name = name;
this.price = price;
this.addTime = LocalDateTime.now();
}
}
