package com.fuhuadata.manager.impl;

import com.fuhuadata.dao.UserDao;
import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.manager.UserManager;

/**
 * Created by zhangxiang on 2017/2/8.
 */
public class UserManagerImpl implements UserManager {
    private UserDao userDao;
    @Override
    public UserAccount getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }
}
