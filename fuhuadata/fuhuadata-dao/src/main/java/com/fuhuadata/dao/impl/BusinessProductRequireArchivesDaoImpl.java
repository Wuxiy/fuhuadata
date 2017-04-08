package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BusinessProductRequireArchivesDao;
import com.fuhuadata.dao.BusinessProductRequireDao;
import com.fuhuadata.domain.BusinessProductRequire;
import com.fuhuadata.domain.BusinessProductRequireArchives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by hexingfu on 2017/4/5.
 */
@Repository
public class BusinessProductRequireArchivesDaoImpl implements BusinessProductRequireArchivesDao {
    private static final String INSERT = "BusinessProductRequireArchives.addArchives";
    private static final String UPDATE = "BusinessProductRequireArchives.updateArchives";
    private static final String GET_BY_ORDER_PRODUCT_ID = "BusinessProductRequireArchives.getByQuery";
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public int addArchives(Integer businessProductId) {
        return (Integer)sqlMapClientTemplate.insert(INSERT,businessProductId);
    }

    @Override
    public int updateArchives(Integer businessProductId) {
        return sqlMapClientTemplate.update(UPDATE,businessProductId);
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
