package com.kirito.cloud.converter;

import cn.hutool.core.date.DateUtil;
import com.kirito.cloud.sso.model.CloudUser;
import com.kirito.cloud.sso.pojo.SsoUserBO;

public class POJOConverter {

    public static SsoUserBO doToBO(CloudUser user){
        return SsoUserBO.builder()
                .email(user.getEmail())
                .userId(user.getId())
                .userName(user.getUsername())
                .nickName(user.getNickname())
                .avatar(user.getAvatar())
                .signature(user.getSignature())
                .createdTime(DateUtil.formatDateTime(user.getCreatedTime()))
                .modifyTime(DateUtil.formatDateTime(user.getModifyTime()))
                .build();
    }
}
