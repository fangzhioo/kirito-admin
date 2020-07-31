package com.kirito.cloud.service;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.pojo.LoginUser;
import com.kirito.cloud.pojo.RegisterUser;
import com.kirito.cloud.sso.pojo.SsoUserBO;

public interface CloudUserService {
    CommonResult<SsoUserBO> login(LoginUser loginUser);

    CommonResult<Integer> register(RegisterUser registerUser);

    CommonResult<SsoUserBO> getUserById(Integer id);
}
