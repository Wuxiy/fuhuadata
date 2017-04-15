package com.fuhuadata.dao.mapper;

import com.fuhuadata.domain.mybatis.AreaCode;

import java.util.List;

public interface AreaCodeMapper extends BaseMapper<AreaCode, String> {

    List<AreaCode> listCodesByUserId(Integer userId);
}