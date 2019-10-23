package com.ladyishenlong.securityservice.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.session.FlushMode;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionIdResolver;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 2:34 下午
 */
@EnableRedisHttpSession(flushMode = FlushMode.IMMEDIATE)
public class HttpSessionConfig {


    /**
     * 允许cookie鞋底啊sessionId信息
     * 默认cookie名称为SESSION
     *
     * @return
     */
    @Bean
    public CookieHttpSessionIdResolver cookieHttpSessionIdResolver() {
        return new CookieHttpSessionIdResolver();
    }


    /**
     * 允许携带sessionId在header中
     *
     * @return
     */
    @Bean
    public HeaderHttpSessionIdResolver httpSessionStrategy() {
        return new HeaderHttpSessionIdResolver("x-auth-token");
    }


}
