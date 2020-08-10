package com.kirito.cloud.portal.mapper;

import com.kirito.cloud.portal.model.BlogArticleTagRelationship;
import com.kirito.cloud.portal.model.BlogArticleTagRelationshipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BlogArticleTagRelationshipMapper {
    long countByExample(BlogArticleTagRelationshipExample example);

    int deleteByExample(BlogArticleTagRelationshipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogArticleTagRelationship record);

    int insertSelective(BlogArticleTagRelationship record);

    List<BlogArticleTagRelationship> selectByExampleWithRowbounds(BlogArticleTagRelationshipExample example, RowBounds rowBounds);

    List<BlogArticleTagRelationship> selectByExample(BlogArticleTagRelationshipExample example);

    BlogArticleTagRelationship selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogArticleTagRelationship record, @Param("example") BlogArticleTagRelationshipExample example);

    int updateByExample(@Param("record") BlogArticleTagRelationship record, @Param("example") BlogArticleTagRelationshipExample example);

    int updateByPrimaryKeySelective(BlogArticleTagRelationship record);

    int updateByPrimaryKey(BlogArticleTagRelationship record);
}