package com.ladyishenlong.securityjwtservice.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;

/**
 * @Author ruanchenhao
 * @Date 2019/10/25 9:54 上午
 */
@Slf4j
public class TokenAuthFilter extends BasicAuthenticationFilter {


    public TokenAuthFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String token = request.getHeader("Authorization");
        log.info("查看token信息：{}", token);
        if (StringUtils.isEmpty(token)) {

            List<GrantedAuthority> permissions = new ArrayList<>();

        }

        chain.doFilter(request, response);
    }


}
