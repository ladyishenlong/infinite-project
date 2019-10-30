package com.ladyishenlong.securitytokenservice;

import com.ladyishenlong.securitytokenservice.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityTokenServiceApplicationTests {

    @Test
     void contextLoads() {
        TokenUtils.aa();
    }

}
