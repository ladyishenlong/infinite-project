package com.ladyishenlong.apiopenservice.service.serviceImpl;

import com.ladyishenlong.apiopenservice.model.ApiopenModel;
import com.ladyishenlong.apiopenservice.model.WangYiNewsModel;
import com.ladyishenlong.apiopenservice.properties.ApiopenProperties;
import com.ladyishenlong.apiopenservice.service.WangYiNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/9/30 10:18 上午
 */
@Component
public class WangYiNewsServiceImpl implements WangYiNewsService {

    @Autowired
    private ApiopenProperties api;

    @Autowired
    private RestTemplate restTemplate;


    //    @Cacheable(key ="#page" ,value = "result")
    @Override
    public List<WangYiNewsModel> getWangYiNews(String page, String count) {
        MultiValueMap<String, String> tokenParams = new LinkedMultiValueMap<>();
        tokenParams.add("page", page);
        tokenParams.add("count", count);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<>(tokenParams, headers);

        ResponseEntity<ApiopenModel> entity = restTemplate
                .postForEntity(api.getWangYiNews(), requestEntity, ApiopenModel.class);

        ApiopenModel apiopenModel = entity.getBody();

        List<WangYiNewsModel> wangYiNewsModels =
                (List<WangYiNewsModel>) apiopenModel.getResult();

        return wangYiNewsModels;
    }







}
