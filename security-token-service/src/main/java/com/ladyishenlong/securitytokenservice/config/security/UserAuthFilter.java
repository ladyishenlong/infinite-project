package com.ladyishenlong.securitytokenservice.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ladyishenlong.responseutils.ResponseUtils;
import com.ladyishenlong.securitytokenservice.test.Student;
import com.ladyishenlong.securitytokenservice.utils.TokenUtils;
import com.ladyishenlong.securitytokenservice.utils.WriteUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/24 8:54 上午
 * <p>
 * 访问登录的url 对用户信息进行验证
 * 验证通过返回token，其余接口通过token验证权限
 * <p>
 * filter不用使用依赖注入，所以不能在这里进行依赖注入
 * 因此密码验证码的判断并不是在此处进行
 */
@Slf4j
public class UserAuthFilter extends UsernamePasswordAuthenticationFilter {

    private static final String VERIFICATION_CODE = "verificationcode";//验证码

    public UserAuthFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        setFilterProcessesUrl(defaultFilterProcessesUrl);
        setAuthenticationManager(authenticationManager);
    }


    /**
     * 登录接口，用户粗
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        String username = obtainUsername(request);//用户名
        String password = obtainPassword(request);//密码
        String verificationcode = obtainVerificationCode(request);//验证码

        if (StringUtils.isEmpty(username)) username = "";
        if (StringUtils.isEmpty(password)) password = "";
        if (StringUtils.isEmpty(verificationcode)) verificationcode = "";

        UserAuthToken userAuthToken = new UserAuthToken(username, password, verificationcode);

        //将post请求传入的用户信息放入
        return getAuthenticationManager().authenticate(userAuthToken);
    }


    /**
     * 登录请求成功返回的的信息
     * 在这里返回的是token
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {

        UserModel userModel = (UserModel) (authResult.getPrincipal());

        //生成token
        String token = TokenUtils.createToken(userModel.getUsername(),
                userModel.getSecret(),
                userModel.getAuthorities());

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(
                ResponseUtils.success("登录成功", token)));
        out.flush();
        out.close();
    }


    /**
     * 登录请求失败返回的信息
     *
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        //也可以设置401状态码
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(
                ResponseUtils.failure(failed.getMessage())));
        out.flush();
        out.close();
    }


    @Nullable
    protected String obtainVerificationCode(HttpServletRequest request) {
        return request.getParameter(VERIFICATION_CODE);
    }


}
