package com.bootcamp.demo.demo_weather.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "forecast_inquiry")
public class InquiryEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

  @Column(name = "inquiry_time")
  private LocalDateTime inquiryTime;

  @OneToMany(mappedBy = "inquiry", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<WeatherEntity> weatherEntities;



}
