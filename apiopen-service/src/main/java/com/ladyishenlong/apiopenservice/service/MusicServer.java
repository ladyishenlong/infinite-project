package com.ladyishenlong.apiopenservice.service;

import com.ladyishenlong.apiopenservice.model.music.MusicBroadcastingResult;
import com.ladyishenlong.apiopenservice.properties.ApiopenProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @Author ruanchenhao
 * @Date 2019/10/18 1:38 下午
 */
@Slf4j
@Component
public class MusicServer {
    @Autowired
    private ApiopenProperties api;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取电台信息
     */
    public Object broadcasting() {
        ResponseEntity<MusicBroadcastingResult> entity =
                restTemplate.getForEntity(api.getMusicBroadcasting(),
                MusicBroadcastingResult.class, new HashMap<>());
        return entity;
    }


}
