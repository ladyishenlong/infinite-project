package com.ladyishenlong.securityjwtservice.config.security;

import com.ladyishenlong.securityjwtservice.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/25 8:58 上午
 */
@Slf4j
public class UserFilter extends GenericFilterBean {

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        //获取token信息
//        String jwtToken = req.getHeader("authorization");

        //解析token，获取用户信息
//        Claims claims = Jwts.parser().setSigningKey("sang@123")
//                .parseClaimsJws(jwtToken.replace("Bearer",""))
//                .getBody();

//        String username = claims.getSubject();//获取当前登录用户名
//        List<GrantedAuthority> authorities =
//                AuthorityUtils.commaSeparatedStringToAuthorityList((String)
//                        claims.get("authorities"));

        log.info("token校验的过滤器");

        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "root";
            }
        });

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        "1234", null, authorities);
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(req,response);
    }
}
