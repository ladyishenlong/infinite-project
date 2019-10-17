package com.ladyishenlong.isoyuservice.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2019/10/17 4:20 下午
 */
@Data
@Component
@ConfigurationProperties("isoyu.url.news")
public class NewsProperties {
    private String banner;
}
