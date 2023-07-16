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
