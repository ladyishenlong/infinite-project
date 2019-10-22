package com.ladyishenlong.apiopenservice.controller;

import com.ladyishenlong.apiopenservice.model.ApiopenModel;
import com.ladyishenlong.apiopenservice.model.music.MusicRankingsModel;
import com.ladyishenlong.apiopenservice.properties.ApiopenProperties;
import com.ladyishenlong.apiopenservice.service.MusicServer;
import com.ladyishenlong.apiopenservice.utils.ApiOpenResponseUtils;
import com.ladyishenlong.responseutils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
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
 * @Date 2019/10/18 8:58 上午
 */
@Slf4j
@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private ApiopenProperties api;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MusicServer musicServer;


    /**
     * 音乐音乐排行版接口
     * @return
     */
    @GetMapping("/rankings")
    public ResponseUtils rankings() {
        HashMap<String, String> params = new HashMap();
        ResponseEntity<ApiopenModel> entity = restTemplate.getForEntity(
                api.getMusicRankings(), ApiopenModel.class,params);
        return ApiOpenResponseUtils.<List<MusicRankingsModel>>entityAnalysis(entity);
    }



    @GetMapping("/broadcasting")
    public Object broadcasting(){
        return musicServer.broadcasting();
    }





}
