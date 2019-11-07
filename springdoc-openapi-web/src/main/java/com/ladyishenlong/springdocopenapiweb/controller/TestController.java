package com.ladyishenlong.springdocopenapiweb.controller;

import com.ladyishenlong.springdocopenapiweb.model.UserModel;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;

/**
 * @Author ruanchenhao
 * @Date 2019/11/6 2:21 下午
 * 生成接口文档的注解
 */


@Slf4j
@RestController
@Tag(name = "TestController")
public class TestController {

    @Operation(summary = "hello world的接口")
    @GetMapping("/hello")
    public String hello() {
        return "hello world v3";
    }


    @Operation(summary = "测试登录的接口",
            responses = {
                    @ApiResponse(description = "登录信息",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserModel.class))),
                    @ApiResponse(responseCode = "400", description = "返回400时候错误的原因")})
    @GetMapping("/login")
    public UserModel login(
            @Parameter(description = "用户名")
            @RequestParam(value = "username", required = false) String username,
            @Parameter(description = "密码")
            @RequestParam(value = "password") String password) {

        log.info("不知道v3.swagger的注解参数是否能够代替原本的参数");
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        return userModel;
    }



    @Hidden//可以隐藏该接口
    @Operation(summary = "测试上传用户信息", responses = {
            @ApiResponse(description = "用户信息",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserModel.class))),
    })
    @PostMapping("/user")
    public UserModel user(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "用户上传信息")
            @RequestBody UserModel userModel) {
        return userModel;
    }


}
