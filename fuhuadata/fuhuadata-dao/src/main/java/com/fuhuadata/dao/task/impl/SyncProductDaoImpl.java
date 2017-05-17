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
    public List<SyncProduct> getProductListFormOracle() {
        try {
            return sqlMapClientOracle.queryForList("SyncProduct.getProductListFormOracle");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateProductInMysql(List<SyncProduct> plist) {
        try {
            sqlMapClient.insert("SyncProduct.updateProductInMysql",plist);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SyncWare> getWareListFormOracle() {
        try {
            return sqlMapClientOracle.queryForList("SyncProduct.getWareListFormOracle");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateWareInMysql(List<SyncWare> plist) {
        try {
            sqlMapClient.insert("SyncProduct.updateWareInMysql",plist);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fixProductInMysql() {
        try {
            sqlMapClient.update("SyncProduct.fixProductInMysql");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fixWareInMysql() {
        try {
            sqlMapClient.update("SyncProduct.fixWareInMysql");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
