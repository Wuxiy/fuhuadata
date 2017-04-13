package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BusinessProductRequireDao;
import com.fuhuadata.domain.BusinessProductRequire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hexingfu on 2017/4/5.
 */
@Service
public class BusinessProductRequireDaoImpl implements BusinessProductRequireDao {
    private static final String INSERT = "BusinessProductRequire.insert";
    private static final String UPDATE = "BusinessProductRequire.update";
    private static final String DELETE = "BusinessProductRequire.delete";
    private static final String GET_BY_QUERY = "BusinessProductRequire.getByQuery";
    private static final String INSERT_FROM_ARCHIVES = "BusinessProductRequire.insertFromArchives";

    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Override
    public int addProductRequire(BusinessProductRequire businessProductRequire) {
        return (Integer)sqlMapClientTemplate.insert(INSERT,businessProductRequire);
    }

    @Override
    public int insertFromArchives(Map<String,Object> map) {
        return (Integer)sqlMapClientTemplate.insert(INSERT_FROM_ARCHIVES,map);
    }

    @Override
    public int updateProductRequire(BusinessProductRequire businessProductRequire) {
        return sqlMapClientTemplate.update(UPDATE,businessProductRequire);
    }

    @Override
    public int deleteProductRequire(int id) {
        return sqlMapClientTemplate.delete(DELETE,id);
    }

    public BusinessProductRequire getOneByQuery(BusinessProductRequire businessProductRequire ) {
        try {
            return (BusinessProductRequire)sqlMapClientTemplate.queryForObject(GET_BY_QUERY,businessProductRequire);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
