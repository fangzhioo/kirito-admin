package com.kirito.cloud.sso.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SsoUserBO {
    /**
     * id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 签名
     */
    private String signature;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 注册时间
     *
     * @mbg.generated
     */
    private String createdTime;

    /**
     * 修改时间
     */
    private String modifyTime;
}
