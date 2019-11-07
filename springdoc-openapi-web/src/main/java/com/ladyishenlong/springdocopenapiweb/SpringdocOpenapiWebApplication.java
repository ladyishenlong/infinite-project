package com.ladyishenlong.springdocopenapiweb;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "标题",
				version = "1.0",
				description = "描述信息"
		))
@SpringBootApplication
public class SpringdocOpenapiWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdocOpenapiWebApplication.class, args);
    }

}
