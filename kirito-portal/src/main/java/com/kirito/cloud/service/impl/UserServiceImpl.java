package com.kirito.cloud.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.kirito.cloud.CommonResult;
import com.kirito.cloud.common.Preconditions;
import com.kirito.cloud.pojo.bo.AuthBO;
import com.kirito.cloud.service.UserService;
import com.kirito.cloud.sso.pojo.bo.LoginUserBO;
import com.kirito.cloud.sso.pojo.bo.RegisterUserBO;
import com.kirito.cloud.sso.pojo.bo.SsoUserBO;
import com.kirito.cloud.utils.CookieUtils;
import com.kirito.cloud.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;
    @Resource
    private RestTemplate restTemplate;
    @Value("${server-url.nacos-sso-service}")
    private String ssoServerUrl;
    @Override
    public CommonResult<SsoUserBO> current() {
        String token = CookieUtils.getValue(request, "my_token");
        Preconditions.checkNotNull(token,"尚未登录！");
        JSONObject jsonObject = TokenUtils.decodeToken(token);
        Preconditions.checkNotNull(jsonObject,"尚未登录！");
        Object userId = jsonObject.get("userId");
        String url = ssoServerUrl+ "/user/" + userId;
        ParameterizedTypeReference<CommonResult<SsoUserBO>> typeReference = new ParameterizedTypeReference<CommonResult<SsoUserBO>>() {};
        ResponseEntity<CommonResult<SsoUserBO>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, typeReference);
        return responseEntity.getBody();
    }

    @Override
    public CommonResult<AuthBO> signIn(LoginUserBO loginUserBO) {
        String url = ssoServerUrl + "/user/auth";
        HttpEntity<LoginUserBO> entity = new HttpEntity<>(loginUserBO);
        ParameterizedTypeReference<CommonResult<SsoUserBO>> typeReference = new ParameterizedTypeReference<CommonResult<SsoUserBO>>() {};
        ResponseEntity<CommonResult<SsoUserBO>> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, typeReference);
        CommonResult<SsoUserBO> commonResult = responseEntity.getBody();
        Preconditions.checkNotNull(commonResult);
        if(CommonResult.checkStatus(commonResult.getCode())){
            SsoUserBO user = commonResult.getData();
            JSONObject obj = JSONUtil.createObj();
            obj.put("userName",user.getUserName());
            obj.put("userId",user.getUserId());
            obj.put("nickName",user.getNickName());
            obj.put("email",user.getEmail());
            String token = TokenUtils.createToken(obj);
            AuthBO result = new AuthBO();
            result.setUser(user);
            result.setToken(token);
            try {
                CookieUtils.set(response,"my_token",token, loginUserBO.getRemember());
            }catch (Exception e){

            }

            return CommonResult.success(result);
        }else{
            return CommonResult.failed(commonResult.getMsg());
        }
    }

    @Override
    public CommonResult<Integer> signUp(RegisterUserBO registerUserBO) {
        String url = ssoServerUrl + "/user/register";
        HttpEntity<RegisterUserBO> httpEntity = new HttpEntity<>(registerUserBO);
        ParameterizedTypeReference<CommonResult<Integer>> typeReference = new ParameterizedTypeReference<CommonResult<Integer>>() {};
        ResponseEntity<CommonResult<Integer>> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, typeReference);
        return responseEntity.getBody();
    }
}
