package com.kirito.cloud.portal.mapper;

import com.kirito.cloud.portal.model.BlogComment;
import com.kirito.cloud.portal.model.BlogCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BlogCommentMapper {
    long countByExample(BlogCommentExample example);

    int deleteByExample(BlogCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogComment record);

    int insertSelective(BlogComment record);

    List<BlogComment> selectByExampleWithBLOBsWithRowbounds(BlogCommentExample example, RowBounds rowBounds);

    List<BlogComment> selectByExampleWithBLOBs(BlogCommentExample example);

    List<BlogComment> selectByExampleWithRowbounds(BlogCommentExample example, RowBounds rowBounds);

    List<BlogComment> selectByExample(BlogCommentExample example);

    BlogComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogComment record, @Param("example") BlogCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogComment record, @Param("example") BlogCommentExample example);

    int updateByExample(@Param("record") BlogComment record, @Param("example") BlogCommentExample example);

    int updateByPrimaryKeySelective(BlogComment record);

    int updateByPrimaryKeyWithBLOBs(BlogComment record);

    int updateByPrimaryKey(BlogComment record);
}