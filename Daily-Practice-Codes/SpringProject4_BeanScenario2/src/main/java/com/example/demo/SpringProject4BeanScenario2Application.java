package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringProject4BeanScenario2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringProject4BeanScenario2Application.class, args);

		// Here explicitly calling bean named as Student in Spring Container
		// Here Singleton Object will be created; it is Singleton and Eager
		// so constructor will also show message in it.
		//Scenario-I
		Student s1 = ctx.getBean("Student", Student.class);
		s1.show();

		// if we create new more objects then also constructor will also called once
		// as object is singleton
		//Scenario-II
		Student s2 = ctx.getBean("Student", Student.class);
		s2.show();
	}

}

/**Scenario-I
 * OUTPUT-->
 * 
 * In constructor of Student [2m2023-06-25 13:37:27.583[0;39m [32m
 * INFO[0;39m [35m10060[0;39m [2m---[0;39m [2m[ main][0;39m
 * [36md.SpringProject4BeanScenario2Application[0;39m [2m:[0;39m Started
 * SpringProject4BeanScenario2Application in 1.589 seconds (JVM running for
 * 2.798)
 * 
 * In show method..of student
 */

/**Scenario-II
 * OUTPUT-->
 * 
 * In constructor of Student
 * [2m2023-06-25 13:41:13.528[0;39m [32m INFO[0;39m [35m9964[0;39m [2m---[0;39m [2m[           main][0;39m [36md.SpringProject4BeanScenario2Application[0;39m [2m:[0;39m Started SpringProject4BeanScenario2Application in 1.658 seconds (JVM running for 2.977)
 * In show method..of student
 * In show method..of student
 * 
 * 
 */
