package com.ladyishenlong.apiopenservice.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/9/30 9:47 上午
 */
@Data
public class WangYiNewsModel implements Serializable {
    private String path;
    private String image;
    private String title;
    private String passtime;
}
