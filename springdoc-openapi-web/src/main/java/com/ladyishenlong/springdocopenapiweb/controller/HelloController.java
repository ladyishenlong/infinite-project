package com.ladyishenlong.springdocopenapiweb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author ruanchenhao
 * @Date 2019/11/7 8:50 上午
 */
@RestController
@Tag(name = "HelloController")
public class HelloController {

    @GetMapping("/hello2")
    public String hello2() {
        return "hello world v3";
    }

}
