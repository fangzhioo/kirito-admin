package com.kirito.cloud.sso.pojo.query;

import com.kirito.cloud.pojo.bo.PaginationBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SsoUserQuery extends PaginationBO {
    private String keyword;
}
