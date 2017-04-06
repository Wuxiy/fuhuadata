package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BaseDao;
import com.fuhuadata.dao.BusinessOrderProductComponentDao;
import com.fuhuadata.domain.BusinessOrderProductComponent;
import org.springframework.beans.factory.annotation.Autowired;
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
    private static final String GET_BY_ORDER_PRODUCT = "BusinessOrderProductComponent.getOrderProductComponent";
    private static final String UPDATE = "BusinessOrderProductComponent.update";
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;
    @Override
    public boolean insertProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents) {
        return this.batch(sqlMapClientTemplate,INSERT,businessOrderProductComponents);
    }

    @Override
    public List<BusinessOrderProductComponent> getProductComponentsByOrderAndProduct(int orderId, int productId) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("orderId",orderId);
        map.put("productId",productId);
        return sqlMapClientTemplate.queryForList(GET_BY_ORDER_PRODUCT,map);
    }

    @Override
    public boolean updateProductComponent(List<BusinessOrderProductComponent> businessOrderProductComponents) {
        return this.batch(sqlMapClientTemplate,UPDATE,businessOrderProductComponents);
    }
}
