package com.ladyishenlong.securitytokenservice.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ladyishenlong.responseutils.ResponseUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author ruanchenhao
 * @Date 2019/10/30 10:34 上午
 */
public class WriteUtils {


    public static void writeJson(HttpServletResponse response, Object content) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        //new ObjectMapper().writeValueAsString() 将java字符转为了json
        out.write(new ObjectMapper().writeValueAsString(content));
        out.flush();
        out.close();
    }



    public static void writeLoginFailed(HttpServletResponse response,String msg) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter out = response.getWriter();
        //ObjectMapper().writeValueAsString() 将java字符转为了json
        out.write(new ObjectMapper()
                .writeValueAsString(ResponseUtils.failure("登录失败",msg)));
        out.flush();
        out.close();
    }



}
