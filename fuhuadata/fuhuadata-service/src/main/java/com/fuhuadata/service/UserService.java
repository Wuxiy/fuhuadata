package com.fuhuadata.service;

import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.Result;

/**
 * Created by zhangxiang on 2017/2/8.
 */
public interface UserService {
    public Result<UserAccount> getUserByAccount(String account);
}
