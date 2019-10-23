package com.ladyishenlong.testservice.controller;

import com.ladyishenlong.responseutils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 9:13 上午
 */
@RestController
public class HelloController {

    @GetMapping
    public ResponseUtils hello(){
        return ResponseUtils.success("hello world");
    }

}
