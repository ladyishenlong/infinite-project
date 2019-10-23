package com.ladyishenlong.securitysessionservice.config.security;

import com.google.gson.Gson;
import com.ladyishenlong.responseutils.ResponseUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
        String result = new Gson().toJson(ResponseUtils.success("登录成功", request.getSession().getId()));
        //返回sessionId 用来验证登录请求
        PrintWriter writer = response.getWriter();
        writer.println(result);
        writer.close();
    }
}
