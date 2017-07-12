package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.MenuMapper;
import com.fuhuadata.domain.mybatis.Button;
import com.fuhuadata.domain.mybatis.Menu;
import com.fuhuadata.domain.mybatis.RoleAuthority;
import com.fuhuadata.domain.plugin.MenuTrees;
import com.fuhuadata.service.mybatis.MenuService;
import com.fuhuadata.service.mybatis.RoleService;
import com.fuhuadata.service.mybatis.UserRoleService;
import com.fuhuadata.vo.MenuTreeVo;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
@Service
public class MenuServiceImpl extends BaseTreeableServiceImpl<Menu, Integer>
        implements MenuService {

    private RoleService roleService;

    private UserRoleService userRoleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

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
    public List<Integer> listAuthorityMenuIds(Integer roleId) {
        return getMenuMapper().listAuthorityMenuIds(roleId);
    }

    @Override
    public List<Menu> listMenuPermissions(Integer roleId) {
        return getMenuMapper().listPermissionMenus(roleId);
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

    @Override
    public void addMenusToMenuTree(Map<Integer, MenuTreeVo> lookup, List<Menu> addMenus) {
        new MenuTrees(addMenus, lookup).convertToTreeList();
    }

    @Override
    public String findActualResourceIdentity(MenuTreeVo menuNode, Map<Integer, MenuTreeVo> trees) {

        if (menuNode == null) {
            return null;
        }

        StringBuilder s = new StringBuilder(menuNode.getIdentity());

        boolean hasResourceIdentity = !StringUtils.isNotBlank(menuNode.getIdentity());

        MenuTreeVo parent = trees.get(menuNode.getPid());
        while (parent != null) {
            if (StringUtils.isNotBlank(parent.getIdentity())) {
                s.insert(0, parent.getIdentity() + ":");
                hasResourceIdentity = true;
            }
            parent = parent.isRoot() ? null : trees.get(parent.getPid());
        }

        // 如果用户没有声明 资源标识 且父也没有，则返回空
        if (!hasResourceIdentity) {
            return "";
        }

        //如果最后一个字符是: 因为不需要，所以删除之
        int length = s.length();
        if (length > 0 && s.lastIndexOf(":") == length - 1) {
            s.deleteCharAt(length - 1);
        }

        return s.toString();
    }

    @Override
    public Set<String> getStringPermissions(String userCode) {
        Set<String> permissions = Sets.newHashSet();
        Map<Integer, MenuTreeVo> tree = Maps.newHashMap();

        Set<Integer> roleIds = userRoleService.getRoleIds(userCode);
        for (Integer roleId : roleIds) {
            List<Menu> menus = listMenuPermissions(roleId);
            addMenusToMenuTree(tree, menus);
        }

        for (Map.Entry<Integer, MenuTreeVo> entry : tree.entrySet()) {
            MenuTreeVo menuNode = entry.getValue();
            String permission = findActualResourceIdentity(menuNode, tree);

            if (StringUtils.isBlank(permission)) {
                continue;
            }

            // 功能按钮集合
            Set<Integer> permissionIds = menuNode.getRoleAuthority().getPermissionIdsSet();
            for (Button button : menuNode.getButtons()) {
                if (permissionIds != null && permissionIds.contains(button.getId())) {
                    permissions.add(permission + ":" + button.getPermission());
                }
            }
        }

        return permissions;
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
