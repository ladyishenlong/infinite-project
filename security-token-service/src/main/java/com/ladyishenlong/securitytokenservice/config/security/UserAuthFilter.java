package com.ladyishenlong.securitytokenservice.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ladyishenlong.responseutils.ResponseUtils;
import com.ladyishenlong.securitytokenservice.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/24 8:54 上午
 */
@Slf4j
public class UserAuthFilter extends UsernamePasswordAuthenticationFilter {

    public UserAuthFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        setFilterProcessesUrl(defaultFilterProcessesUrl);
        setAuthenticationManager(authenticationManager);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        String username = obtainUsername(request);//用户名
        String password = obtainPassword(request);//密码

        if (StringUtils.isEmpty(username)) username = "";
        if (StringUtils.isEmpty(password)) password = "";

        //也可以在这里设置成短信验证码等数据
        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(username, password);

        return getAuthenticationManager().authenticate(authRequest);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String username = obtainUsername(request);//用户名

        //todo 从数据中查出权限以及secret
        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority("root"));
        String token = TokenUtils.createToken(username,"secret",authorities);

        //将token数据返回前台
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        //ObjectMapper().writeValueAsString() 将java字符转为了json
        out.write(new ObjectMapper().writeValueAsString(
                ResponseUtils.success("登录成功",token)));
        out.flush();
        out.close();
    }


    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(
                ResponseUtils.failure(HttpStatus.UNAUTHORIZED.value(),
                        "登录失败",failed.getMessage())));
        out.flush();
        out.close();
    }



}
