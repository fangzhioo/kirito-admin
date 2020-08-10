package com.kirito.cloud.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationBO {
    private Integer offset = 0;
    private Integer limit = 10;
}
