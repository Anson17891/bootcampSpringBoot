package com.bootcamp.demo.demo_weather.service.impl;
// //!Solution
// import org.springframework.beans.factory.annotation.Autowired;

// @Service
// public class NineDayServiceImpl implements NineDatService{
//   @Autowired
//   private RestTemplate restTemplate;
//   @Autowired
//   private EntityMapper entityMapper;
// @Autowired
// private NineDayRepository nineDayRepository;

//   @Value("${weather.data-weather.domain}")
//   private String domain;

//   @Value("${weather.data-weather.path-segment}")
//   private String pathSegment;

//   @Value("${weather.data-weather.path}")
//   private String path;

//   @Value("${weather.data-weather.datatype.nineday}")

//   @Override
//   public NineDayDTO getWeather(Lang lang){   //NineDayDTO->See WeatherDTO solution
//     String url = UriCompnentsBuilder.newInstance()//
//     .scheme("https")//
//     .host(domain)//
//     .pathSegment(pathSegment)//
//     .path(path)//
//     .queryParam("dataType", dataType)//
//     .queryParam("lang", lang.getValue())//
//     .build()//
//     .toUriString();
//     System.out.println("url=" + url);
//     NineDayDTO nineDayDTO =  this.restTemplate.getForObject(url, NineDayDTO.class);
//   
//
//     stream
//     LocalDateTime now = LocalDateTime.now() //! put the time outside the stream
//     List<NineDayEntity> nineDayEntities = nineDayDTO.getWeatherForecasts().stream()//
//     .map(e-> {
//            NineDatEntity entity = this.entityMapper.map(e));//
//            entity.setTranTime(now);  //! all nine data has same tranTime
//            return entity;
//         }).collect(Collectors.toList());
//     this.nineDayRepository.save(nineDayEntities);//

// return nineDayDTO;

// }

//@Override
// public List<NineDayEntity> findByForecastDate(LocalDate forecastDate){
//      return this.nineDayRepository.findByForecaseDate(forecastDate);}

//@Override
// public List<NineDayEntity> findByMaxTempGreaterThanEqual(Double degree){
//      return this.neatherRepository.findByMaxTempGreaterThanEqual(degree);}

//@Override
// public List<NineDayEntity> findByTranTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime){
//    return this.neatherRepository.findByTranTimeBetween(startDateTime, endDateTime);}
  
// }

import org.springframework.beans.factory.annotation.Autowired;
