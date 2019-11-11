package com.ladyishenlong.securitytokenservice.config.security;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 4:07 下午
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //这个类则是从数据库查询用户信息的地方
    @Autowired
    private LoginUserDetailsService loginUserDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.headers().cacheControl();//禁用缓存

        http
                .cors()
                .and()
                .formLogin().disable()
                .csrf().disable()//禁用csrf防护
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//关闭session

                .and()

                //配置请求的权限
                .authorizeRequests()

                //放行springdoc-openapi-ui,与swagger类似
                .antMatchers("/v3/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()




                .antMatchers("/login").permitAll()
                .antMatchers("/test").permitAll()

                //需要特定用户的权限
                .antMatchers("/test3")
                .access("@AuthService.role('bigboss',request)")
                //普通的请求  使用权限表达氏过滤
                .anyRequest()
                .access("@AuthService.auth(request)")


                .and()
                .authenticationProvider(getLoginAuthProvider())
                .httpBasic()

                .and()
                .exceptionHandling()
                //未授权处理
                .authenticationEntryPoint(new UnAuthorizedEntryPoint())

                .and()

                //登录请求经过的过滤器
                .addFilterBefore(new UserAuthFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
        ;

    }


    @Bean
    public LoginAuthProvider getLoginAuthProvider() {
        //采用该方式初始化，在LoginAuthProvider中除了构造函数之外可以依赖注入
        //将自定义的用来验证用户信息是否正确合法的类放入security之中
        return new LoginAuthProvider(loginUserDetailsService);
    }

}
