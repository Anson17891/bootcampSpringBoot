package com.bootcamp.demo_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//! Step1 : Java compile w/ maven dependency ->.jar file
//! Step2 : Loop up all annotations, which creates Bean (@Controller, @Service, @Repository, @Component, @Configuration)
//! Step3 : Check the dependency between Beans, identify the sequence of creating beans  
    //eg. in CalculatorController  @Componet + @Autowired
		//    in CalculatorService     @Service
//! Step4 : In case any dependency (beans) not found, server fail to start.  !!Validation!!


@SpringBootApplication
public class DemoCalculatorApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoCalculatorApplication.class, args); //!start a 7*24 server, never end until killed
	}

}
