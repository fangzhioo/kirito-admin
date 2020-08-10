package com.kirito.cloud.sso.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserBO {
    private String email;
    private String nickName;
    private String password;
    private String confirmPassword;
}
