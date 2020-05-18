package com.userdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserMobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMobileApplication.class, args);
	}

}
