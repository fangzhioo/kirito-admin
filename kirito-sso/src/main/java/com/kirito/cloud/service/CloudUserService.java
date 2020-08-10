package com.kirito.cloud.service;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.sso.pojo.bo.LoginUserBO;
import com.kirito.cloud.sso.pojo.bo.RegisterUserBO;
import com.kirito.cloud.sso.pojo.bo.SsoUserBO;

public interface CloudUserService {
    CommonResult<SsoUserBO> login(LoginUserBO loginUserBO);

    CommonResult<Integer> register(RegisterUserBO registerUserBO);

    CommonResult<SsoUserBO> getUserById(Integer id);
}
