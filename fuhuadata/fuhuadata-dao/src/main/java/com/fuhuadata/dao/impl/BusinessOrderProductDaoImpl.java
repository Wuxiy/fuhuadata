package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BusinessOrderProductDao;
import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.query.QueryBusinessOrderProduct;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hexingfu on 2017/3/30.
 */
@Repository
public class BusinessOrderProductDaoImpl implements BusinessOrderProductDao {

    @Autowired
    private SqlMapClient sqlMapClient;

    public int insertBaseInfo(BusinessOrderProduct businessOrderProduct) throws Exception{
        return (Integer)sqlMapClient.insert("",businessOrderProduct);
    }

    public int updateBusinessOrderProduct(BusinessOrderProduct businessOrderProduct)throws Exception {
        return sqlMapClient.update("",businessOrderProduct);
    }

    public int count(QueryBusinessOrderProduct queryBusinessOrderProduct) {
        return 0;
    }

    public List<BusinessOrderProduct> getListByPage(QueryBusinessOrderProduct queryBusinessOrderProduct) {
        return null;
    }
}
