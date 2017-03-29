package com.fuhuadata.dao.mapper;

import com.fuhuadata.dao.annotation.MybatisDao;
import com.fuhuadata.domain.mybatis.Menu;
import org.apache.ibatis.annotations.Param;

/**
 * <p>User: wangjie
 * <p>Date: 3/22/2017
 */
@MybatisDao
public interface MenuMapper extends BaseMapper<Menu,Integer> {

    void deleteSelfAndChildren(@Param("parentId") Integer parentId, @Param("parents") String parents);

    int countNextIndex(@Param("parentId") Integer parentId);

    Menu getMenu(@Param("id") Integer id);
}