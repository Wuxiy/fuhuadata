package com.fuhuadata.dao.mapper;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import java.io.Serializable;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
public interface BaseMapper<T, ID extends Serializable> extends tk.mybatis.mapper.common.BaseMapper<T>,
        ExampleMapper<T>,
        RowBoundsMapper<T>,
        InsertListMapper<T> {
}
