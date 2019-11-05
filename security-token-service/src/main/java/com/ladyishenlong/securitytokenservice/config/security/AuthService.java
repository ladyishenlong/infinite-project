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
import org.springframework.security.core.GrantedAuthority;
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
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * @Author ruanchenhao
 * @Date 2019/10/29 3:21 下午
 * 非登录请求需要校验token
 */
@Slf4j
@Component(value = "AuthService")
public class AuthService {


    @Autowired
    private Student student;

//    public boolean authenticated(HttpServletRequest request, Authentication authentication)
//            throws AuthenticationException {
//
//        String token = request.getHeader(TokenUtils.AUTHORIZATION);//获取头部token
//
//        // SecurityContextHolder.getContext()
//        //                .setAuthentication(userAuthToken)
//        //如果在之前的过滤器中已经调设置权限的方法，这里可以获取到用户信息
//        //在这里，authentication可以不传入
//        Object principal = authentication.getPrincipal();//当前用户信息
//
//        log.info("查看principal:{}", principal);
//
//        if (StringUtils.isEmpty(token)) throw new BadCredentialsException("该请求没有登录凭证");
//
//        //有信息验证就通过了
//        Claims claims = TokenUtils.parserToken(token, student.getSecret());
//        //TODO 在这里验证用户的权限角色
//
//        String username = claims.getSubject();
//
//        List<GrantedAuthority> authorities =
//                (List<GrantedAuthority>) (claims.get("authorities"));
//
//
//        log.info("盘算用户权限：" + authorities);
//
//        for (int i = 0; i < authorities.size(); i++) {
//            LinkedHashMap gu = (LinkedHashMap) authorities.get(i);
//            log.info("查看" + authorities.get(i));
//            log.info("查看信息：{}", gu.get("authority"));
//        }
//
//        log.info("查看权限：{}", student.getA());
//
//
//        UserAuthToken userAuthToken =
//                new UserAuthToken(Student.username, Student.password, Student.authorities);
//
//
//        SecurityContextHolder.getContext()
//                .setAuthentication(userAuthToken);
//
//        return true;
//    }


    /**
     * 普通请求认证
     *
     * @param request
     * @return
     * @throws AuthenticationException
     */
    public boolean auth(HttpServletRequest request)
            throws AuthenticationException {
        String token = request.getHeader(TokenUtils.AUTHORIZATION);
        //解析密钥是后台查询的
        Claims claims = TokenUtils.parserToken(token, student.getSecret());
        //用户名
        String username = claims.getSubject();
        UserAuthToken userAuthToken = new UserAuthToken(username);
        //设置Context
        SecurityContextHolder.getContext()
                .setAuthentication(userAuthToken);
        return true;
    }


    /**
     * 单个 用户权限验证
     *
     * @param role
     * @param request
     * @return
     */
    public boolean role(String role, HttpServletRequest request) {
        String token = request.getHeader(TokenUtils.AUTHORIZATION);
        //解析密钥是后台查询的
        Claims claims = TokenUtils.parserToken(token, student.getSecret());

        //用户名
        String username = claims.getSubject();
        //权限
        List<LinkedHashMap<String, String>> authorities =
                (List<LinkedHashMap<String, String>>) (claims.get("authorities"));


        boolean hasRole = false;
        for (LinkedHashMap<String, String> authority : authorities) {
            if (authority.get("authority").equals(role)) {
                hasRole = true;
                break;
            }
        }

        if (!hasRole) throw new BadCredentialsException("没有访问该接口的权限");


        UserAuthToken userAuthToken = new UserAuthToken(username);
        SecurityContextHolder.getContext()
                .setAuthentication(userAuthToken);
        return false;
    }


}