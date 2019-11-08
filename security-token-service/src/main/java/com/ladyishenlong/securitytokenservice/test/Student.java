package com.ladyishenlong.securitytokenservice.test;

import lombok.Data;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ruanchenhao
 * @Date 2019/10/28 4:02 下午
 * <p>
 * 作为数据库中的储存的用户信息
 */
@Data
@Component
public class Student {

    public String username = "123";
    public String password = "456";
    public String verificationcode = "789"; //验证码
    public String secret = "secretKey"; // token的密钥
    public Set<GrantedAuthority> authorities; //用户权限

    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("root"));
        authorities.add(new SimpleGrantedAuthority("admin"));
        return authorities;
    }
}
