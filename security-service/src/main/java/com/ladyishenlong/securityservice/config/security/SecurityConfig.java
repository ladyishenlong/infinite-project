package com.ladyishenlong.securityservice.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 10:57 上午
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/test").permitAll()//放行配置的请求
                .anyRequest().authenticated()//默认不放行请求

                .and()
                .formLogin()//需要登录时候，转到登录页面
                .and()


                .csrf().disable() // 禁用 Spring Security 自带的跨域处理
//                .sessionManagement() // 定制我们自己的 session 策略
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 调整为让 Spring Security 不创建和使用 session

        ;
    }


}
