package com.ladyishenlong.securitytokenservice.config.security;

import com.ladyishenlong.responseutils.ResponseUtils;
import com.ladyishenlong.securitytokenservice.utils.WriteUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @Author ruanchenhao
 * @Date 2019/10/30 1:39 下午
 */
public class UnAuthorizedEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        int code = HttpStatus.UNAUTHORIZED.value();
        response.setStatus(code);
        WriteUtils.writeJson(response, ResponseUtils.failure(code,
                "请求未授权", authException.getMessage()));
    }

}
