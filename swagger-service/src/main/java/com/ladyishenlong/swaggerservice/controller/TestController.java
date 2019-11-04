package com.ladyishenlong.swaggerservice.controller;

import io.swagger.annotations.ApiOperation;
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
    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }


}
