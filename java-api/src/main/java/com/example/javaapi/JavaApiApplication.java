package com.example.javaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/* from https://github.com/divitngoc/spring-boot-simple-rest-api */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class JavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
	}

}
