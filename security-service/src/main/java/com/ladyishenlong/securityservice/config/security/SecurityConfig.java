package com.ladyishenlong.securityservice.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.annotation.Resource;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 10:57 上午
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private SessionRegistry sessionRegistry;

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//配置请求的权限
                .antMatchers("/test").permitAll() //放行配置的请求
                .anyRequest().authenticated()//默认不放行请求

                .and().formLogin()//需要登录时候，转到登录页面
                .successHandler(new SuccessHandler()) //登录成功，执行

                //登录失败，返回401异常，设置这个不会跳转到security默认登录页面
                .and().exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))

                .and().csrf().disable()//后台服务提供api调用需要关闭csrf防护

                .sessionManagement() //配置session管理策略
                .maximumSessions(1)//最大并行有效session数目
                .sessionRegistry(sessionRegistry) //后登陆的使先登录的session失效

        ;
    }


}
