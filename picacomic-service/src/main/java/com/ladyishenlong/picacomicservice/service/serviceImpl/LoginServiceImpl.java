package com.ladyishenlong.picacomicservice.service.serviceImpl;

import com.ladyishenlong.picacomicservice.model.PicacomicModel;
import com.ladyishenlong.picacomicservice.model.request.LoginBody;
import com.ladyishenlong.picacomicservice.properties.PicacomicProperties;
import com.ladyishenlong.picacomicservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/9/30 2:26 下午
 */
@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PicacomicProperties picacomic;

    @Override
    public String login(LoginBody loginBody) {

        MultiValueMap<String, String> tokenParams = new LinkedMultiValueMap<>();
        tokenParams.add("email", loginBody.getEmail());
        tokenParams.add("password", loginBody.getPassword());

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<>(tokenParams, headers);

        ResponseEntity<PicacomicModel> entity = restTemplate.postForEntity(
                picacomic.getBase(), requestEntity, PicacomicModel.class);

        return null;
    }


}
