package com.turnquest.setupsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SetupsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SetupsDemoApplication.class, args);
	}

}
