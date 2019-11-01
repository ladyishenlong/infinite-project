package com.ladyishenlong.securitytokenservice.test;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/28 4:02 下午
 */
@Data
@Component
public class Student {

    public final static String username = "123";
    public final static String password = "456";
    public final static String verificationcode = "789";
    public final static String secret = "secretKey";
    public final static List<GrantedAuthority> authorities = Collections.singletonList(
            new SimpleGrantedAuthority("root"));


    private String a = "123";

}
