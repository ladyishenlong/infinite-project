package com.ladyishenlong.securitytokenservice.utils;

import com.ladyishenlong.securitytokenservice.model.AuthExceptionCode;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UnknownFormatConversionException;

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
            throw new BadCredentialsException(AuthExceptionCode.EXPIRED.getCodeValue());
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException(AuthExceptionCode.EMPTY.getCodeValue());
        } catch (SignatureException e) {
            throw new BadCredentialsException(AuthExceptionCode.SIGN.getCodeValue());
        } catch (MalformedJwtException e) {
            throw new BadCredentialsException(AuthExceptionCode.MALFORMED.getCodeValue());
        } catch (UnsupportedJwtException e) {
            throw new BadCredentialsException(AuthExceptionCode.UNSUPPORTED.getCodeValue());
        }catch (Exception e){
            throw new BadCredentialsException(AuthExceptionCode.UNKNOW.getCodeValue());
        }
    }





    public static void aa() {
        try {

            //todo base64 加密问题
            Claims claims = Jwts
                    .parser()
                    .setSigningKey("secretKey")
                    .parseClaimsJws("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJqaW5ndWFuIiwic3ViIjoiMTEwMDExMSIsImF1ZCI6ImFsbCIsImV4cCI6MTU3MjU2ODE3MywiaWF0IjoxNTcyNTI0OTczLCJqdGkiOiI2NjViNmQ0MzdhNDc0OTJhYTkxMGFjZWYwNWJhMzgyOSJ9.BRHL36CLa3tA_e7yoslGbIl5Vmo-X2fpebn7D5SJaCo")

//                    .parseClaimsJws("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJqaW5ndWFuIiwic3ViIjoiMTEwMDExMSIsImF1ZCI6ImFsbCIsImV4cCI6MTU3MjU2ODE3MywiaWF0IjoxNTcyNTI0OTczLCJqdGkiOiI2NjViNmQ0MzdhNDc0OTJhYTkxMGFjZWYwNWJhMzgyOSJ9.V9BPCGQzS-NxLR83ng6BH06wkcxgVFpsKRwFGgnNJY0")
//                    .parseClaimsJws("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJqaW5ndWFuIiwic3ViIjoiMTEwMDExMSIsImF1ZCI6ImFsbCIsImV4cCI6MTU3MjU2NDA4NCwiaWF0IjoxNTcyNTIwODg0LCJqdGkiOiI1ZDkwZmE4MjAwYjA0YWM0YmMzNWVmMzAzYmFhOGM4MSJ9.MdAAN9R3oH3vsxYvVWFog5SGQTtAIgCwarzSVrkNI-Q")
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
