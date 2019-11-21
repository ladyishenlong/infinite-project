package com.ladyishenlong.oauth2authservice.config;

import com.ladyishenlong.oauth2authservice.model.UserModel;
import com.ladyishenlong.oauth2authservice.serive.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

/**
 * @Author ruanchenhao
 * @Date 2019/11/13 9:58 上午
 */
@Slf4j
@Component
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        Optional<UserModel> userModel = userRepository.findById(username);

        if (userModel.isPresent()) {
            log.info("用户信息：{}", userModel.get());
            return new User(userModel.get().getUsername(),
                    encoder.encode(userModel.get().getPassword()),
                    new ArrayList<GrantedAuthority>(Collections
                            .singleton(new SimpleGrantedAuthority("root"))));
        } else throw new UsernameNotFoundException("用户不存在");
    }
}
