package com.ladyishenlong.picacomicservice.controller;

import com.ladyishenlong.picacomicservice.properties.PicacomicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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



}
