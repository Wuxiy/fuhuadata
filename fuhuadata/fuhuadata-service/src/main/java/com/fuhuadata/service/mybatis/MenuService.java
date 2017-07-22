package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.Menu;
import com.fuhuadata.vo.MenuTreeVo;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * 获取角色授权的菜单集合 id
     * @param roleId
     * @return
     */
    List<Integer> listAuthorityMenuIds(Integer roleId);

    /**
     * 获取角色关联菜单以及权限
     * @param roleId
     * @return
     */
    List<Menu> listMenuPermissions(Integer roleId);

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

    /**
     * 给现有树添加节点
     * @param lookup 现有树的 Map
     * @param addMenus
     */
    void addMenusToMenuTree(Map<Integer, MenuTreeVo> lookup, List<Menu> addMenus);

    /**
     * 获取资源的权限字符串，如 sys/role/view
     * @param menuNode
     * @param trees
     * @return
     */
    String findActualResourceIdentity(MenuTreeVo menuNode, Map<Integer, MenuTreeVo> trees);

    Set<String> getStringPermissions(String userCode);

}
