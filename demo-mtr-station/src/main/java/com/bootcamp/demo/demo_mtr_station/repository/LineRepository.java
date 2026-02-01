package com.bootcamp.demo.demo_mtr_station.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo.demo_mtr_station.entity.LineEntity;


@Repository
public interface LineRepository extends JpaRepository<LineEntity, Long>{

  //!JPA Method -> return Type:
  //1. Optional<>
  //2. List<>
  Optional<LineEntity> findByCode(String code);  //in case code not exsist

  void deleteByCode(String code);

  
}
