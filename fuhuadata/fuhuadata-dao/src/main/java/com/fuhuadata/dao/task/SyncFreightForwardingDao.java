package com.fuhuadata.dao.task;

import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.mybatis.supplier.FreightForwarding;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by zhangxiang on 2017/6/9.
 */
public interface SyncFreightForwardingDao {

    List<FreightForwarding> getOrcalData() throws Exception;
    List<BankAccBas> getOraclBankAcc() throws Exception;
    List<SupplierLinkman> getOraclLinkMan() throws Exception;

}
