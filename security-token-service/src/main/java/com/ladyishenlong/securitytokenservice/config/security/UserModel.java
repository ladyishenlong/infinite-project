package com.ladyishenlong.securitytokenservice.config.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Author ruanchenhao
 * @Date 2019/10/28 4:33 下午
 * 用户登录所需要传入的信息
 * 在用户名密码的基础上增加了验证码verificationcode
 * 而secret则是后台生成的数据，最后用于生成token
 */
@Data
public class UserModel extends User {


    private String secret;
    private String verificationcode;

    public UserModel(String username, String password, String secret, String verificationcode,
                     Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.secret = secret;
        this.verificationcode = verificationcode;
    }


}
