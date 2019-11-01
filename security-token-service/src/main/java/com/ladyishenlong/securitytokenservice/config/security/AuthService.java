package com.ladyishenlong.securitytokenservice.config.security;

import com.ladyishenlong.securitytokenservice.test.Student;
import com.ladyishenlong.securitytokenservice.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ruanchenhao
 * @Date 2019/10/29 3:21 下午
 * 校验token
 */
@Slf4j
@Component(value = "AuthService")
public class AuthService {


    @Autowired
    private Student student;

    public boolean authenticated(HttpServletRequest request, Authentication authentication)
            throws AuthenticationException {

        String token = request.getHeader(TokenUtils.AUTHORIZATION);
        Object principal = authentication.getPrincipal();

        log.info("查看principal:{}", principal);

        if (StringUtils.isEmpty(token)) throw new BadCredentialsException("该请求没有登录凭证");

        //有信息验证就通过了
        Claims claims = TokenUtils.parserToken(token, Student.secret);
        //TODO 在这里验证用户的权限角色

        String username = claims.getSubject();


        log.info("查看权限：{}",student.getA());


        UserAuthToken userAuthToken =
                new UserAuthToken(Student.username, Student.password, Student.authorities);


        SecurityContextHolder.getContext()
                .setAuthentication(userAuthToken);

        return true;
    }


}