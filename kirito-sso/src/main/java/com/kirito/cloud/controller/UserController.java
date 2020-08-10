package com.kirito.cloud.controller;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.sso.pojo.bo.LoginUserBO;
import com.kirito.cloud.sso.pojo.bo.RegisterUserBO;
import com.kirito.cloud.service.CloudUserService;
import com.kirito.cloud.sso.pojo.bo.SsoUserBO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private CloudUserService cloudUserService;

    @GetMapping("/{id}")
    public CommonResult<SsoUserBO> getUserById(@PathVariable(value = "id") Integer id){
       return cloudUserService.getUserById(id);
    }

    @PostMapping("/auth")
    public CommonResult<SsoUserBO> authUser(@RequestBody LoginUserBO loginUserBO){
        return cloudUserService.login(loginUserBO);
    }

    @PostMapping("/register")
    public CommonResult<Integer> register(@RequestBody RegisterUserBO registerUserBO){
        return cloudUserService.register(registerUserBO);
    }

}
