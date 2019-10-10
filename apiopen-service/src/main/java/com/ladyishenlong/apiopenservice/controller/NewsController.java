package com.ladyishenlong.apiopenservice.controller;

import com.ladyishenlong.apiopenservice.model.ApiopenModel;
import com.ladyishenlong.apiopenservice.model.WangYiNewsModel;
import com.ladyishenlong.apiopenservice.properties.ApiopenProperties;
import com.ladyishenlong.apiopenservice.utils.ApiOpenResponseUtils;
import com.ladyishenlong.responseutils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/9 11:19 上午
 */
@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController {


    @Autowired
    private ApiopenProperties api;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/wangyi")
    public ResponseUtils wangyi(HttpServletResponse response,
                                @RequestParam(name = "page") String page,
                                @RequestParam(name = "count") String count) {
        MultiValueMap<String, String> tokenParams = new LinkedMultiValueMap<>();
        tokenParams.add("page", page);
        tokenParams.add("count", count);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<>(tokenParams, headers);
        ResponseEntity<ApiopenModel> entity = restTemplate.postForEntity(
                api.getWangYiNews(), requestEntity, ApiopenModel.class);

        return ApiOpenResponseUtils.<List<WangYiNewsModel>>entityAnalysis(response,entity);


    }


}
