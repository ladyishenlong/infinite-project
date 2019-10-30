package com.ladyishenlong.securitytokenservice.model;

import lombok.Data;

/**
 * @Author ruanchenhao
 * @Date 2019/10/30 2:54 下午
 */
public enum AuthCode {


    EXPIRED(1001, "1001", "登录凭证已过期");


    private int code;
    private String codeValue;
    private String reason;


    AuthCode(int code, String codeValue, String reason) {
        this.code = code;
        this.codeValue = codeValue;
        this.reason = reason;
    }


}
