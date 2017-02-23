package com.fuhuadata.dao;

import com.fuhuadata.domain.UserAccount;

/**
 * Created by zhangxiang on 2017/2/8.
 */
public interface UserDao {
    public UserAccount getUserByAccount(String account);
}
