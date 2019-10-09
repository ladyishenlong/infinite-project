package com.ladyishenlong.apiopenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableConfigurationProperties
@SpringBootApplication
public class ApiopenServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiopenServiceApplication.class, args);
    }

}
