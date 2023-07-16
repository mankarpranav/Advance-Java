package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBasicHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicHelloWorldApplication.class, args);

        System.out.println("Hello World From Spring Boot Application!!!!!!");
    }

}
