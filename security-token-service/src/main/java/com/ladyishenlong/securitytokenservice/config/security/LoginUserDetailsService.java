package com.ladyishenlong.securitytokenservice.config.security;

import com.ladyishenlong.securitytokenservice.test.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 10:48 上午
 * <p>
 * 1. 该类主要用于根据用户名获取用户的密码，用户权限，
 * 验证码等信息，在多数情况下需要查询数据库或者redis，
 * 所以该类必须是依赖注入使用
 */
@Slf4j
@Component
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    private Student student;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //密码需要加密
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        //TODO 如果用户没有被查询到，可以直接抛出 UsernameNotFoundException
        //TODO 数据库查询 获取  用户名 密码 secret 权限 验证码 等信息
        //TODO spring security 框架默认用户名密码，如果使用验证码方式，直接在后台写死一个固定密码，否则会有问题

        //测试环境 写死一个用户信息
        return new UserModel(student.getUsername(), encoder.encode(student.getPassword()),
                student.getSecret(), student.getVerificationcode(), student.getAuthorities());
    }

}
