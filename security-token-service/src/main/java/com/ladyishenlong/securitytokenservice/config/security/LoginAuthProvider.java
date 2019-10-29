package com.ladyishenlong.securitytokenservice.config.security;

import com.ladyishenlong.securitytokenservice.test.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
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

        UserModel userModel = (UserModel) userDetails;//从数据库查出来的参数
        UserAuthToken userAuthToken = (UserAuthToken) authentication;//登录请求携带的参数

        if (((UserAuthToken) authentication).getPrincipal() == null ||
                StringUtils.isEmpty(((UserAuthToken) authentication).getPrincipal().toString()))
            throw new BadCredentialsException("用户名为空");

        if (((UserAuthToken) authentication).getVerificationcode() == null ||
                StringUtils.isEmpty(((UserAuthToken) authentication).getVerificationcode().toString()))
            throw new BadCredentialsException("验证码为空");

        if (((UserAuthToken) authentication).getCredentials() == null ||
                StringUtils.isEmpty(((UserAuthToken) authentication).getCredentials().toString()))
            throw new BadCredentialsException("密码为空");


        String presentedVerificationcode = userAuthToken.getVerificationcode().toString();
        String presentedPassword = userAuthToken.getCredentials().toString();

        if (!presentedVerificationcode.equals(userModel.getVerificationcode()))
            throw new BadCredentialsException("验证码不正确");

        if (!getPasswordEncoder().matches(presentedPassword, userDetails.getPassword()))
            throw new BadCredentialsException("密码不正确");

    }


}
