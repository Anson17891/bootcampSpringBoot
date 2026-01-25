package com.bootcamp.demo.demo_weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication

public class DemoWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWeatherApplication.class, args);
	}

}
