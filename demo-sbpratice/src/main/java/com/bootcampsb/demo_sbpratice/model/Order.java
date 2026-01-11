package com.bootcampsb.demo_sbpratice.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class Order {
  private List<Item> list = new ArrayList<>();
  private LocalDateTime updateTime;


public void addItem(Item item){
  this.list.add(item);
   this.updateTime = item.getAddTime();
}

}
