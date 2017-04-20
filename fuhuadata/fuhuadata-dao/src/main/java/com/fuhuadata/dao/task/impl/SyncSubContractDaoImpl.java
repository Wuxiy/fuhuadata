package com.fuhuadata.dao.task.impl;

import com.fuhuadata.dao.task.SyncContractDao;
import com.fuhuadata.dao.task.SyncSubContractDao;
import com.fuhuadata.domain.task.SyncContract;
import com.fuhuadata.domain.task.SyncSubContract;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hexingfu on 2017/4/20.
 */
@Repository
public class SyncSubContractDaoImpl implements SyncSubContractDao {
    @Autowired
    private SqlMapClient sqlMapClientOracle;
    @Autowired
    private SqlMapClient sqlMapClient;
    @Override
    public List<SyncSubContract> getOracleData()throws Exception{
        return sqlMapClientOracle.queryForList("SyncSubContract.getOracleData");
    }

    @Override
    public void deleteMysqlData()throws Exception {
        sqlMapClient.delete("SyncSubContract.deleteMysqlData");
    }

    @Override
    public void insertMysqlData(List<SyncSubContract> list)throws Exception {
        sqlMapClient.insert("SyncSubContract.insertMysqlData",list);
    }
}
