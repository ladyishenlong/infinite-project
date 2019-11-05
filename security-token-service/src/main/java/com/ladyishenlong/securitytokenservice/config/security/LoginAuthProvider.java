package com.ladyishenlong.securitytokenservice.config.security;

import com.ladyishenlong.securitytokenservice.test.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author ruanchenhao
 * @Date 2019/10/29 8:36 上午
 * <p>
 * 用户比对用户上传信息与从数据库查询回来的信息是否一致
 */
@Slf4j
public class LoginAuthProvider extends DaoAuthenticationProvider {


    public LoginAuthProvider(LoginUserDetailsService loginUserDetailsService) {
        super();
        setUserDetailsService(loginUserDetailsService);//必须设置
    }


    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        //todo 还能做一些非空的判断

        UserModel userModel = (UserModel) userDetails;//从数据库查出来的参数
        UserAuthToken userAuthToken = (UserAuthToken) authentication;//登录请求携带的参数

        if (!getPasswordEncoder().matches(userAuthToken.getCredentials().toString(),
                userModel.getPassword()))
            throw new BadCredentialsException("密码错误");

        if (!userAuthToken.getVerificationcode()
                .equals(userModel.getVerificationcode()))
            throw new BadCredentialsException("验证码错误");

        log.info("验证用户：{},{}", userModel, userAuthToken);
    }


}
