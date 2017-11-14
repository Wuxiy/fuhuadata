package com.fuhuadata.dao.task;

import com.fuhuadata.domain.business.BusinessBuyContract;
import com.fuhuadata.domain.business.BusinessBuyContractProduct;
import com.fuhuadata.domain.business.BusinessOrgiContract;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.mybatis.CustomerBaseInfo;
import com.fuhuadata.domain.mybatis.supplier.FreightForwarding;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by zhangxiang on 2017/6/9.
 */
public interface SyncBaseInfoDao {

    List<FreightForwarding> getOrcalData() throws Exception;
    List<BankAccBas> getOraclBankAcc() throws Exception;
    List<SupplierLinkman> getOraclLinkMan() throws Exception;
    List<WarehouseInfo> getStorDoc() throws Exception;
    List<CustomerBaseInfo> getCustomerBaseInfo() throws Exception;
    List<BusinessBuyContract> getBusinessBuyContract() throws Exception;
    List<BusinessBuyContractProduct> getBuyContractProduct() throws Exception;
    List<BusinessOrgiContract> getOrgiContract() throws Exception;
}
