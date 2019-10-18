package com.ladyishenlong.apiopenservice.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2019/9/29 4:43 下午
 */
@Data
@Component
@ConfigurationProperties("apiopen.url")
public class ApiopenProperties {

    private String base;
    private String wangYiNews;//网易新闻

    private String musicRankings;//音乐排行版


}
