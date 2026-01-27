package com.bootcamp.demo.demo_weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo.demo_weather.entity.WeatherEntity;


@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long>{
  
}



// @Repository
// public interface NineDayRepository extends JpaRepository<WeatherEntity, Long>{
//! JPA -> Hibernate (Agent generate class, which implement this interface)
//some default mathods
         //java                         MySQL
     //save                        -> insert into
     //saveAll                     -> insert into
     //findById / existById        -> select * from xxx where id = yyy
     //deleteAll                   -> delete from xxx
     //deleteById                  -> delete from xxx where id = yyy

//!tailor-made method


//!1.JPA method   findByxxx[]
//!Read the method name -> generate SQL (According to yml - MySQL)
//find by ForecastDate
// List<NineDayEntity> findByForecastDate(LocalDate forecastDate);  //!write controller+service to complete it
  
//maxTemp >=20
// List<NineDayEntity> findByMaxTempGreaterThanEqual(Double degree);

//between dates   -> select * from nine_day_weather where tran_time between xxx and yyy
// List<NineDayEntity> findByTranTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

//! 2.JPQL (Java Persistance Query Language)  (simulate MySQL syntax)
 //find by ForecastDate
 //@Query(value = "select e from NineDayEntity e where e.forecastDate = :forecastDate")  //! : -> parameter indicator
                                                       //^use java representation
 // List<NineDayEntity> findByForecastDateJPQL(LocalDate forecastDate);
                          //^ can be any name now
// maxTemp >=20
//@Query(value = "select e from NineDayEntity e where e.maxTemp >= :degree")
// List<NineDayEntity> findByMaxTempGreaterThanEqual(Double degree);

//! 3. Native Query (Product Specific SQL)  (Direct inset command into SQL)
// @Query(
//     value = "select n.id, n.tran_time, n.forecast_date, n.max_temp, n.min_temp, n.max_rh, n.min_rh from nine_day_weathers where forecast_date = :forecastDate",
                                                      //^ use SQL representation
//       nativeQuery = true)
// List<NineDayEntity> findByForecastDateNQ(LocalDate forecastDate);
//!cons: if nine_day_weathers is dropped?
//-         column number (*) > list's limit?
//-          

//!when to use, join table

// }



