package com.bootcamp.demo.demo_mtr_station;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//!----5/2/2026
@EnableScheduling
//!----^5/2/2026
public class DemoMtrStationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMtrStationApplication.class, args);
	}

}
