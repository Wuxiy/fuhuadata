package com.fuhuadata.dao.task.impl;

import com.fuhuadata.dao.task.SyncUserAccountDao;
import com.fuhuadata.domain.mybatis.UserAccount;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangxiang on 2017/11/10.
 */
@Repository
public class SyncUserAccountDaoImpl implements SyncUserAccountDao {
    @Autowired
    private SqlMapClient sqlMapClientOracle;
    @Autowired
    private SqlMapClient sqlMapClient;
    @Override
    public List<UserAccount> getUserFromNC() throws Exception {
        return sqlMapClientOracle.queryForList("SyncUserAccount.getUserAccount");
    }

    @Override
    public void replaceUser(List<UserAccount> list) throws Exception {
        sqlMapClient.insert("SyncUserAccount.insertUserAccount",list);
    }
}
