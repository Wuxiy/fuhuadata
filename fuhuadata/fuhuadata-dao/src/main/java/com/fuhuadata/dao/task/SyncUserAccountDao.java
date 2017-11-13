package com.fuhuadata.dao.task;


import com.fuhuadata.domain.mybatis.UserAccount;

import java.util.List;

/**
 * Created by zhangxiang on 2017/11/10.
 */
public interface SyncUserAccountDao {
    List<UserAccount> getUserFromNC() throws Exception;
    void replaceUser(List<UserAccount> list) throws Exception;
}
