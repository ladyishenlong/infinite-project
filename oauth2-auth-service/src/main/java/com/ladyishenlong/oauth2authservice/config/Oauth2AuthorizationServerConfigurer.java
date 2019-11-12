package com.ladyishenlong.oauth2authservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @Author ruanchenhao
 * @Date 2019-07-01 11:51
 */
@Configuration
@EnableAuthorizationServer //授权服务器
public class Oauth2AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {


    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("123")
                .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123")) //客户端 id/secret
                .authorizedGrantTypes("authorization_code", "refresh_token") //授权码模式
                .scopes("all")
                .redirectUris("https://www.baidu.com")
                .autoApprove(true) //自动审批
                .accessTokenValiditySeconds(36000)//有效期10hour
        ;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        /* 配置token获取合验证时的策略 */
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

}
