package com.ladyishenlong.securitytokenservice.config.security;

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
        http
                .formLogin()

                .and()
                .csrf().disable()//禁用csrf防护
                .sessionManagement()//session管理
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//使用 JWT，关闭session

                .and()
                .authorizeRequests()
                .antMatchers("/test").permitAll()
                .anyRequest().authenticated()// 所有请求必须认证

                .and().exceptionHandling()//认证失败返回401
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))

                .and()

//                .authenticationProvider(new UserAuthProvider(new SecurityUserDetails()))

                //对登录请求进行自定义的过滤
                .addFilterBefore(new UserAuthFilter(
                                "/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class);


        //TODO 普通请求进行过滤
        ;
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getLoginAuthProvider());//自定义验证验证的provider
    }




    /**
     * 使用该方法初始化，除了在构造方法之中，
     * 其余地方调用注入方法不会为空
     *
     * @return
     */
    @Bean
    public LoginAuthProvider getLoginAuthProvider() {
        return new LoginAuthProvider(loginUserDetailsService);
    }


}
