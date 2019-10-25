package com.ladyishenlong.securityjwtservice.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/10/23 10:48 上午
 * spring security 验证用户信息
 */
@Slf4j
@Component
public class SecurityUserDetails implements UserDetailsService {

    /**
     * 在这里根据传入的用户名获取用户权限，用户密码等信息
     * security框架会自行进行验证
     * 这里设置的测试用户名密码都是 123 权限为root
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("用户登录信息验证：{}",username);

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        //用户可以有多种权限，所以这里使用list
        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority("root"));

        if(!"123".equals(username))throw new UsernameNotFoundException(username);

        return new User(username, encoder.encode("123"),authorities);
    }

}
