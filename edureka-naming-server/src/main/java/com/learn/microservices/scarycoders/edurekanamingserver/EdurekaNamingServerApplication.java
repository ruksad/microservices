package com.learn.microservices.scarycoders.edurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EdurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdurekaNamingServerApplication.class, args);
	}

}
