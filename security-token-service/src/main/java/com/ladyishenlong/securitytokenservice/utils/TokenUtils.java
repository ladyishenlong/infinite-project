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
                    .parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjMiLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiYWRtaW4ifSx7ImF1dGhvcml0eSI6InJvb3QifV0sImlhdCI6MTU3MjkxNzk3NywiZXhwIjoxNTcyOTI3OTc3fQ.GNLzzrlpmImeNzfeU0BJ_IK-9OjbhXxITG-fwpgSeaTztte9qOICzq0StJzW_xmGt_r42PQz-N-NWZsOINbidQ")
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
