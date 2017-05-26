package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.UserDao;
import com.fuhuadata.domain.UserAccount;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * Created by zhangxiang on 2017/2/8.
 */
public class UserDaoImpl extends SqlMapClientTemplate implements UserDao {

    @Override
    public UserAccount getUserByAccount(String account) {
        return null;
    }
}
