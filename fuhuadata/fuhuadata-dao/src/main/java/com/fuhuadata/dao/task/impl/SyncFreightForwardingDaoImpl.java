package com.fuhuadata.dao.task.impl;

import com.fuhuadata.dao.task.SyncFreightForwardingDao;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.mybatis.supplier.FreightForwarding;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhangxiang on 2017/6/9.
 */
public class SyncFreightForwardingDaoImpl implements SyncFreightForwardingDao {
    @Autowired
    private SqlMapClient sqlMapClientOracle;
    @Override
    public List<FreightForwarding> getOrcalData() throws Exception {
        return sqlMapClientOracle.queryForList("SyncFreightForwarding.getOracleData");
    }

    @Override
    public List<BankAccBas> getOraclBankAcc() throws Exception {
        return sqlMapClientOracle.queryForList("SyncFreightForwarding.getBankAcc");
    }

    @Override
    public List<SupplierLinkman> getOraclLinkMan() throws Exception {
        return sqlMapClientOracle.queryForList("SyncFreightForwarding.getLinkMan");
    }


}
