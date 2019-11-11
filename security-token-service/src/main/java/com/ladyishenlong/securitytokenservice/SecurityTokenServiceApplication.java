package com.ladyishenlong.securitytokenservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用token 基本流程已经能通
 * 还需要整代码进行整理
 * 注意细节
 */

@OpenAPIDefinition(
        info = @Info(
                title = "spring security 集成 token",
                version = "1.0",
                description = "描述信息"
        ),
        externalDocs = @ExternalDocumentation(description = "参考文档",
                url = "https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations"
        )
)
@SpringBootApplication
public class SecurityTokenServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityTokenServiceApplication.class, args);
    }

}
