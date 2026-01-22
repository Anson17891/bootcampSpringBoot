package com.bootcamp.demo.demo_database.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "orders")
@Getter
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long id;

  @Column(name = "order_datetime")
  private LocalDateTime orderDateTime;

  @Column(name = "order_amount")
  private Double amount;


  //! Foreign key
  @Setter
  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false) //!nullable = false -> if null, throw error
  private CustomerEntity customerEntity; //!not "Long customerId",  springboot use object to relate, not attribute
  
  //not use OneToMany at customerEntity -> no need in this case  //!why??
  
}
