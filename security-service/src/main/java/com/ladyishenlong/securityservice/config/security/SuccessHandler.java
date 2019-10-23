package com.ladyishenlong.securityservice.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 1:57 下午
 * 登录成功后返回session id
 */
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        //返回sessionId 用来验证登录请求
        PrintWriter writer = response.getWriter();
        writer.println(request.getSession().getId());
        writer.close();
    }
}
