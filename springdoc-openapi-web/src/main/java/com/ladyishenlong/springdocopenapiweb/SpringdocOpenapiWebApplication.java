package com.ladyishenlong.springdocopenapiweb;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
		title = "测试用接口",
		version = "1.0"
))
@SpringBootApplication
public class SpringdocOpenapiWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdocOpenapiWebApplication.class, args);
	}

}
