package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.mapper.MenuMapper;
import com.fuhuadata.manager.MenuManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>User: wangjie
 * <p>Date: 3/22/2017
 */
public class MenuManagerImpl implements MenuManager {

    @Autowired
    MenuMapper menuMapper;
}
