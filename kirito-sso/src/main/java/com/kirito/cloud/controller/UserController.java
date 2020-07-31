package com.kirito.cloud.controller;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.pojo.LoginUser;
import com.kirito.cloud.pojo.RegisterUser;
import com.kirito.cloud.service.CloudUserService;
import com.kirito.cloud.sso.pojo.SsoUserBO;
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
    public CommonResult<SsoUserBO> authUser(@RequestBody LoginUser loginUser){
        return cloudUserService.login(loginUser);
    }

    @PostMapping("/register")
    public CommonResult<Integer> register(@RequestBody RegisterUser registerUser){
        return cloudUserService.register(registerUser);
    }

}
