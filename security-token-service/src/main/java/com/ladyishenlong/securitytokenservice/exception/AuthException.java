package com.ladyishenlong.securitytokenservice.exception;

import lombok.Data;
import org.springframework.security.core.AuthenticationException;

/**
 * @Author ruanchenhao
 * @Date 2019/11/11 2:24 下午
 */
@Data
public class AuthException extends AuthenticationException {

    private int code;

    public AuthException(int code) {
        super("");
        this.code=code;
    }

    public AuthException(String msg) {
        super(msg);
    }
}
