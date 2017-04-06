package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.Menu;
import com.fuhuadata.vo.MenuTreeVo;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
public interface MenuService extends BaseTreeableService<Menu, Integer> {

    /**
     * 获取角色授权的菜单集合
     * @param roleId
     * @return
     */
    List<Menu> listAuthorityMenus(Integer roleId);

    /**
     * 获取角色授权的菜单树
     *
     * <p>默认存储角色授权菜单时，会将子节点以及子节点的父节点都存入数据库，所以默认情况下
     * 顶级的父节点是 id 默认为 0 的节点</p>
     * @param roleId
     * @return
     */
    List<MenuTreeVo> listAuthMenuTree(Integer roleId);

    /**
     * 获取角色授权的菜单和权限树
     * @param roleId
     * @return
     */
    List<MenuTreeVo> listPermissionMenuTree(Integer roleId);

}
