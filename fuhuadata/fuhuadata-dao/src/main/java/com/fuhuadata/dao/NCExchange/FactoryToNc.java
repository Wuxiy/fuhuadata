package com.fuhuadata.dao.NCExchange;

import java.util.Map;

/**
 * Created by zhangxiang on 2017/6/7.
 */
public interface FactoryToNc {
    /**
     * 将nc回写的pk_factory更新crm
     * @param maps
     */
    void updatePkFactory(Map<String,Object> maps);
    void updatePkBankaccbas(Map<String,Object> mapc);
    String getPkSupplierById(int id);
}
