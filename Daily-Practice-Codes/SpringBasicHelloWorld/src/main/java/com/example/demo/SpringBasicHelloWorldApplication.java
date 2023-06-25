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

/**
 * OUTPUT -->
 * 
 * . ____ _ __ _ _ /\\ / ___'_ __ _ _(_)_ __ __ _ \ \ \ \ ( ( )\___ | '_ | '_| |
 * '_ \/ _` | \ \ \ \ \\/ ___)| |_)| | | | | || (_| | ) ) ) ) ' |____| .__|_|
 * |_|_| |_\__, | / / / / =========|_|==============|___/=/_/_/_/ [32m ::
 * Spring Boot :: [39m [2m (v2.7.13)[0;39m
 * 
 * [2m2023-06-25 10:31:29.945[0;39m [32m INFO[0;39m [35m4684[0;39m
 * [2m---[0;39m [2m[ main][0;39m [36mc.e.d.SpringBasicHelloWorldApplication
 * [0;39m [2m:[0;39m Starting SpringBasicHelloWorldApplication using Java
 * 20.0.1 on DESKTOP-OE9L8AE with PID 4684
 * (F:\Daily-Practice-Codes\SpringBasicHelloWorld\target\classes started by
 * Windows 10 in F:\Daily-Practice-Codes\SpringBasicHelloWorld) [2m2023-06-25
 * 10:31:29.951[0;39m [32m INFO[0;39m [35m4684[0;39m [2m---[0;39m [2m[
 * main][0;39m [36mc.e.d.SpringBasicHelloWorldApplication [0;39m [2m:[0;39m
 * No active profile set, falling back to 1 default profile: "default"
 * [2m2023-06-25 10:31:31.175[0;39m [32m INFO[0;39m [35m4684[0;39m
 * [2m---[0;39m [2m[ main][0;39m [36mc.e.d.SpringBasicHelloWorldApplication
 * [0;39m [2m:[0;39m Started SpringBasicHelloWorldApplication in 1.966
 * seconds (JVM running for 3.986) Hello World From Spring Boot
 * Application!!!!!!
 * 
 * 
 * 
 * 
 */
