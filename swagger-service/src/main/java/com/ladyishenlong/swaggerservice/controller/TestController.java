package com.ladyishenlong.swaggerservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019/11/4 1:57 下午
 */
@RestController
public class TestController {

    @ApiOperation(value = "测试的接口")
    @GetMapping("/hello/test")
    public String hello() {
        return "hello world";
    }


    @ApiOperation(value = "测试的接口2", authorizations =
    @Authorization(value = "jwt",
            scopes = {
                    @AuthorizationScope(scope = "root", description = "描述"),
                    @AuthorizationScope(scope = "admin", description = "描述")
            }
    )
    )
    @GetMapping("/hello/test2")
    public String hello2() {
        return "hello world";
    }


}
