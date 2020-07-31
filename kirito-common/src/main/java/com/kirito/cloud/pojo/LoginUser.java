package com.kirito.cloud.pojo;

import lombok.Data;

@Data
public class LoginUser {
    private String email;
    private String password;
    private Boolean remember = false;
}
