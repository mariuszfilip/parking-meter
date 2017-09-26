package com.pwsip.pl.parkingmeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ParkingMeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingMeterApplication.class, args);
	}
}
