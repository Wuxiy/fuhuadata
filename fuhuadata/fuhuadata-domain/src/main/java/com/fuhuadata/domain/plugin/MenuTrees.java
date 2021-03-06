package com.fuhuadata.domain.plugin;

import com.fuhuadata.domain.mybatis.Menu;
import com.fuhuadata.vo.MenuTreeVo;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 4/3/2017
 */
public class MenuTrees extends Trees<MenuTreeVo, Menu, Integer> {

    public MenuTrees(List<Menu> flatItems, HashSet<Integer> parentIds) {
        super(flatItems, parentIds);
    }

    public MenuTrees(List<Menu> flatItems, Map<Integer, MenuTreeVo> lookup) {
        super(flatItems, lookup);
    }

    @Override
    protected MenuTreeVo convertToTree(Menu node) {

        MenuTreeVo treeNode = new MenuTreeVo();
        treeNode.setCid(node.getId());
        treeNode.setCname(node.getName());
        treeNode.setPid(node.getParentId());
        treeNode.setRoot(node.isRoot());
        treeNode.setIdentity(node.getIdentity());
        treeNode.setRoleAuthority(node.getRoleAuthority());
        treeNode.setButtons(node.getButtons());

        return treeNode;
    }
}
