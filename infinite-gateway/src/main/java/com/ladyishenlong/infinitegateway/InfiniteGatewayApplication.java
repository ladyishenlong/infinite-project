package com.ladyishenlong.infinitegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InfiniteGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfiniteGatewayApplication.class, args);
    }



}
