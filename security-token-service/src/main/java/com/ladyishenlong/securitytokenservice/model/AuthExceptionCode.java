package com.ladyishenlong.securitytokenservice.model;

import org.springframework.http.HttpStatus;

/**
 * @Author ruanchenhao
 * @Date 2019/10/30 2:54 下午
 */
public enum AuthExceptionCode {


    EXPIRED(1001, "1001", "登录凭证已过期"),
    EMPTY(1002, "1002", "登录凭证为null或者空"),
    SIGN(1003, "1003", "登录凭证签名验证失败"),
    MALFORMED(1004, "1004", "登录凭证格式错误"),
    UNSUPPORTED(1005, "1005", "不支持该登录凭证"),
    UNKNOW(1006, "1006", "未知错误");


    private int code;
    private String codeValue;
    private String reason;


    AuthExceptionCode(int code, String codeValue, String reason) {
        this.code = code;
        this.codeValue = codeValue;
        this.reason = reason;
    }

    public String getCodeValue() {
        return this.codeValue;
    }


}
