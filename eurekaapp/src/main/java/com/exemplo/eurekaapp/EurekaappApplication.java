package com.exemplo.eurekaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaappApplication.class, args);
	}

}
