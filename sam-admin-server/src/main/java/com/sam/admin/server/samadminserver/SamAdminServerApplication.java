package com.sam.admin.server.samadminserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class SamAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamAdminServerApplication.class, args);
	}

}
