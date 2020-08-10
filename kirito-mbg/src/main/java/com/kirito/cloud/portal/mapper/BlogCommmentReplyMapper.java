package com.kirito.cloud.portal.mapper;

import com.kirito.cloud.portal.model.BlogCommmentReply;
import com.kirito.cloud.portal.model.BlogCommmentReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BlogCommmentReplyMapper {
    long countByExample(BlogCommmentReplyExample example);

    int deleteByExample(BlogCommmentReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogCommmentReply record);

    int insertSelective(BlogCommmentReply record);

    List<BlogCommmentReply> selectByExampleWithBLOBsWithRowbounds(BlogCommmentReplyExample example, RowBounds rowBounds);

    List<BlogCommmentReply> selectByExampleWithBLOBs(BlogCommmentReplyExample example);

    List<BlogCommmentReply> selectByExampleWithRowbounds(BlogCommmentReplyExample example, RowBounds rowBounds);

    List<BlogCommmentReply> selectByExample(BlogCommmentReplyExample example);

    BlogCommmentReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogCommmentReply record, @Param("example") BlogCommmentReplyExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogCommmentReply record, @Param("example") BlogCommmentReplyExample example);

    int updateByExample(@Param("record") BlogCommmentReply record, @Param("example") BlogCommmentReplyExample example);

    int updateByPrimaryKeySelective(BlogCommmentReply record);

    int updateByPrimaryKeyWithBLOBs(BlogCommmentReply record);

    int updateByPrimaryKey(BlogCommmentReply record);
}