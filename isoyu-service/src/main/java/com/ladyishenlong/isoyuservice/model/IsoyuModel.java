package com.ladyishenlong.isoyuservice.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/10/10 1:24 下午
 */
@Data
public class IsoyuModel<T> implements Serializable {
    private int code;
    private String message;
    private T data;
}
