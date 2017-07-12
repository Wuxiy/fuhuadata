package com.fuhuadata.dao.mapper;

import com.fuhuadata.domain.mybatis.AreaCl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaClMapper extends BaseMapper<AreaCl, String> {

    List<AreaCl> listAreasByUserCode(@Param("userCode") String userCode);

    List<AreaCl> listForeignAreas();
}