package com.bootcamp.demo.demo_database.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity   //entity = table in sql
@Table(name = "customers")
@Getter
public class CustomerEntity {
  @Id //! Primary Key in sql
  @GeneratedValue(strategy = GenerationType.IDENTITY) //! auto_increment
  private Long id;
  @Setter
  @Column(name = "c_name", length = 50)
  private String name;
  @Setter
  @Column(name = "c_dob")
  private LocalDate dob;
  
}
