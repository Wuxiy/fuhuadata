package com.fuhuadata.dao;

import com.fuhuadata.domain.UserAccount;

/**
 * Created by wuxiy on 2017/5/23.
 */
public interface UserDao {
    public UserAccount getUserByAccount(String account);
}
