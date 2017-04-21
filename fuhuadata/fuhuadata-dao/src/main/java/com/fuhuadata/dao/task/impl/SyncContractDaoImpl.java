package com.fuhuadata.dao.task.impl;

import com.fuhuadata.dao.task.SyncContractDao;
import com.fuhuadata.domain.task.SyncContract;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hexingfu on 2017/4/20.
 */
@Repository
public class SyncContractDaoImpl implements SyncContractDao {
    @Autowired
    private SqlMapClient sqlMapClientOracle;
    @Autowired
    private SqlMapClient sqlMapClient;
    @Override
    public List<SyncContract> getOracleData()throws Exception{
        return sqlMapClientOracle.queryForList("SyncContract.getOracleData");
    }

    @Override
    public void deleteMysqlData()throws Exception {
        sqlMapClient.delete("SyncContract.deleteMysqlData");
    }

    @Override
    public void insertMysqlData(List<SyncContract> list)throws Exception {
        sqlMapClient.insert("SyncContract.insertMysqlData",list);
    }
}
