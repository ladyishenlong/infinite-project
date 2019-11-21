package com.ladyishenlong.datajpadto.controller;

import com.ladyishenlong.datajpadto.jpa.TableAJpa;
import com.ladyishenlong.datajpadto.jpa.TableBJpa;
import com.ladyishenlong.datajpadto.model.TableB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019/11/21 5:41 下午
 */
@RestController
public class TestController {

    @Autowired
    private TableAJpa tableAJpa;

    @Autowired
    private TableBJpa tableBJpa;

    @GetMapping("/")
    public Object test(){
        return tableAJpa.findAll();
    }


}
