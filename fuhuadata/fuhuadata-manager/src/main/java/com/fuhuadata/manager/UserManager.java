package com.fuhuadata.manager;

import com.fuhuadata.domain.UserAccount;

/**
 * Created by zhangxiang on 2017/2/8.
 */
public interface UserManager {
    public UserAccount getUserByAccount(String account);
}
