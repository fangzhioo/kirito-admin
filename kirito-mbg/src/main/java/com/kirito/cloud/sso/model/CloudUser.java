package com.kirito.cloud.sso.model;

import java.io.Serializable;
import java.util.Date;

public class CloudUser implements Serializable {
    /**
     * id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 用户名
     *
     * @mbg.generated
     */
    private String username;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String password;

    /**
     * 昵称
     *
     * @mbg.generated
     */
    private String nickname;

    /**
     * 签名
     *
     * @mbg.generated
     */
    private String signature;

    /**
     * 邮箱
     *
     * @mbg.generated
     */
    private String email;

    /**
     * 手机号
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * 注册时间
     *
     * @mbg.generated
     */
    private Date createdTime;

    /**
     * 修改时间
     *
     * @mbg.generated
     */
    private Date modifyTime;

    /**
     * 头像
     *
     * @mbg.generated
     */
    private String avatar;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", signature=").append(signature);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", avatar=").append(avatar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}