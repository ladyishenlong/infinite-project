package com.ladyishenlong.picacomicservice.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2019/9/30 2:17 下午
 */
@Data
@Component
@ConfigurationProperties("picacomic.url")
public class PicacomicProperties {

    private String base;

}
