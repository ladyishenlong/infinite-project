package com.ladyishenlong.isoyuservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class IsoyuServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsoyuServiceApplication.class, args);
	}

}
