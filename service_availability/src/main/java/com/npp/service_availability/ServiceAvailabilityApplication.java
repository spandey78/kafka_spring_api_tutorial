package com.npp.service_availability;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceAvailabilityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAvailabilityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running Spring Boot Application");
	}
}
