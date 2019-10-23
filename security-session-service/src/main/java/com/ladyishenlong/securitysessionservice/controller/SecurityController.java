package com.ladyishenlong.securitysessionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 10:22 上午
 */
@RestController
public class SecurityController {

    @GetMapping("/test")
    public String test() {
        return "test进入成功";
    }

    @GetMapping("/test2")
    public String test2() {
        return "test2进入成功";
    }

}
