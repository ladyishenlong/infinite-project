package com.ladyishenlong.isoyuservice.controller;

import com.ladyishenlong.isoyuservice.model.CosplayModel;
import com.ladyishenlong.isoyuservice.model.IsoyuModel;
import com.ladyishenlong.isoyuservice.properties.IsoyuProperties;
import com.ladyishenlong.isoyuservice.utils.IsoyuResponseUtils;
import com.ladyishenlong.responseutils.ResponseUtils;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/17 4:09 下午
 */
@RestController
@RequestMapping("/news")
public class NewsController {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IsoyuProperties isoyuProperties;

    @GetMapping("/banner")
    public ResponseUtils banner(){
        HashMap<String, String> params = new HashMap<>();
        ResponseEntity<IsoyuModel> entity = restTemplate.getForEntity(
                isoyuProperties.getNews().getBanner(), IsoyuModel.class, params);
        return IsoyuResponseUtils.<List<CosplayModel>>entityAnalysis(entity);
    }

}
