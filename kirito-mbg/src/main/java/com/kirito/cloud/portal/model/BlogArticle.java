package com.kirito.cloud.portal.model;

import java.io.Serializable;
import java.util.Date;

public class BlogArticle implements Serializable {
    /**
     * id
     *
     * @mbg.generated
     */
    private Integer id;

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
     * 查看次数
     *
     * @mbg.generated
     */
    private Integer views;

    /**
     * 状态 - 2草稿|1发布|0删除
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     * 修改时间
     *
     * @mbg.generated
     */
    private Date gmtModified;

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

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", subtitle=").append(subtitle);
        sb.append(", thumb=").append(thumb);
        sb.append(", cid=").append(cid);
        sb.append(", authorId=").append(authorId);
        sb.append(", authorNickname=").append(authorNickname);
        sb.append(", views=").append(views);
        sb.append(", status=").append(status);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", content=").append(content);
        sb.append(", authorAvatar=").append(authorAvatar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}