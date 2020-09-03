package com.kirito.cloud.mapper;

import com.kirito.cloud.model.PdmanDbVersion;
import com.kirito.cloud.model.PdmanDbVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PdmanDbVersionMapper {
    long countByExample(PdmanDbVersionExample example);

    int deleteByExample(PdmanDbVersionExample example);

    int insert(PdmanDbVersion record);

    int insertSelective(PdmanDbVersion record);

    List<PdmanDbVersion> selectByExample(PdmanDbVersionExample example);

    int updateByExampleSelective(@Param("record") PdmanDbVersion record, @Param("example") PdmanDbVersionExample example);

    int updateByExample(@Param("record") PdmanDbVersion record, @Param("example") PdmanDbVersionExample example);
}