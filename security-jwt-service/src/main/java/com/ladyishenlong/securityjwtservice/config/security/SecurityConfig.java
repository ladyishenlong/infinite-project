package com.ladyishenlong.securityjwtservice.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 4:07 下午
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()

                .and()
                .csrf().disable()//禁用csrf防护
                .sessionManagement()//session管理
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//使用 JWT，关闭session

                .and()
                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()// 所有请求必须认证
                .and()

                .addFilterBefore(new TokenAuthenticationFilter(authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class);
        ;
    }


}
