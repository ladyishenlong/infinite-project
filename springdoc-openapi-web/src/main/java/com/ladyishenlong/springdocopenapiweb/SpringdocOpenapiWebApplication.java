package com.ladyishenlong.springdocopenapiweb;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "标题",
                version = "1.0",
                description = "描述信息"
        ),
        externalDocs = @ExternalDocumentation(description = "参考文档",
                url = "https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations"
        )
)
@SpringBootApplication
public class SpringdocOpenapiWebApplication {

    /**
     * v3 导出的json 中 path的 key值不确定
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringdocOpenapiWebApplication.class, args);
    }

}
