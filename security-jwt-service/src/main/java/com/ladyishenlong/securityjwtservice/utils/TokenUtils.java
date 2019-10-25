package com.ladyishenlong.securityjwtservice.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

/**
 * @Author ruanchenhao
 * @Date 2019/10/24 10:32 上午
 */
public class TokenUtils {

    public static String createToken() {
        return Jwts.builder()
                .setSubject("niceyoo")//可以设置成用户名，解析后得到用户名
                .claim("authorities", "admin")//配置用户角色
                .setExpiration(new Date(System.currentTimeMillis() + 7 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "tmax")
                .compact();
    }

    public void parserToken() {
        try {

            Claims claims = Jwts.parser()
                    .setSigningKey("tmax")
                    .parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuaWNleW9vIiwiYXV0aG9yaXRpZXMiOiJhZG1pbiIsImV4cCI6MTU1OTQ1OTc2Mn0.MkSJtGaVePLa-eM3gylh1T3fwODg-6ceDDOxscXAQKun-qNrbQFcKPNqXhblbXPNLhaJyEnwugNANCTs98UNmA")
                    .getBody();
            System.out.println(claims);
            String username = claims.getSubject();
            System.out.println("username:" + username);
            String authority = claims.get("authorities").toString();
            System.out.println("权限：" + authority);
        } catch (ExpiredJwtException e) {
            System.out.println("jwt异常");
        } catch (Exception e) {
            System.out.println("异常");
        }
    }

}
