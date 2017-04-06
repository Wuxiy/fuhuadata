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
    private static final String INSERT_STMT = "BUSINESSORDERPRODUCT.insertBasic";
    private static final String IUPDATE_STMT = "BUSINESSORDERPRODUCT.update";
    private static final String GET_LIST_STMT = "BUSINESSORDERPRODUCT.";
    private static final String COUNT_STMT = "BUSINESSORDERPRODUCT.";
    private static final String GET_LIST_BY_PAGE_STMT = "BUSINESSORDERPRODUCT.";

    public int insertBaseInfo(BusinessOrderProduct businessOrderProduct) throws Exception{
        return (Integer)sqlMapClient.insert(INSERT_STMT,businessOrderProduct);
    }

    public int updateBusinessOrderProduct(BusinessOrderProduct businessOrderProduct)throws Exception {
        return sqlMapClient.update(IUPDATE_STMT,businessOrderProduct);
    }

    public List<BusinessOrderProduct> getList(QueryBusinessOrderProduct queryBusinessOrderProduct) {
        try {
            return sqlMapClient.queryForList(GET_LIST_STMT,queryBusinessOrderProduct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int count(QueryBusinessOrderProduct queryBusinessOrderProduct) {
        try {
            return (Integer)sqlMapClient.queryForObject(COUNT_STMT,queryBusinessOrderProduct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<BusinessOrderProduct> getListByPage(QueryBusinessOrderProduct queryBusinessOrderProduct) {
        try {
            return sqlMapClient.queryForList(GET_LIST_BY_PAGE_STMT,queryBusinessOrderProduct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
