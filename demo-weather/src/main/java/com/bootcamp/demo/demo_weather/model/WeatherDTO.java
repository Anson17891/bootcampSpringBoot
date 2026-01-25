package com.bootcamp.demo.demo_weather.model;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;


@Getter
public class WeatherDTO {
  //https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=fnd&lang=en
  private String generalSituation;
  @JsonProperty("weatherForecast")  // match JSON field name
    private List<WeatherForecast> weatherForecasts;



@Getter
public static class WeatherForecast{
  private String forecastDate;
  private String week;
  private String forecastWind;
  private String forecastWeather;
@JsonProperty("forecastMaxtemp")
        private Temp maxTemp;

        @JsonProperty("forecastMintemp")
        private Temp minTemp;

        @JsonProperty("forecastMaxrh")
        private Rh maxRh;

        @JsonProperty("forecastMinrh")
        private Rh minRh;
private int forecastIcon;
private String PSR;


  @Getter
  public static class Temp{
    private String value;
    private String unit;
  }

  @Getter
  public static class Rh{
    private String value;
    private String unit;
  }

}
}
