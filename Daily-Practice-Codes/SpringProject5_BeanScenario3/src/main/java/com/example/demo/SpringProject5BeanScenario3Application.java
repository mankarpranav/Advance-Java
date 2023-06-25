package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProject5BeanScenario3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringProject5BeanScenario3Application.class, args);

		// when scope is prototype it wont call even constructor as Spring Container is
		// waiting for first request/demand

	}

}

/**
 * OUTPUT-->
 * 
 * (Nothing will be printed in console)
 * 
 */
