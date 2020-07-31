package com.kirito.cloud.sso.mapper;

import com.kirito.cloud.sso.model.CloudUser;
import com.kirito.cloud.sso.model.CloudUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CloudUserMapper {
    long countByExample(CloudUserExample example);

    int deleteByExample(CloudUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CloudUser record);

    int insertSelective(CloudUser record);

    List<CloudUser> selectByExampleWithBLOBs(CloudUserExample example);

    List<CloudUser> selectByExample(CloudUserExample example);

    CloudUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CloudUser record, @Param("example") CloudUserExample example);

    int updateByExampleWithBLOBs(@Param("record") CloudUser record, @Param("example") CloudUserExample example);

    int updateByExample(@Param("record") CloudUser record, @Param("example") CloudUserExample example);

    int updateByPrimaryKeySelective(CloudUser record);

    int updateByPrimaryKeyWithBLOBs(CloudUser record);

    int updateByPrimaryKey(CloudUser record);
}