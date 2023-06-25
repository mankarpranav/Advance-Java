package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProject3BeanScenario1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringProject3BeanScenario1Application.class, args);

		// Even if don't create single bean still
		// it will call constructor once as it is Singleton and eager
		//ScenarioI - NO explicit request/demand object call
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
 * [2m2023-06-25 13:24:59.685[0;39m [32m INFO[0;39m [35m1924[0;39m
 * [2m---[0;39m [2m[ main][0;39m
 * [36md.SpringProject3BeanScenario1Application[0;39m [2m:[0;39m Starting
 * SpringProject3BeanScenario1Application using Java 20.0.1 on DESKTOP-OE9L8AE
 * with PID 1924
 * (F:\Daily-Practice-Codes\SpringProject3_BeanScenario1\target\classes started
 * by Windows 10 in F:\Daily-Practice-Codes\SpringProject3_BeanScenario1)
 * [2m2023-06-25 13:24:59.689[0;39m [32m INFO[0;39m [35m1924[0;39m
 * [2m---[0;39m [2m[ main][0;39m
 * [36md.SpringProject3BeanScenario1Application[0;39m [2m:[0;39m No active
 * 
 * profile set, falling back to 1 default profile: "default" 
 * 
 * In Student Constructor... [2m2023-06-25 13:25:00.720[0;39m [32m INFO[0;39m
 * 
 * [35m1924[0;39m [2m---[0;39m [2m[ main][0;39m
 * [36md.SpringProject3BeanScenario1Application[0;39m [2m:[0;39m Started
 * SpringProject3BeanScenario1Application in 1.612 seconds (JVM running for
 * 2.817)
 * 
 * 
 * 
 */
