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
public class VideoVO {
    private Integer videoId;

    private String title;

    private String thumb;

    private String desc;

    private String content;

    private Integer cid;

    private Integer views;

    private Integer likes;

    private Integer authorId;

    private String authorNickname;

    private Integer status;

    private String gmtCreate;

    private String gmtModified;

    private String authorAvatar;
}
