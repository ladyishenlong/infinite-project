package com.ladyishenlong.securitytokenservice.controller;

import com.google.gson.Gson;
import com.ladyishenlong.securitytokenservice.test.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019/10/24 8:46 上午
 */
@Slf4j
@RestController
public class SecurityController {



    @GetMapping("/test")
    public String test(){
        return "请求 jwt 成功";
    }

}
