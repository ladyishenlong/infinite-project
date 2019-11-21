package com.ladyishenlong.datajpadto.controller;

import com.ladyishenlong.datajpadto.jpa.TableAJpa;
import com.ladyishenlong.datajpadto.jpa.TableBJpa;
import com.ladyishenlong.datajpadto.model.table.TableA;
import com.ladyishenlong.datajpadto.model.table.TableB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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


    //代码执行
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/")
    public Object test(){
        return tableAJpa.find2( PageRequest.of(0,1),"666" );
    }


}
