package com.ladyishenlong.infinitegateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @Author ruanchenhao
 * @Date 2019/10/9 11:12 上午
 * 限流配置
 */
@Component
public class RateLimiterConfig {

    /**
     * 根据请求参数中user字段来限流
     *
     * @return
     */
//    @Bean
//    public KeyResolver userKeyResolver() {
//        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("user")));
//    }

    /**
     * 根据ip地址限流
     *
     * @return
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostName());
    }
}
