package com.kirito.cloud.service.impl;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.common.Preconditions;
import com.kirito.cloud.converter.POJOConverter;
import com.kirito.cloud.portal.mapper.BlogArticleMapper;
import com.kirito.cloud.portal.model.BlogArticle;
import com.kirito.cloud.portal.model.BlogArticleExample;
import com.kirito.cloud.portal.pojo.query.ArticleQuery;
import com.kirito.cloud.portal.pojo.vo.ArticleVO;
import com.kirito.cloud.service.ArticleService;
import com.kirito.cloud.service.UserService;
import com.kirito.cloud.sso.pojo.bo.SsoUserBO;
import com.mysql.cj.util.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private BlogArticleMapper blogArticleMapper;
    @Resource
    private UserService userService;

    @Override
    public List<ArticleVO> getRecommendArticles(ArticleQuery articleQuery) {
        RowBounds bounds = new RowBounds(articleQuery.getOffset(),articleQuery.getLimit());
        BlogArticleExample example = new BlogArticleExample();
        BlogArticleExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        if(!StringUtils.isNullOrEmpty(articleQuery.getKeyword())){
            criteria.andTitleLike(articleQuery.getKeyword());
        };
        example.setOrderByClause("views desc");
        List<BlogArticle> list = blogArticleMapper.selectByExampleWithBLOBsWithRowbounds(example, bounds);
        return POJOConverter.doListToVoList(list);
    }

    @Override
    public Integer createArticle(ArticleVO articleVO) {
        BlogArticle bo = POJOConverter.voToBO(articleVO);
        CommonResult<SsoUserBO> current = userService.current();
        Preconditions.checkNotNull(current,"请先登陆");
        Preconditions.checkState(CommonResult.checkStatus(current.getCode()),current.getMsg());
        bo.setAuthorAvatar(current.getData().getAvatar());
        bo.setAuthorId(current.getData().getUserId());
        bo.setAuthorNickname(current.getData().getNickName());
        return blogArticleMapper.insertSelective(bo);
    }

    @Override
    public Integer removeArticleById(Integer articleId) {
        CommonResult<SsoUserBO> current = userService.current();
        Preconditions.checkNotNull(current,"请先登陆");
        Preconditions.checkState(CommonResult.checkStatus(current.getCode()),current.getMsg());
        BlogArticle blogArticle = blogArticleMapper.selectByPrimaryKey(articleId);
        Preconditions.checkNotNull(blogArticle,"找不到指定的文章");
        Preconditions.checkState(blogArticle.getStatus() == 1,"该文章已被删除或已取消发布！");
        Preconditions.checkState(blogArticle.getAuthorId().equals(current.getData().getUserId()),"无权限删除！");
        BlogArticle article = new BlogArticle();
        article.setId(articleId);
        article.setStatus(0);
        return blogArticleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public Integer updateArticle(ArticleVO articleVO) {
        Preconditions.checkNotNull(articleVO.getArticleId(),"缺少文章Id");
        CommonResult<SsoUserBO> current = userService.current();
        Preconditions.checkNotNull(current,"请先登陆");
        Preconditions.checkState(CommonResult.checkStatus(current.getCode()),current.getMsg());
        BlogArticle blogArticle = blogArticleMapper.selectByPrimaryKey(articleVO.getArticleId());
        Preconditions.checkNotNull(blogArticle,"找不到指定的文章");
        Preconditions.checkState(blogArticle.getStatus() == 1,"该文章已被删除或已取消发布！");
        Preconditions.checkState(blogArticle.getAuthorId().equals(current.getData().getUserId()),"无权限更新！");
        BlogArticle bo = POJOConverter.voToBO(articleVO);
        bo.setId(articleVO.getArticleId());
        return blogArticleMapper.updateByPrimaryKeySelective(bo);
    }

    @Override
    public List<ArticleVO> getArticleList(ArticleQuery articleQuery) {
        RowBounds bounds = new RowBounds(articleQuery.getOffset(),articleQuery.getLimit());
        BlogArticleExample example = new BlogArticleExample();
        BlogArticleExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        if(!StringUtils.isNullOrEmpty(articleQuery.getKeyword())){
            criteria.andTitleLike(articleQuery.getKeyword());
        };
        example.setOrderByClause("gmt_modified desc");
        List<BlogArticle> list = blogArticleMapper.selectByExampleWithBLOBsWithRowbounds(example, bounds);
        return POJOConverter.doListToVoList(list);
    }

    @Override
    public ArticleVO getArticle(Integer articleId) {
        BlogArticle blogArticle = blogArticleMapper.selectByPrimaryKey(articleId);
        Preconditions.checkNotNull(blogArticle,"找不到指定的文章");
        Preconditions.checkState(blogArticle.getStatus() == 1,"该文章已被删除或已取消发布！");
        try{
            // 获取则更新阅读数
            BlogArticle article = new BlogArticle();
            article.setId(articleId);
            article.setViews(blogArticle.getViews() + 1);
            blogArticleMapper.updateByPrimaryKeySelective(article);
        }catch (Exception ignored){}
        return POJOConverter.doToVO(blogArticle);
    }

}
