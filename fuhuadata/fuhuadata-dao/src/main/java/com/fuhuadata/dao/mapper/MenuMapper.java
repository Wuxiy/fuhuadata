package com.fuhuadata.dao.mapper;

import com.fuhuadata.dao.annotation.MybatisDao;
import com.fuhuadata.domain.mybatis.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/22/2017
 */
@MybatisDao
public interface MenuMapper extends BaseMapper<Menu, Integer> {

    void deleteSelfAndChildren(@Param("menuId") Integer menuId, @Param("parents") String parents);

    int countNextIndex(@Param("parentId") Integer parentId);

    Menu getMenu(@Param("id") Integer id);

    int updateChildrenParentIds(@Param("newParentIds") String newParentIds,
                                @Param("oldParentIds") String oldParentIds);

    /**
     * 获取自己和自己后面的兄弟
     *
     * @param parentId
     * @param weight
     * @return
     */
    List<Menu> listSelfAndNextSiblings(@Param("parentId") Integer parentId, @Param("weight") int weight);

    /**
     * 获取角色授权的菜单
     * @param roleId
     * @return
     */
    List<Menu> listAuthorityMenus(@Param("roleId") Integer roleId);

    /**
     * 获取角色授权菜单ids
     * @param roleId
     * @return
     */
    List<Integer> listAuthorityMenuIds(@Param("roleId") Integer roleId);

    /**
     * 获取角色授权的菜单和按钮权限
     * @param roleId
     * @return
     */
    List<Menu> listPermissionMenus(@Param("roleId") Integer roleId);

}