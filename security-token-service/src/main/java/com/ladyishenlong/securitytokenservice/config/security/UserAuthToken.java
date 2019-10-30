package com.ladyishenlong.securitytokenservice.config.security;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2019/10/29 9:59 上午
 * 自定义用户登录请求时上传的参数
 */
@Data
public class UserAuthToken extends UsernamePasswordAuthenticationToken {

    private final Object verificationcode;

    public UserAuthToken(Object principal, Object credentials, Object verificationcode) {
        super(principal, credentials);
        this.verificationcode = verificationcode;
    }

}
