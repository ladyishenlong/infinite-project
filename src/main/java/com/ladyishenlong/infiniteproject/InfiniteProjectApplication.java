package com.ladyishenlong.infiniteproject;

import com.ladyishenlong.responseutils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class InfiniteProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfiniteProjectApplication.class, args);
    }

}
