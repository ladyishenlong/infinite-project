package com.ladyishenlong.securitytokenservice.config.security;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 4:07 下午
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private LoginUserDetailsService loginUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.headers().cacheControl();//禁用缓存

        http
                .formLogin()

                .and()

                .csrf().disable()//禁用csrf防护
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//关闭session

                .and()
                .authorizeRequests()
                .antMatchers("/test").permitAll()
                .antMatchers("/login").permitAll()

                .anyRequest().access("@tokenAuthService.hasPermission(request,authentication)")

                //.authenticated()// 所有请求必须认证

                .and().exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))

                .and()
                .addFilterAfter(new UserAuthFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getLoginAuthProvider());//自定义验证验证的provider
    }


    @Bean
    public LoginAuthProvider getLoginAuthProvider() {
        return new LoginAuthProvider(loginUserDetailsService);
    }


}
