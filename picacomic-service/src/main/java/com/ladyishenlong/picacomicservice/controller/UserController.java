package com.ladyishenlong.picacomicservice.controller;

import com.ladyishenlong.picacomicservice.properties.PicacomicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author ruanchenhao
 * @Date 2019/10/10 10:51 上午
 * 用户相关
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PicacomicProperties picacomic;


    @GetMapping("/hello")
    public String a(HttpServletResponse response){

        response.setStatus(301);
        response.setHeader("location", "https://puser.zjzwfw.gov.cn/sso/usp.do?action=ssoLogin&servicecode=nbhgzzsbxt");

        return "redict:https://www.baidu.com/";
    }


}
