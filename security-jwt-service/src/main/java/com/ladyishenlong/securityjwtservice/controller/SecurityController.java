package com.ladyishenlong.securityjwtservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019/10/24 8:46 上午
 */
@RestController
public class SecurityController {

    @GetMapping("/test")
    public String test(){
        return "请求 jwt 成功";
    }

}
