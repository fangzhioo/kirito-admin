package com.kirito.cloud.service;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.portal.pojo.query.ArticleQuery;
import com.kirito.cloud.portal.pojo.vo.ArticleVO;

import java.util.List;

public interface ArticleService {

    List<ArticleVO> getRecommendArticles(ArticleQuery articleQuery);

    Integer createArticle(ArticleVO articleVO);

    Integer removeArticleById(Integer articleId);

    Integer updateArticle(ArticleVO articleVO);

    List<ArticleVO> getArticleList(ArticleQuery articleQuery);

    ArticleVO getArticle(Integer articleId);
}
