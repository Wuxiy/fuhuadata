package com.fuhuadata.dao.task.impl;

import com.fuhuadata.dao.task.SyncProductDao;
import com.fuhuadata.domain.task.SyncProduct;
import com.fuhuadata.domain.task.SyncWare;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hexingfu on 2017/5/16.
 */
@Repository
public class SyncProductDaoImpl implements SyncProductDao {
    @Autowired
    private SqlMapClient sqlMapClientOracle;
    @Autowired
    private SqlMapClient sqlMapClient;
    @Override
    public List<SyncProduct> getProductListFormOracle()throws Exception {
            return sqlMapClientOracle.queryForList("SyncProduct.getProductListFormOracle");
    }

    @Override
    public void modifyProductInMysql(List<SyncProduct> plist)throws Exception {
            sqlMapClient.insert("SyncProduct.updateProductInMysql",plist);
    }

    @Override
    public List<SyncWare> getWareListFormOracle()throws Exception {
            return sqlMapClientOracle.queryForList("SyncProduct.getWareListFormOracle");
    }

    @Override
    public void modifyWareInMysql(List<SyncWare> plist)throws Exception {
        sqlMapClient.insert("SyncProduct.updateWareInMysql",plist);
    }

    @Override
    public void fixProductInMysql() throws Exception{
            sqlMapClient.update("SyncProduct.fixProductInMysql");
    }

    @Override
    public void fixWareInMysql()throws Exception {
            sqlMapClient.update("SyncProduct.fixWareInMysql");
    }
}
