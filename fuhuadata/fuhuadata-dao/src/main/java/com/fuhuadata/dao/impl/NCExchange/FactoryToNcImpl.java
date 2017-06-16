package com.fuhuadata.dao.impl.NCExchange;

import com.fuhuadata.dao.NCExchange.FactoryToNc;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.Map;

/**
 * Created by zhangxiang on 2017/6/7.
 */
public class FactoryToNcImpl extends SqlMapClientTemplate implements FactoryToNc {

    private static final String UPDATE_PKFACTORY="FactoryToNc.UPDATE-PKFACTORY";
    private static final String UPDATE_PKBANKACCBAS="FactoryToNc.UPDATE-PKBANKACCBAS";
    private static final String GET_PKSUPPLIER_BY_ID="FactoryToNc.GET_PKSUPPLIER_BY_ID";
    @Override
    public void updatePkFactory(Map<String, Object> maps) {
        this.update(UPDATE_PKFACTORY,maps);
    }
    public void updatePkBankaccbas(Map<String,Object> mapc){
        this.update(UPDATE_PKBANKACCBAS,mapc);
    }

    @Override
    public String getPkSupplierById(int id) {
        return (String) this.queryForObject(GET_PKSUPPLIER_BY_ID,id);
    }

}
