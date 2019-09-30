package com.ladyishenlong.picacomicservice.model;

import lombok.Data;

/**
 * @Author ruanchenhao
 * @Date 2019/9/30 2:21 下午
 */
@Data
public class PicacomicModel<T> {

    private int code;
    private String message;
    private T data;

}
