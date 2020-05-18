package com.useradress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserAddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAddressApplication.class, args);
	}

}
