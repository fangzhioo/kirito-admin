package com.kirito.cloud.sso.pojo.bo;

import lombok.Data;

@Data
public class LoginUserBO {
    private String email;
    private String password;
    private Boolean remember = false;
}
