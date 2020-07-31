package com.kirito.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUser {
    private String email;
    private String nickName;
    private String password;
    private String confirmPassword;
}
