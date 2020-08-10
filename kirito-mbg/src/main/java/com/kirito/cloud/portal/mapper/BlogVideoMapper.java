package com.kirito.cloud.portal.mapper;

import com.kirito.cloud.portal.model.BlogVideo;
import com.kirito.cloud.portal.model.BlogVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BlogVideoMapper {
    long countByExample(BlogVideoExample example);

    int deleteByExample(BlogVideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogVideo record);

    int insertSelective(BlogVideo record);

    List<BlogVideo> selectByExampleWithBLOBsWithRowbounds(BlogVideoExample example, RowBounds rowBounds);

    List<BlogVideo> selectByExampleWithBLOBs(BlogVideoExample example);

    List<BlogVideo> selectByExampleWithRowbounds(BlogVideoExample example, RowBounds rowBounds);

    List<BlogVideo> selectByExample(BlogVideoExample example);

    BlogVideo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogVideo record, @Param("example") BlogVideoExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogVideo record, @Param("example") BlogVideoExample example);

    int updateByExample(@Param("record") BlogVideo record, @Param("example") BlogVideoExample example);

    int updateByPrimaryKeySelective(BlogVideo record);

    int updateByPrimaryKeyWithBLOBs(BlogVideo record);

    int updateByPrimaryKey(BlogVideo record);
}