package com.bootcamp.demo.demo_mtr_station.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo.demo_mtr_station.entity.LineEntity;
import com.bootcamp.demo.demo_mtr_station.entity.StationEntity;



@Repository
public interface StationRepository extends JpaRepository<StationEntity, Long>{

  Optional<StationEntity> findByCode(String code);
  void deleteByCode(String code);

  List<StationEntity> findByLineEntity(LineEntity lineEntity);

}
