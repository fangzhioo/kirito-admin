package com.kirito.cloud.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.kirito.cloud.CommonResult;
import com.kirito.cloud.common.Preconditions;
import com.kirito.cloud.pojo.LoginUser;
import com.kirito.cloud.pojo.RegisterUser;
import com.kirito.cloud.pojo.bo.AuthBO;
import com.kirito.cloud.sso.pojo.SsoUserBO;
import com.kirito.cloud.utils.CookieUtils;
import com.kirito.cloud.utils.TokenUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
@Api
@Slf4j
public class UserController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Resource
    private RestTemplate restTemplate;
    @Value("${server-url.nacos-sso-service}")
    private String ssoServerUrl;

    @GetMapping("/current")
    public CommonResult<SsoUserBO> current(){
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

    @PostMapping("/signIn")
    public CommonResult<AuthBO> signIn(@RequestBody LoginUser loginUser){
        String url = ssoServerUrl + "/user/auth";
        HttpEntity<LoginUser> entity = new HttpEntity<>(loginUser);
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
                CookieUtils.set(response,"my_token",token,loginUser.getRemember());
            }catch (Exception e){
                log.warn("user login set cookie failed");
            }
            log.info("user login success!!");
            return CommonResult.success(result);
        }else{
            return CommonResult.failed(commonResult.getMsg());
        }
    }

    @PostMapping("/signUp")
    public CommonResult<Integer> signUp(@RequestBody RegisterUser registerUser){
        String url = ssoServerUrl + "/user/register";
        HttpEntity<RegisterUser> httpEntity = new HttpEntity<>(registerUser);
        ParameterizedTypeReference<CommonResult<Integer>> typeReference = new ParameterizedTypeReference<CommonResult<Integer>>() {};
        ResponseEntity<CommonResult<Integer>> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, typeReference);
        return responseEntity.getBody();
    }
}
