package com.ladyishenlong.picacomicservice.service;

import com.ladyishenlong.picacomicservice.model.request.LoginBody;
import org.springframework.stereotype.Service;

/**
 * @Author ruanchenhao
 * @Date 2019/9/30 2:24 下午
 */
@Service
public interface LoginService {

    String login(LoginBody loginBody);

}
