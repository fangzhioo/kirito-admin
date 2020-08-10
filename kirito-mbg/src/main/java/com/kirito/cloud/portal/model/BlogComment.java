package com.kirito.cloud.portal.model;

import java.io.Serializable;
import java.util.Date;

public class BlogComment implements Serializable {
    /**
     * id 评论表
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 文章id
     *
     * @mbg.generated
     */
    private Integer articleId;

    /**
     * 评论人id
     *
     * @mbg.generated
     */
    private Integer authorId;

    /**
     * 评论人昵称
     *
     * @mbg.generated
     */
    private String authorNickname;

    private Date gmtCreate;

    private Date gmtModified;

    /**
     * 评论人头像
     *
     * @mbg.generated
     */
    private String authorAvatar;

    /**
     * 评论内容
     *
     * @mbg.generated
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorNickname() {
        return authorNickname;
    }

    public void setAuthorNickname(String authorNickname) {
        this.authorNickname = authorNickname;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", articleId=").append(articleId);
        sb.append(", authorId=").append(authorId);
        sb.append(", authorNickname=").append(authorNickname);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", authorAvatar=").append(authorAvatar);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}