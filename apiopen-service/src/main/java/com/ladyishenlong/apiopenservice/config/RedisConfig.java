//package com.ladyishenlong.apiopenservice.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @Author ruanchenhao
// * @Date 2019/9/30 9:39 上午
// */
//@EnableCaching
//@Configuration
//public class RedisConfig {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Bean
//    public RedisTemplate redisTemplateInit() {
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        // 设置序列化Key的实例化对象
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        // 设置序列化Value的实例化对象
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        return redisTemplate;
//    }
//
//
//}
