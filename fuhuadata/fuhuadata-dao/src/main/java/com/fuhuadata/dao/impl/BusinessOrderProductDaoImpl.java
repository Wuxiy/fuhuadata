package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.BaseDao;
import com.fuhuadata.dao.BusinessOrderProductDao;
import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.query.BusinessOrderProductsAddByCopy;
import com.fuhuadata.domain.query.QueryBusinessOrderProduct;
import com.fuhuadata.vo.BusinessOrderProductList;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by hexingfu on 2017/3/30.
 */
@Repository
public class BusinessOrderProductDaoImpl extends BaseDao<BusinessOrderProduct> implements BusinessOrderProductDao {

    @Autowired
    private SqlMapClient sqlMapClient;
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;
    private static final String INSERT_STMT = "BUSINESSORDERPRODUCT.insertBasic";
    private static final String IUPDATE_STMT = "BUSINESSORDERPRODUCT.update";
    private static final String GET_LIST_STMT = "BUSINESSORDERPRODUCT.";
    private static final String COUNT_STMT = "BUSINESSORDERPRODUCT.";
    private static final String GET_ORDER_PRODUCTS_BY_ORDER_ID="BUSINESSORDERPRODUCT.getOrderProductsByOrderId";
    private static final String GET_LIST_BY_PAGE_STMT = "BUSINESSORDERPRODUCT.";
    private static final String INSERT_FROM_ARCHIVES = "BUSINESSORDERPRODUCT.insertFromArchives";
    private static final String DELETE_ALL_INFO_BY_IDS = "BUSINESSORDERPRODUCT.deleteAllInfoByIds";
    private static final String GET_BAISC_BY_ID = "BUSINESSORDERPRODUCT.getBasicById";
    private static final String GET_DOCUMENTARY_BY_ID = "BUSINESSORDERPRODUCT.getDocumentaryById";
    private static final String GET_PACKAGE_REQUIRE_BY_ID = "BUSINESSORDERPRODUCT.getPackageRequireById";
    private static final String GET_PRICE_TYPE = "BUSINESSORDERPRODUCT.getPriceType";
    private static final String CALCULATE_PROCESS_COST = "BUSINESSORDERPRODUCT.calculateProcesscost";

    private static final String GET_ORDER_PRODUCT_LIST="BUSINESSORDERPRODUCT.GET-ORDER-PRODUCT-LIST";
    private static final String IUPDATE_BASIC = "BUSINESSORDERPRODUCT.updateBasic";

    private static final String ADD_PRODUCTS_COPY="BUSINESSORDERPRODUCT.addProductByCopy";
    private static final String ADD_PRODUCT_COMPONENT="BUSINESSORDERPRODUCT.addProductComponentByCopy";
    private static final String ADD_PRODUCT_REQUIRE="BUSINESSORDERPRODUCT.addProductRequireByCopy";

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
    public int updateBusinessOrderProduct_basic(BusinessOrderProduct businessOrderProduct)throws Exception {
        return sqlMapClient.update(IUPDATE_BASIC,businessOrderProduct);
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
    public String getPriceType(Integer businessProduct) {
        try {
            return (String)sqlMapClient.queryForObject(GET_PRICE_TYPE,businessProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BigDecimal calculateProcessCost(Integer businessProdcutId) {
        try {
            BigDecimal sys= (BigDecimal)sqlMapClient.queryForObject(CALCULATE_PROCESS_COST,businessProdcutId);
            return sys==null?new BigDecimal(0):sys;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BusinessOrderProductList> getOrderProductList(String orderId) {
        try {
            return sqlMapClient.queryForList(GET_ORDER_PRODUCT_LIST,orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BusinessOrderProduct> getBusinessOrderProducts(String orderId){
        try{
            List<BusinessOrderProduct> list = sqlMapClient.queryForList(GET_ORDER_PRODUCTS_BY_ORDER_ID, orderId);

            for(int i=0; i < list.size()-1;i++){
                System.out.println(list.get(i).getMinPrice()+"1111111111111111111");
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public boolean updateBusinessOrderProducts(List<BusinessOrderProduct> businessOrderProducts) {
        if(businessOrderProducts!=null&&businessOrderProducts.size()>0) {
            return this.batch(sqlMapClientTemplate, IUPDATE_STMT, businessOrderProducts);
        }
        return false;
    }

    @Override
    public int addProductsByCopy(BusinessOrderProductsAddByCopy businessOrderProductsAddByCopy) throws Exception {
        return (Integer) sqlMapClient.insert(ADD_PRODUCTS_COPY,businessOrderProductsAddByCopy);
    }

    @Override
    public int addProductComponent(BusinessOrderProductsAddByCopy businessOrderProductsAddByCopy) throws Exception {
        return (Integer) sqlMapClient.insert(ADD_PRODUCT_COMPONENT,businessOrderProductsAddByCopy);
    }

    @Override
    public int addProductRequire(BusinessOrderProductsAddByCopy businessOrderProductsAddByCopy) throws Exception {
        return (Integer) sqlMapClient.insert(ADD_PRODUCT_REQUIRE,businessOrderProductsAddByCopy);
    }


}
