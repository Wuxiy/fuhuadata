package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.MenuMapper;
import com.fuhuadata.domain.mybatis.Button;
import com.fuhuadata.domain.mybatis.Menu;
import com.fuhuadata.domain.mybatis.RoleAuthority;
import com.fuhuadata.domain.plugin.MenuTrees;
import com.fuhuadata.service.mybatis.MenuService;
import com.fuhuadata.vo.MenuTreeVo;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
@Service
public class MenuServiceImpl extends BaseTreeableServiceImpl<Menu, Integer>
        implements MenuService {

    @Override
    public Menu get(Integer id) {
        return getMenuMapper().getMenu(id);
    }

    @Override
    public int countNextIndex(Integer parentId) {
        return getMenuMapper().countNextIndex(parentId);
    }

    @Override
    public void deleteSelfAndChildren(Menu self) {
        getMenuMapper().deleteSelfAndChildren(self.getId(), self.makeSelfAsNewParentIds());
    }

    @Override
    public int updateChildrenParentIds(String newChildrenParentIds, String oldChildrenParentIds) {
        return getMenuMapper().updateChildrenParentIds(newChildrenParentIds, oldChildrenParentIds);
    }

    @Override
    public List<Menu> listSelfAndNextSiblings(Integer parentId, int weight) {
        return getMenuMapper().listSelfAndNextSiblings(parentId, weight);
    }

    @Override
    public List<Menu> listAuthorityMenus(Integer roleId) {
        return getMenuMapper().listAuthorityMenus(roleId);
    }

    @Override
    public List<MenuTreeVo> listAuthMenuTree(Integer roleId) {
        List<Menu> menus = listAuthorityMenus(roleId);
        return getMenuTreeVos(menus);
    }

    @Override
    public List<MenuTreeVo> listPermissionMenuTree(Integer roleId) {
        List<Menu> menus = getMenuMapper().listPermissionMenus(roleId);

        setPermittedFlag(menus);
        return getMenuTreeVos(menus);
    }

    private void setPermittedFlag(List<Menu> menus) {
        for (Menu menu : menus) {
            RoleAuthority roleAuthority = menu.getRoleAuthority();
            if (roleAuthority != null) {

                Set<Integer> permissions = roleAuthority.getPermissionIdsSet();
                if (menu.getButtons() != null && permissions != null) {

                    for (Button button : menu.getButtons()) {
                        button.setPermitted(permissions.contains(button.getId()));
                    }
                }
            }
        }
    }

    private MenuMapper getMenuMapper() {
        return (MenuMapper) baseMapper;
    }

    private List<MenuTreeVo> getMenuTreeVos(List<Menu> menus) {
        menus.add(getRoot());
        HashSet<Integer> parentIds = Sets.newHashSet(getRoot().getId());

        return new MenuTrees(menus, parentIds).convertToTreeList();
    }
}
