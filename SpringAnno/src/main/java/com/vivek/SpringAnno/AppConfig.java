package com.vivek.SpringAnno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.vivek.SpringAnno")
public class AppConfig {

	/*
	 * @Bean Samsung getPhone() { return new Samsung(); }
	 * 
	 * @Bean MobileProcessor getProcesser() { return new Snapdragon(); }
	 */
}
