package com.kirito.cloud.portal.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleVO {
    /**
     * id
     *
     * @mbg.generated
     */
    private Integer articleId;

    /**
     * 标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 副标题
     *
     * @mbg.generated
     */
    private String subtitle;

    /**
     * 封面
     *
     * @mbg.generated
     */
    private String thumb;

    /**
     * 类目 默认999
     *
     * @mbg.generated
     */
    private Integer cid;

    /**
     * 作者
     *
     * @mbg.generated
     */
    private Integer authorId;

    /**
     * 作者昵称
     *
     * @mbg.generated
     */
    private String authorNickname;

    /**
     * 阅读数
     *
     * @mbg.generated
     */
    private Integer views;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private String gmtCreate;

    /**
     * 修改时间
     *
     * @mbg.generated
     */
    private String gmtModified;

    /**
     * 内容
     *
     * @mbg.generated
     */
    private String content;

    /**
     * 作者头像
     *
     * @mbg.generated
     */
    private String authorAvatar;

}
