package com.nhb.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SystemCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemCenterApplication.class, args);
	}
}
