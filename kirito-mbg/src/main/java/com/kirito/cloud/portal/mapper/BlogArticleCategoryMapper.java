package com.kirito.cloud.portal.mapper;

import com.kirito.cloud.portal.model.BlogArticleCategory;
import com.kirito.cloud.portal.model.BlogArticleCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BlogArticleCategoryMapper {
    long countByExample(BlogArticleCategoryExample example);

    int deleteByExample(BlogArticleCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogArticleCategory record);

    int insertSelective(BlogArticleCategory record);

    List<BlogArticleCategory> selectByExampleWithRowbounds(BlogArticleCategoryExample example, RowBounds rowBounds);

    List<BlogArticleCategory> selectByExample(BlogArticleCategoryExample example);

    BlogArticleCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogArticleCategory record, @Param("example") BlogArticleCategoryExample example);

    int updateByExample(@Param("record") BlogArticleCategory record, @Param("example") BlogArticleCategoryExample example);

    int updateByPrimaryKeySelective(BlogArticleCategory record);

    int updateByPrimaryKey(BlogArticleCategory record);
}