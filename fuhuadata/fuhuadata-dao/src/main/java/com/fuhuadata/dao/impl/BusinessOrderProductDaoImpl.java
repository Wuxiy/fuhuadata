package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BusinessOrderProductDao;
import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.query.QueryBusinessOrderProduct;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
    private static final String INSERT_FROM_ARCHIVES = "BUSINESSORDERPRODUCT.insertFromArchives";
    private static final String DELETE_ALL_INFO_BY_IDS = "BUSINESSORDERPRODUCT,deleteAllInfoByIds";
    private static final String GET_BAISC_BY_ID = "BUSINESSORDERPRODUCT.getBasicById";
    private static final String GET_DOCUMENTARY_BY_ID = "BUSINESSORDERPRODUCT.getDocumentaryById";
    private static final String GET_PACKAGE_REQUIRE_BY_ID = "BUSINESSORDERPRODUCT.getPackageRequireById";
    private static final String GET_PRICE_TYPE = "BUSINESSORDERPRODUCT.getPriceType";
    private static final String CALCULATE_PROCESS_COST = "BUSINESSORDERPRODUCT.calculateProcesscost";
    public int insertBaseInfo(BusinessOrderProduct businessOrderProduct) throws Exception{
        return (Integer)sqlMapClient.insert(INSERT_STMT,businessOrderProduct);
    }

    @Override
    public int insertFromArchives(BusinessOrderProduct businessOrderProduct) throws Exception {
        return (Integer)sqlMapClient.insert(INSERT_FROM_ARCHIVES,businessOrderProduct);
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

    @Override
    public boolean deleteAllInfoByIds(String businessProductIds)throws Exception {
        return (Integer)sqlMapClient.delete(DELETE_ALL_INFO_BY_IDS,businessProductIds) >0;
    }
    @Override
    public BusinessOrderProduct getBaiscById(int id) {
        try {
            return (BusinessOrderProduct)sqlMapClient.queryForObject(GET_BAISC_BY_ID,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BusinessOrderProduct getDocumentaryById(int id) {
        try {
            return (BusinessOrderProduct)sqlMapClient.queryForObject(GET_DOCUMENTARY_BY_ID,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BusinessOrderProduct getPackageRequireById(int id) {
        try {
            return (BusinessOrderProduct)sqlMapClient.queryForObject(GET_PACKAGE_REQUIRE_BY_ID,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getPriceType(Integer businessProduct) {
        try {
            return (Integer)sqlMapClient.queryForObject(GET_PRICE_TYPE,businessProduct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public BigDecimal calculateProcessCost(Integer businessProdcutId) {
        try {
            return (BigDecimal)sqlMapClient.queryForObject(CALCULATE_PROCESS_COST,businessProdcutId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
