package com.ladyishenlong.picacomicservice.model.request;

import lombok.Data;

/**
 * @Author ruanchenhao
 * @Date 2019/9/30 2:25 下午
 */
@Data
public class LoginBody {
    private String email;
    private String password;
}
