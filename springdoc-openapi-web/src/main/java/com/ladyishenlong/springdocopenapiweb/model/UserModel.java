package com.ladyishenlong.springdocopenapiweb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author ruanchenhao
 * @Date 2019/11/6 4:32 下午
 */
@Data
@Schema(name="UserModel", description="用户model")
public class UserModel {

    @Schema(description = "用户名")
    private String username;
    @Schema(description="密码")
    private String password;

}
