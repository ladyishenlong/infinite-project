package com.ladyishenlong.securityjwtservice.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ladyishenlong.securityjwtservice.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StreamUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author ruanchenhao
 * @Date 2019/10/24 8:54 上午
 * 访问 /login 的请求进入此处
 */
@Slf4j
public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher("/login", "POST"));
        setAuthenticationManager(authenticationManager);
    }


    /**
     * 登录时需要验证时候调用
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     * @throws IOException
     */
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException {

//        if(false)throw new AuthenticationServiceException("读取登录请求参数异常");
//        User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
//        log.info("登录用户信息：{}",user);

        String jsonparam = StreamUtils.copyToString(request.getInputStream(),
                StandardCharsets.UTF_8);

        log.info("查看登录信息：{}", jsonparam);

        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken
                        ("123", "123");

        return getAuthenticationManager().authenticate(authRequest);
    }


    /**
     * 验证成功后调用
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("登录成功");

        String token = TokenUtils.createToken();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(token));
        out.flush();
        out.close();
    }

    /**
     * 验证失败后调用
     *
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("登录失败!");
        out.flush();
        out.close();
        log.info("登录失败");
    }
}
