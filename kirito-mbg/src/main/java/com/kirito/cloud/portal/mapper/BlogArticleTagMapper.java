package com.kirito.cloud.portal.mapper;

import com.kirito.cloud.portal.model.BlogArticleTag;
import com.kirito.cloud.portal.model.BlogArticleTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BlogArticleTagMapper {
    long countByExample(BlogArticleTagExample example);

    int deleteByExample(BlogArticleTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogArticleTag record);

    int insertSelective(BlogArticleTag record);

    List<BlogArticleTag> selectByExampleWithRowbounds(BlogArticleTagExample example, RowBounds rowBounds);

    List<BlogArticleTag> selectByExample(BlogArticleTagExample example);

    BlogArticleTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogArticleTag record, @Param("example") BlogArticleTagExample example);

    int updateByExample(@Param("record") BlogArticleTag record, @Param("example") BlogArticleTagExample example);

    int updateByPrimaryKeySelective(BlogArticleTag record);

    int updateByPrimaryKey(BlogArticleTag record);
}