package com.kirito.cloud.portal.pojo.query;

import com.kirito.cloud.pojo.bo.PaginationBO;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleQuery extends PaginationBO {
    private String keyword;
}
