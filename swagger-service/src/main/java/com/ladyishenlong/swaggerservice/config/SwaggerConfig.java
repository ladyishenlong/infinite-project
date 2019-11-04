package com.ladyishenlong.swaggerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author ruanchenhao
 * @Date 2019/11/4 1:56 下午
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("服务接口文档范例")
                .description("服务接口文档，严格遵循RESTful API设计规范。")
//                .contact()
                .version("1.0")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo)
                .select()
                //以扫描包的方式
                .apis(RequestHandlerSelectors.basePackage("com.ladyishenlong.swaggerservice.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
