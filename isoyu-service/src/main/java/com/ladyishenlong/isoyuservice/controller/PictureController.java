package com.ladyishenlong.isoyuservice.controller;

import com.ladyishenlong.isoyuservice.model.CosplayModel;
import com.ladyishenlong.isoyuservice.model.IsoyuModel;
import com.ladyishenlong.isoyuservice.properties.IsoyuProperties;
import com.ladyishenlong.isoyuservice.utils.IsoyuResponseUtils;
import com.ladyishenlong.responseutils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/10 12:57 下午
 */
@RestController
public class PictureController {

    @Autowired
    private IsoyuProperties isoyuProperties;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/cosplay/{page}")
    public ResponseUtils cosplay(@PathVariable String page) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("page", page);
        ResponseEntity<IsoyuModel> entity = restTemplate.getForEntity(
                isoyuProperties.getCosplay(), IsoyuModel.class, params);
        return IsoyuResponseUtils.<List<CosplayModel>>entityAnalysis(entity);
    }


    /**
     * 花瓣相册，随机返回20条
     * @return
     */
    @GetMapping("/huaban")
    public ResponseUtils huaban(){
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        ResponseEntity<IsoyuModel> entity = restTemplate.getForEntity(
                isoyuProperties.getCosplay(), IsoyuModel.class, params);
        return IsoyuResponseUtils.<List<CosplayModel>>entityAnalysis(entity);
    }


}
