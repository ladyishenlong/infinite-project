package com.ladyishenlong.securitytokenservice.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/24 10:32 上午
 */
public class TokenUtils {

    private static final String SECRET = "salt";


    public static String createToken(String username, String secret,
                                     List<GrantedAuthority> authorities) {
        return Jwts.builder()
                .setSubject(username)
                .claim("authorities", authorities)//配置用户角色
                .setIssuedAt(localDateTimeToDate(LocalDateTime.now())) //设置token发布时间
                .setExpiration(getExpirationDate(LocalDateTime.now(), 10000))//设置过期时间
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }



    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static Date getExpirationDate(LocalDateTime createTime, long calendarInterval) {
        LocalDateTime expirationDate = createTime.plus(calendarInterval, ChronoUnit.MINUTES);
        return localDateTimeToDate(expirationDate);
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
