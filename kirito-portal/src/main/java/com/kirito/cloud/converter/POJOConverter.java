package com.kirito.cloud.converter;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.kirito.cloud.portal.model.BlogArticle;
import com.kirito.cloud.portal.model.BlogVideo;
import com.kirito.cloud.portal.pojo.vo.ArticleVO;
import com.kirito.cloud.portal.pojo.vo.VideoVO;

import java.util.ArrayList;
import java.util.List;

public class POJOConverter {

    public static List<ArticleVO> doListToVoList(List<BlogArticle> list){
        List<ArticleVO> voList = new ArrayList<>();
        if(list == null){
            return voList;
        }
        for (BlogArticle article : list){
            voList.add(doToVO(article,true));
        }
        return voList;
    }
    public static ArticleVO doToVO(BlogArticle bo){
        return doToVO(bo,false);
    }
    public static ArticleVO doToVO(BlogArticle bo, boolean ignoreBigText){
        ArticleVO vo = ArticleVO.builder()
                .articleId(bo.getId())
                .title(bo.getTitle())
                .subtitle(bo.getSubtitle())
                .authorAvatar(bo.getAuthorAvatar())
                .authorId(bo.getAuthorId())
                .authorNickname(bo.getAuthorNickname())
                .cid(bo.getCid())
//                .content(bo.getContent())
                .thumb(bo.getThumb())
                .gmtCreate(DateUtil.formatDateTime(bo.getGmtCreate()))
                .gmtModified(DateUtil.formatDateTime(bo.getGmtModified()))
                .views(bo.getViews())
                .build();
        if(ignoreBigText){
            String sub = StrUtil.sub(bo.getContent(), 0, 120);
            vo.setContent(sub);
            return vo;
        }
        vo.setContent(bo.getContent());
        return vo;
    }
    public static BlogArticle voToBO(ArticleVO articleVO){
        BlogArticle blogArticle = new BlogArticle();
        blogArticle.setTitle(articleVO.getTitle());
        blogArticle.setCid(articleVO.getCid());
        blogArticle.setContent(articleVO.getContent());
        blogArticle.setThumb(articleVO.getThumb());
        return blogArticle;
    }

    /**
     * video
     */

    public static VideoVO doToVO(BlogVideo blogVideo){
        return VideoVO.builder()
                .videoId(blogVideo.getId())
                .authorAvatar(blogVideo.getAuthorAvatar())
                .authorId(blogVideo.getAuthorId())
                .authorNickname(blogVideo.getAuthorNickname())
                .cid(blogVideo.getCid())
                .content(blogVideo.getContent())
                .thumb(blogVideo.getThumb())
                .desc(blogVideo.getSubtitle())
                .gmtCreate(DateUtil.formatDateTime(blogVideo.getGmtCreate()))
                .gmtModified(DateUtil.formatDateTime(blogVideo.getGmtModified()))
                .likes(blogVideo.getLikes())
                .status(blogVideo.getStatus())
                .title(blogVideo.getTitle())
                .views(blogVideo.getViews())
                .build();
    }

    public static BlogVideo voToDO(VideoVO videoVO){
        BlogVideo blogVideo = new BlogVideo();
        blogVideo.setTitle(videoVO.getTitle());
        blogVideo.setContent(videoVO.getContent());
        blogVideo.setSubtitle(videoVO.getDesc());
        blogVideo.setCid(videoVO.getCid());
        blogVideo.setThumb(videoVO.getThumb());
        blogVideo.setStatus(videoVO.getStatus());
        return blogVideo;
    }
}
