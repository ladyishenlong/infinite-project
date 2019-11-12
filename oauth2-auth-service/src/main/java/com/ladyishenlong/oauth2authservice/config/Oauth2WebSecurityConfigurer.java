package com.ladyishenlong.oauth2authservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

/**
 * @Author ruanchenhao
 * @Date 2019/11/11 3:54 下午
 * http://localhost:10007/oauth/authorize?client_id=123&response_type=code
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class Oauth2WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login.html")//用js区分手机和web？
                .and()
                .authorizeRequests()
                //放行登录和身份验证接口
                .antMatchers("/login").permitAll()
                .antMatchers("/oauth/**").permitAll()
                .anyRequest().authenticated()
                //要是没有登录，抛出401异常
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and().cors()
                .and().csrf().disable();
    }
}