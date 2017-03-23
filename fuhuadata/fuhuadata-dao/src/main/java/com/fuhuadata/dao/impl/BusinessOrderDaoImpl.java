package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BaseDao;
import com.fuhuadata.dao.BusinessOrderDao;
import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.query.QueryBusinessOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hexingfu on 2017/3/18.
 */
@Repository
public class BusinessOrderDaoImpl  implements BusinessOrderDao {

    private static final String COUNT = "BusinessOrder.count";
    private static final String QUERY_PAGE = "BusinessOrder.query_page";
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;
    @Override
    public int count(QueryBusinessOrder queryBusinessOrder) {
        try {
            return (Integer)sqlMapClientTemplate.queryForObject(COUNT,queryBusinessOrder);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override

    public List<BusinessOrder> getOrderLisPageByQuery(QueryBusinessOrder queryBusinessOrder) {
        return sqlMapClientTemplate.queryForList(QUERY_PAGE,queryBusinessOrder);
    }
}
