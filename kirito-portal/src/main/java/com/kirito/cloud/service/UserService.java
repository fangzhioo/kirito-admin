package com.kirito.cloud.service;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.pojo.bo.AuthBO;
import com.kirito.cloud.sso.pojo.bo.LoginUserBO;
import com.kirito.cloud.sso.pojo.bo.RegisterUserBO;
import com.kirito.cloud.sso.pojo.bo.SsoUserBO;

public interface UserService {
    CommonResult<SsoUserBO> current();

    CommonResult<AuthBO> signIn(LoginUserBO loginUserBO);

    CommonResult<Integer> signUp(RegisterUserBO registerUserBO);
}
