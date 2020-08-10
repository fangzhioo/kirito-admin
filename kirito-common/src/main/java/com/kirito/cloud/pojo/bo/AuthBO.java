package com.kirito.cloud.pojo.bo;

import com.kirito.cloud.sso.pojo.bo.SsoUserBO;
import lombok.Data;

@Data
public class AuthBO {
    private SsoUserBO user;
    private String token;
}
