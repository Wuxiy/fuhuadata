package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BusinessProductRequireDao;
import com.fuhuadata.domain.BusinessProductRequire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * Created by hexingfu on 2017/4/5.
 */
public class BusinessProductRequireDaoImpl implements BusinessProductRequireDao {
    private static final String INSERT = "insert";
    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
    private static final String GET_BY_ORDER_PRODUCT_ID = "getByQuery";
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;
    @Override
    public int addProductRequire(BusinessProductRequire businessProductRequire) {
        return (Integer)sqlMapClientTemplate.insert(INSERT,businessProductRequire);
    }

    @Override
    public int updateProductRequire(BusinessProductRequire businessProductRequire) {
        return sqlMapClientTemplate.update(UPDATE,businessProductRequire);
    }

    @Override
    public int deleteProductRequire(int id) {
        return sqlMapClientTemplate.delete(DELETE,id);
    }

    @Override
    public BusinessProductRequire getByOrderProductId(int orderProductId) {
        try {
            BusinessProductRequire businessProductRequire = new BusinessProductRequire();
            businessProductRequire.setBusinessProductId(orderProductId);
            return (BusinessProductRequire)sqlMapClientTemplate.queryForObject(GET_BY_ORDER_PRODUCT_ID,businessProductRequire);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
