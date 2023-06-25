package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringProject2DependecyInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringProject2DependecyInjectionApplication.class,
				args);

		Student s1 = ctx.getBean("abc", Student.class);
		s1.show();
	}

}

/**
 * 
 * 
 * . ____ _ __ _ _ /\\ / ___'_ __ _ _(_)_ __ __ _ \ \ \ \ ( ( )\___ | '_ | '_| |
 * '_ \/ _` | \ \ \ \ \\/ ___)| |_)| | | | | || (_| | ) ) ) ) ' |____| .__|_|
 * |_|_| |_\__, | / / / / =========|_|==============|___/=/_/_/_/ [32m ::
 * Spring Boot :: [39m [2m (v2.7.13)[0;39m
 * 
 * [2m2023-06-25 13:18:42.563[0;39m [32m INFO[0;39m [35m2040[0;39m
 * [2m---[0;39m [2m[ main][0;39m
 * [36mingProject2DependecyInjectionApplication[0;39m [2m:[0;39m Starting
 * SpringProject2DependecyInjectionApplication using Java 20.0.1 on
 * DESKTOP-OE9L8AE with PID 2040
 * (F:\Daily-Practice-Codes\SpringProject2_DependecyInjection\target\classes
 * started by Windows 10 in
 * F:\Daily-Practice-Codes\SpringProject2_DependecyInjection) [2m2023-06-25
 * 13:18:42.594[0;39m [32m INFO[0;39m [35m2040[0;39m [2m---[0;39m [2m[
 * main][0;39m [36mingProject2DependecyInjectionApplication[0;39m
 * [2m:[0;39m No active profile set, falling back to 1 default profile:
 * "default" [2m2023-06-25 13:18:43.813[0;39m [32m INFO[0;39m
 * [35m2040[0;39m [2m---[0;39m [2m[ main][0;39m
 * [36mingProject2DependecyInjectionApplication[0;39m [2m:[0;39m Started
 * SpringProject2DependecyInjectionApplication in 2.041 seconds (JVM running for
 * 3.345)
 * 
 * 
 * In show method().... compiling...
 * 
 * 
 */
