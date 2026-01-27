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


//!Solution
// @Getter
// public class NineDayDTO extends WeatherDTO{  //!changed the name, WeatherDTO is a empty abstract class //!Polymorthism
//  private String generalSituation;
//  @JsonProperty(value = "weatherForecast")
//  private List<ForecastDTO> weatherForecasts;
//  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "Asia/Hong_Kong")
//  private LocalDateTime updateTime;
//  private ValueDTO2 seaTemp;
//  @JsonProperty(value = "soilTemp")
//  private List<ValueDTO2> soilTemps;
//  


//@Getter
//  public static class ValueDTO2 {
//  private String place;
//  private Double value;
//  private String unit;
//  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "Asia/Hong_Kong")
//  private LocalDateTime recordTime;
//  private DepthDTO depth;}
//
//  @Getter
//  public static class DepthDTO{
// private String unit;
// private Double value;
// }

//  public static class ForecastDTO{
//   @JsonFormat(pattern = "yyyyMMdd")
//   private LocalDate forecastDate;
//   private String week;
//   @JsonProperty(value="forecastWind")
//   private String wind;
//   @JsonProperty(value="forecastWeater")
//   private String description;
// 
//   private ValueDTO forecastMaxtemp;
//   private ValueDTO forecastMintemp;
//  private ValueDTO forecastMinrh;
//  private ValueDTO forcastMinrh;
//  @JsonProperty(value = "ForecastIcon")
//  private Long forecastIcon;
//  @JsonProperty(value = "PSR")
//  private String psr;
//
//
//@Getter
//public static class ValueDTO{
// private Double value;
//  private Stting unit;
//}
