package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.MenuMapper;
import com.fuhuadata.domain.mybatis.Menu;
import com.fuhuadata.service.mybatis.MenuService;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
@Service
public class MenuServiceImpl extends BaseTreeableServiceImpl<Menu, Integer>
        implements MenuService {

    @Override
    public Menu getRoot() {
        Menu menu = new Menu();
        menu.setMenuId(0);
        menu.setParentIds("");
        menu.setName("全部");
        return menu;
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
        ((MenuMapper) baseMapper).deleteSelfAndChildren(self.getId(), self.makeSelfAsNewParentIds());
    }

    private MenuMapper getMenuMapper() {
        return (MenuMapper) baseMapper;
    }
}
