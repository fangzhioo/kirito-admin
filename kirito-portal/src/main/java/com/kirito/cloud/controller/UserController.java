package com.kirito.cloud.controller;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.service.UserService;
import com.kirito.cloud.sso.pojo.bo.LoginUserBO;
import com.kirito.cloud.sso.pojo.bo.RegisterUserBO;
import com.kirito.cloud.pojo.bo.AuthBO;
import com.kirito.cloud.sso.pojo.bo.SsoUserBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
@Api
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/current")
    @ApiOperation("获取当前用户信息，需要携带cookie")
    public CommonResult<SsoUserBO> current(){
       return userService.current();
    }

    @PostMapping("/signIn")
    @ApiOperation("用户登陆")
    public CommonResult<AuthBO> signIn(@RequestBody LoginUserBO loginUserBO){
        return userService.signIn(loginUserBO);
    }

    @PostMapping("/signUp")
    @ApiOperation("用户注册")
    public CommonResult<Integer> signUp(@RequestBody RegisterUserBO registerUserBO){
        return userService.signUp(registerUserBO);
    }
}
