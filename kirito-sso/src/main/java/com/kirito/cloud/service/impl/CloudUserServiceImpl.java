package com.kirito.cloud.service.impl;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.common.Preconditions;
import com.kirito.cloud.converter.POJOConverter;
import com.kirito.cloud.sso.pojo.bo.LoginUserBO;
import com.kirito.cloud.sso.pojo.bo.RegisterUserBO;
import com.kirito.cloud.service.CloudUserService;
import com.kirito.cloud.sso.mapper.CloudUserMapper;
import com.kirito.cloud.sso.model.CloudUser;
import com.kirito.cloud.sso.model.CloudUserExample;
import com.kirito.cloud.sso.pojo.bo.SsoUserBO;
import com.kirito.cloud.utils.AvatarUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CloudUserServiceImpl implements CloudUserService {
    @Resource
    private CloudUserMapper cloudUserMapper;

    @Override
    public CommonResult<SsoUserBO> login(LoginUserBO loginUserBO) {
        Preconditions.checkNotNull(loginUserBO.getEmail(),"账户不能为空");
        Preconditions.checkNotNull(loginUserBO.getPassword(),"密码不能为空");
        CloudUserExample example = new CloudUserExample();
        CloudUserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(loginUserBO.getEmail());
        criteria.andPasswordEqualTo(loginUserBO.getPassword());
        List<CloudUser> cloudUsers = cloudUserMapper.selectByExampleWithBLOBs(example);
        Preconditions.checkState(cloudUsers.size() != 0,"找不到用户，请检查账户");
        SsoUserBO userBO = POJOConverter.doToBO(cloudUsers.get(0));
        return CommonResult.success(userBO);
    }

    @Override
    public CommonResult<Integer> register(RegisterUserBO registerUserBO) {
        Preconditions.checkNotNull(registerUserBO.getEmail(),"账户不能为空");
        Preconditions.checkNotNull(registerUserBO.getPassword(),"密码不能为空");
        Preconditions.checkState(registerUserBO.getPassword().equals(registerUserBO.getConfirmPassword()),"两次密码不一致");
        CloudUserExample example = new CloudUserExample();
        CloudUserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(registerUserBO.getEmail());
        List<CloudUser> users = cloudUserMapper.selectByExample(example);
        Preconditions.checkState(users.size() == 0,"账户："+ registerUserBO.getEmail() + "已经被注册！");
        CloudUser user = new CloudUser();
        user.setEmail(registerUserBO.getEmail());
        user.setUsername(registerUserBO.getEmail());
        user.setNickname(registerUserBO.getNickName());
        user.setPassword(registerUserBO.getPassword());
        try{
            user.setAvatar(AvatarUtil.createBase64Avatar(registerUserBO.getEmail().hashCode()));
        }catch (Exception ignored){}
        int i = cloudUserMapper.insertSelective(user);
        Preconditions.checkState(i>0,"注册失败！请稍后重试！");
        return CommonResult.success(i);
    }

    @Override
    public CommonResult<SsoUserBO> getUserById(Integer id) {
        CloudUser cloudUser = cloudUserMapper.selectByPrimaryKey(id);
        Preconditions.checkNotNull(cloudUser,"找不到指定的用户！");
        SsoUserBO userBO = POJOConverter.doToBO(cloudUser);
        return CommonResult.success(userBO);
    }
}
