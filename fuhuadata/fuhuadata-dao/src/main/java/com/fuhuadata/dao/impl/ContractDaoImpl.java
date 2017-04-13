package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BaseDao;
import com.fuhuadata.dao.ContractDao;
import com.fuhuadata.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

/**
 * NC 合同
 * Created by wuxi on 2017/4/13.
 */
public class ContractDaoImpl extends BaseDao<Contract>  implements ContractDao {

    private final static String GET_CONTRACT_STATISTICAL="CONTRACT.GET-CONTRACT-STATISTICAL";
    private final static String GET_CONTRACT_PRODUCT_STATISTICAL="CONTRACT.GET-CONTRACT-PRODUCT-STATISTICAL";
    private final static String UPDATE_ODER_STATISTICAL="CONTRACT.UPDATE-ORDER-STATISTICAL";
    private final static String UPDATE＿ORDER_PRODUCT_STATISTICAL="CONTRACT.UPDATE-ORDER-PRODUCT-STATISTICAL";

    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;


    @Override
    public List<Contract> getContractStatistical() {
        return sqlMapClientTemplate.queryForList(GET_CONTRACT_STATISTICAL);
    }

    @Override
    public List<Contract> getContractProductStatistical() {
        return sqlMapClientTemplate.queryForList(GET_CONTRACT_PRODUCT_STATISTICAL);
    }

    @Override
    public boolean updateBusinessOrderStatistical(List<Contract> contracts) {
        return this.batch(sqlMapClientTemplate,UPDATE_ODER_STATISTICAL,contracts);
    }

    @Override
    public boolean updateBusinessOrderProductStatistical(List<Contract> contracts) {
        return this.batch(sqlMapClientTemplate,UPDATE＿ORDER_PRODUCT_STATISTICAL,contracts);
    }
}
