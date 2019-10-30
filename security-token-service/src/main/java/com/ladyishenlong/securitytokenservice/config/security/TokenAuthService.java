package com.ladyishenlong.securitytokenservice.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ruanchenhao
 * @Date 2019/10/29 3:21 下午
 */
@Slf4j
@Component(value = "tokenAuthService")
public class TokenAuthService {


    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        log.info("进入运行");

        return true;
    }


}
 