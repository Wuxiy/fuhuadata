package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BaseDao;
import com.fuhuadata.dao.BusinessOrderProductComponentDao;
import com.fuhuadata.domain.BusinessOrderProductComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hexingfu on 2017/4/5.
 */
@Repository
public class BusinessOrderProductComponentDaoImpl extends BaseDao<BusinessOrderProductComponent> implements BusinessOrderProductComponentDao {
    private static final String INSERT = "BusinessOrderProductComponent.insert";
    private static final String GET_BY_BUSINESS_PRODUCT_ID = "BusinessOrderProductComponent.getListByBusinessProductId";
    private static final String UPDATE = "BusinessOrderProductComponent.update";
    private static final String INSERT_FROM_ARCHIVES = "BusinessOrderProductComponent.insertFromArchives";
    private static final String GET_BY_PRODUCT_ID = "BusinessOrderProductComponent.getListByProductId";
    private static final String ADD_ARCHIVES = "BusinessOrderProductComponent.addArchives";
    private static final String UPDATE_ARCHIVES = "BusinessOrderProductComponent.updateArchives";
    private static final String DELETE_ORDER_PRODUCT_COMPONENT = "BusinessOrderProductComponent.deleteOrderProductComponent";
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;
    @Override
    public boolean insertProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents) {
        return this.batch(sqlMapClientTemplate,INSERT,businessOrderProductComponents);
    }

    @Override
    public int insertFromArchives(Map<String,Object> map) {
        try {
            return (Integer)sqlMapClientTemplate.insert(INSERT_FROM_ARCHIVES,map);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<BusinessOrderProductComponent> getProductComponentsByBusinessProductId(int BusinessProductId) {
        return sqlMapClientTemplate.queryForList(GET_BY_BUSINESS_PRODUCT_ID,BusinessProductId);
    }

    public List<BusinessOrderProductComponent> getProductComponentsByProductId(int productId) {
        return sqlMapClientTemplate.queryForList(GET_BY_PRODUCT_ID,productId);
    }
    public void deleteOrderProductComponent(int type,int businessProductId,int wareId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("businessProductId",businessProductId);
        map.put("wareId",wareId);
        map.put("type",type);
        sqlMapClientTemplate.delete(DELETE_ORDER_PRODUCT_COMPONENT,map);
    }

    @Override
    public boolean updateProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents) {
        return this.batch(sqlMapClientTemplate,UPDATE,businessOrderProductComponents);
    }

    @Override
    public int addArchives(Map<String, Object> map) {
        return (Integer)sqlMapClientTemplate.insert(ADD_ARCHIVES,map);
    }

    @Override
    public int updateArchives(Integer businessProductId) {
        return sqlMapClientTemplate.update(UPDATE_ARCHIVES,businessProductId);
    }
    public  int getArchiveIdByBusinessProductId(int businessProductId){
        try {
            return (Integer) sqlMapClientTemplate.queryForObject("BusinessOrderProductComponent.getArchiveIdByBusinessProductId",businessProductId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
