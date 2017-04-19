package com.fuhuadata.dao.mapper;

import com.fuhuadata.domain.mybatis.RoleAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleAuthorityMapper extends BaseMapper<RoleAuthority, Integer> {

    /**
     * 删除角色所拥有的菜单，排除需要保留的菜单
     * @param roleId
     * @param retainMenuIds
     * @return
     */
    int deleteMenusByRoleId(@Param("roleId") Integer roleId, @Param("menuIds") List<Integer> retainMenuIds);
}