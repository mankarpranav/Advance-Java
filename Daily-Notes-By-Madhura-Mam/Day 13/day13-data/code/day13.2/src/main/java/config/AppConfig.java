package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // to tell SC , following is a java config class for starting SC
@ComponentScan(basePackages = {  "dependency","dependent" })
public class AppConfig {
//currently NO @Bean methods : since beans are ALREADY
	//configured using @Component
}
