package com.ladyishenlong.apiopenservice.controller;


import com.ladyishenlong.apiopenservice.service.WangYiNewsService;
import com.ladyishenlong.apiopenservice.service.serviceImpl.WangYiNewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author ruanchenhao
 * @Date 2019/9/29 4:47 下午
 */
@RestController
public class TestController {

    @Autowired
    private WangYiNewsService wangYiNewsService;

    @GetMapping("/test")
    public Object test() {
        return wangYiNewsService.getWangYiNews("1","1");
    }


}
