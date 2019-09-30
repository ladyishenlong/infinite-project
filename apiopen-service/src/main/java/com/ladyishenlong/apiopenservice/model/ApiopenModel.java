package com.ladyishenlong.apiopenservice.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/9/29 5:05 下午
 * 返回的固定格式
 */
@Data
public class ApiopenModel<T> implements Serializable {
    private int code;
    private String message;
    private T result;
}
