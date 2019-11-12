package com.ladyishenlong.springdocopenapiweb.controller;

import com.ladyishenlong.springdocopenapiweb.model.UserModel;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author ruanchenhao
 * @Date 2019/11/6 2:21 下午
 * 生成接口文档的注解
 */

@SecurityScheme(
        name = "安全认证注解",
        description = "这是描述",
        type = SecuritySchemeType.OPENIDCONNECT,
        in = SecuritySchemeIn.HEADER,
        flows = @OAuthFlows(
                implicit = @OAuthFlow(
                        authorizationUrl = "http://url.com/auth",
                        scopes = @OAuthScope(name = "write:pets",
                                description = "modify pets in your account"))))


@Slf4j
@RestController
@Tag(name = "TestController")
public class TestController {

    @Operation(summary = "hello world的接口")
    @GetMapping("/hello/{id}")
    public String hello(@PathVariable String id) {
        return "hello world v3";
    }

    @Operation(summary = "测试登录的接口",
            description = "描述的文字",
            responses = {
                    @ApiResponse(description = "登录信息",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserModel.class))),
                    @ApiResponse(responseCode = "400", description = "返回400时候错误的原因")},
            security = @SecurityRequirement(name = "需要认证"))
    @GetMapping("/login")
    public UserModel login(
            @Parameter(description = "用户名")
            @RequestParam(value = "username", required = false) String username,
            @Parameter(description = "密码")
            @RequestParam(value = "password") String password) {
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        return userModel;
    }


    @Operation(summary = "swagger v3 信息全部写头上", description = "描述的文字",
            parameters = {
                    @Parameter(name = "auth", description = "请求头", in = ParameterIn.HEADER),
                    @Parameter(name = "id", description = "id", in = ParameterIn.PATH),
                    @Parameter(name = "param", description = "参数"),
            },
            responses = {@ApiResponse(responseCode = "400", description = "400错误")},
            security = @SecurityRequirement(name = "需要认证",scopes = "true"))
    @GetMapping("/param/{id}")
    public String param(HttpServletRequest httpServletRequest,
                        @RequestParam(value = "param") String param,
                        @PathVariable(value = "id") String id) {
        String auth = httpServletRequest.getHeader("auth");
        return "查看参数： " + auth;
    }


    //@Hidden//可以隐藏该接口
    @Operation(summary = "测试上传用户信息", responses = {
            @ApiResponse(description = "用户信息",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserModel.class))),
    })
    @PostMapping("/user")
    public UserModel user(@RequestBody UserModel userModel) {
        return userModel;
    }


}
