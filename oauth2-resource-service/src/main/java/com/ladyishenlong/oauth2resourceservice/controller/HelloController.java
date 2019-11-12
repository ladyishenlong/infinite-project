package com.ladyishenlong.oauth2resourceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019/11/11 4:09 下午
 */
@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "获取资源成功";
    }
}
