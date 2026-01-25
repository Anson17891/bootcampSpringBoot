package com.bootcamp.demo.demo_weather.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Builder
@Table(name = "nine_day_forecast")
public class WeatherEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquiry_id", nullable = false)
    @Setter
    private InquiryEntity inquiry;

    
  private String forecastDate;
  private String week;
  private String forecastWind;
  private String forecastWeather;

  @Column(name = "max_temp_value")
  private String maxTempValue;
  @Column(name = "max_temp_unit")
  private String maxTempUnit;
  @Column(name = "min_temp_value")
  private String minTempValue;
  @Column(name = "min_temp_unit")
  private String minTempUnit;
  @Column(name = "max_rh_value")
  private String maxRhValue;
  @Column(name = "max_rh_unit")
  private String maxRhUnit;
  @Column(name = "min_rh_value")
  private String minRhValue;
  @Column(name = "min_rh_unit")
  private String minRhUnit;

}
