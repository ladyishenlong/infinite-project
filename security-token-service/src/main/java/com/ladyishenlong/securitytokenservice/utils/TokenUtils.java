package com.ladyishenlong.securitytokenservice.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/24 10:32 上午
 */
public class TokenUtils {

    public static final String AUTHORIZATION = "Authorization";//header
    public static final String BEARER = "Bearer";//token header

    public static final String AUTHORITIES = "authorities";
    public static final int TIME_OUT = 10000;

    public static String createToken(String username, String secret,
                                     Collection<GrantedAuthority> authorities) {
        return Jwts.builder()
                .setSubject(username)
                .claim(AUTHORITIES, authorities)//配置用户权限(角色)
                .setIssuedAt(DateUtils.createDate()) //设置token发布时间
                .setExpiration(DateUtils.expirationDate(TIME_OUT))//设置过期时间
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    public static Claims parserToken(String token, String secret) throws AuthenticationException {
        try {
            return Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new BadCredentialsException("登录凭证已过期");
        }catch (Exception e){
            throw new BadCredentialsException("其他问题，之后再分");
        }
    }


    public static void aa() {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("JG2019JWT123")
                    .parseClaimsJws("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJOYW1lIjoiSnd0VG9rZW5UZXN0IiwiVXNlckRhdGEiOiJ7XCJVc2VySWRcIjpcIjExMVwiLFwiRGlzcGxheU5hbWVcIjpcIua1i-ivlVwifSIsIkV4cGlyZWQiOnRydWV9.PIwzjEQkpwS4pon_SN8DRzhYo9OeGBuioUvwp1M6-sU")
                    .getBody();
            System.out.println(claims);
            String username = claims.getSubject();
            System.out.println("username:" + username);
            String authority = claims.get("authorities").toString();
            System.out.println("权限：" + authority);

        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            System.out.println("jwt异常");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常");
        }
    }

}
