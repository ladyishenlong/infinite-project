package com.ladyishenlong.oauth2authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * oauth2基础上还需要加个验证码
 */
@SpringBootApplication
public class Oauth2AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthServiceApplication.class, args);
    }

}
