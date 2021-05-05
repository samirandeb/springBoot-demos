package com.sam.app.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class SamAppServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamAppServicesApplication.class, args);
	}

}
