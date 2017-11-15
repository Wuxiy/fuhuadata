package com.fuhuadata.dao.task.impl;

import com.fuhuadata.dao.task.SyncBaseInfoDao;
import com.fuhuadata.domain.business.BusinessBuyContract;
import com.fuhuadata.domain.business.BusinessBuyContractProduct;
import com.fuhuadata.domain.business.BusinessOrgiContract;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.mybatis.CustomerBaseInfo;
import com.fuhuadata.domain.mybatis.supplier.FreightForwarding;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhangxiang on 2017/6/9.
 */
public class SyncBaseInfoDaoImpl implements SyncBaseInfoDao {
    @Autowired
    private SqlMapClient sqlMapClientOracle;
    @Override
    public List<FreightForwarding> getOrcalData() throws Exception {
        return sqlMapClientOracle.queryForList("SyncBaseInfo.getOracleData");
    }

    @Override
    public List<BankAccBas> getOraclBankAcc() throws Exception {
        return sqlMapClientOracle.queryForList("SyncBaseInfo.getBankAcc");
    }

    @Override
    public List<SupplierLinkman> getOraclLinkMan() throws Exception {
        return sqlMapClientOracle.queryForList("SyncBaseInfo.getLinkMan");
    }

    @Override
    public List<WarehouseInfo> getStorDoc() throws Exception {
        return sqlMapClientOracle.queryForList("SyncBaseInfo.getStorDoc");
    }

    @Override
    public List<CustomerBaseInfo> getCustomerBaseInfo() throws Exception {
        return sqlMapClientOracle.queryForList("SyncBaseInfo.getCustomerBaseInfo");
    }

    @Override
    public List<BusinessBuyContract> getBusinessBuyContract() throws Exception {
        return sqlMapClientOracle.queryForList("SyncBaseInfo.getBusinessBuyContract");
    }

    @Override
    public List<BusinessBuyContractProduct> getBuyContractProduct() throws Exception {
        return sqlMapClientOracle.queryForList("SyncBaseInfo.getBuyContractProduct");
    }

    @Override
    public List<BusinessOrgiContract> getOrgiContract() throws Exception {
        return sqlMapClientOracle.queryForList("SyncBaseInfo.getOrgiContract");
    }

}
