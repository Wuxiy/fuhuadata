package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BusinessProductRequireArchivesDao;
import com.fuhuadata.dao.BusinessProductRequireDao;
import com.fuhuadata.domain.BusinessProductRequire;
import com.fuhuadata.domain.BusinessProductRequireArchives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * Created by hexingfu on 2017/4/5.
 */
public class BusinessProductRequireArchivesDaoImpl implements BusinessProductRequireArchivesDao {
    private static final String INSERT = "insert";
    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
    private static final String GET_BY_ORDER_PRODUCT_ID = "getByQuery";
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;
    @Override
    public int addProductRequireArchives(BusinessProductRequireArchives businessProductRequireArchives) {
        return (Integer)sqlMapClientTemplate.insert(INSERT,businessProductRequireArchives);
    }

    @Override
    public int updateProductRequireArchives(BusinessProductRequireArchives businessProductRequireArchives) {
        return sqlMapClientTemplate.update(UPDATE,businessProductRequireArchives);
    }

    @Override
    public int deleteProductRequireArchives(int id) {
        return sqlMapClientTemplate.delete(DELETE,id);
    }

    @Override
    public BusinessProductRequireArchives getByOrderProductId(int orderProductId) {
        try {
            BusinessProductRequire businessProductRequire = new BusinessProductRequire();
            businessProductRequire.setBusinessProductId(orderProductId);
            return (BusinessProductRequireArchives)sqlMapClientTemplate.queryForObject(GET_BY_ORDER_PRODUCT_ID,businessProductRequire);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
