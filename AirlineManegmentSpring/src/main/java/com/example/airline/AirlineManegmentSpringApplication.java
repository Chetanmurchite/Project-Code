package com.example.airline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* @SpringBootApplication: A convenience annotation that combines @Configuration
@EnableConfiguration and @ComponentScan. It enables auto-configuration and 
component scanning within the package and its sub-packages.
*/
@SpringBootApplication
public class AirlineManegmentSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineManegmentSpringApplication.class, args);
	}

}
