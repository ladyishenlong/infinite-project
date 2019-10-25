package com.ladyishenlong.securitysessionservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 10:22 上午
 */
@Slf4j
@RestController
public class SecurityController {

    @GetMapping("/test")
    public String test() {
        return "test进入成功";
    }

    @GetMapping("/test2")
    public String test2(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //都能得到用户名信息
        log.info("查看用户信息：{}",authentication.getName());
        log.info("查看用户信息2：{}",principal.getName());
        return "test2进入成功";
    }

}
