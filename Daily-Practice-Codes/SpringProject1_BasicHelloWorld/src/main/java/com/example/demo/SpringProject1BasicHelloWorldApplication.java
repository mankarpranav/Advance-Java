package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProject1BasicHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProject1BasicHelloWorldApplication.class, args);

        System.out.println("Hello World from Spring Boot Application!!!!!!!!");
    }

}
