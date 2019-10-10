package com.ladyishenlong.isoyuservice.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2019/10/10 11:21 上午
 */
@Data
@Component
@ConfigurationProperties("isoyu.url")
public class IsoyuProperties {
    private String base;
    private String cosplay;
}
