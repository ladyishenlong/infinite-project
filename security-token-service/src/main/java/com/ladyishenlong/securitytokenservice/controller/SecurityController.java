package com.ladyishenlong.securitytokenservice.controller;

import com.google.gson.Gson;
import com.ladyishenlong.securitytokenservice.test.Student;
import com.ladyishenlong.securitytokenservice.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Author ruanchenhao
 * @Date 2019/10/24 8:46 上午
 */
@Slf4j
@RestController
public class SecurityController {


    @GetMapping("/test")
    public String test() {
        return "无需权限请求成功";
    }

    @GetMapping("/test2")
    public String test2(Principal principal) {
        return "普通需要权限请求成功：" + principal.getName();
    }


    @GetMapping("/test3")
    public String test3() {
        return "需要root权限请求成功";
    }

}
