package com.userdbService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class UserDbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDbServiceApplication.class, args);
	}

}
