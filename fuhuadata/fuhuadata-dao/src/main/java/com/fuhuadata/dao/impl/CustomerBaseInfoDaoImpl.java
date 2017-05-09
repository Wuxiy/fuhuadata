package com.fuhuadata.dao.impl;
import java.util.List;

import com.fuhuadata.domain.CountCustomersOrderProduct;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import com.fuhuadata.vo.CategoryVO;
import com.fuhuadata.vo.CustomerBaseInfoLinkman;
import com.fuhuadata.vo.CustomerBaseInfoVO;
import com.fuhuadata.vo.DataArchive.Countryzone;
import com.fuhuadata.vo.DataArchive.Formatdoc;
import com.fuhuadata.vo.DataArchive.Timezone;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class CustomerBaseInfoDaoImpl extends SqlMapClientTemplate implements CustomerBaseInfoDao {

    public static final String ADD = "CUSTOMERBASEINFO.ADD";
    public static final String UPDATE = "CUSTOMERBASEINFO.UPDATE";
    public static final String DELETE_BY_ID = "CUSTOMERBASEINFO.DELETE-BY-ID";
    public static final String GET_ALL = "CUSTOMERBASEINFO.GET-ALL";
    public static final String GET_BY_QUERY = "CUSTOMERBASEINFO.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERBASEINFO.GET-BY-ID";
    public static final String GET_PAGE = "CUSTOMERBASEINFO.GET-PAGE";
    public static final String COUNT = "CUSTOMERBASEINFO.COUNT";
    public static final String COUNT_ORDER = "CUSTOMERBASEINFO.countOrderByCustomer";
    public static final String COUNT_ORDER_PRODUCT = "CUSTOMERBASEINFO.countOrderProduct";
    public static final String QUERY_COOPERATION = "CUSTOMERBASEINFO.queryCooperationByCid";
    private static final String GET_CUSTOMER_BASEINFO="CUSTOMERBASEINFO.GET-CUSTOMER-BASEINFO";
    private static final String GET_RPODUCT_BY_ID="CUSTOMERBASEINFO.GET-PRODUCT-BY-ID";
    private static final String BATCH_ADD_NATURE="CUSTOMERBASEINFO.BATCH-ADD-NATURE";
    private static final String DELETE_NATURE_BY_CUSTOMERID="CUSTOMERBASEINFO.DELETE-NATURE-BY-CUSTOMERID";
    private static final String GET_BASEINFO_LINKMANINFO_BY_CUSTOMERID="CUSTOMERBASEINFO.GET-BASEINFO-LINKMANINFO-BY-CUSTOMERID";

    private static final String GET_CUSTCLASS = "CUSTOMERBASEINFO.GET-CUSTCLASS";
    private static final String GET_COUNTRYZONE = "CUSTOMERBASEINFO.GET-COUNTRYZONE";
    private static final String GET_FORMATDOC = "CUSTOMERBASEINFO.GET-FORMATDOC";
    private static final String GET_TIMEZONE = "CUSTOMERBASEINFO.GET-TIMEZONE";

    private static final String GET_ORDER_BY_CUSTOMERID= "CUSTOMERBASEINFO.GET-BY-CUSTOMERID";



    public CustomerBaseInfo addCustomerBaseInfo(CustomerBaseInfo customerBaseInfo) {
		customerBaseInfo.setCustomerId((String)this.insert(ADD, customerBaseInfo));
    	return customerBaseInfo;
    }

    @Override
    public int deleteCustomerEnterpriceNatureByCustomerId(String customerId) {
        return this.delete(DELETE_NATURE_BY_CUSTOMERID,customerId);
    }

    /**
     * 批量新增企业性质
     * @param customerEnterpriceNatures
     * @return
     */
    @Override
    public int batchAddNature(List<CustomerEnterpriceNature> customerEnterpriceNatures) {
        return this.update(BATCH_ADD_NATURE,customerEnterpriceNatures);
    }

    public int updateCustomerBaseInfoById(String customerId, CustomerBaseInfo customerBaseInfo) {
    	customerBaseInfo.setCustomerId(customerId);
		return this.update(UPDATE, customerBaseInfo);
}

    public int deleteCustomerBaseInfoById(String customer_id) {
    	return this.update(DELETE_BY_ID, customer_id);
    }

    /**
     * 订单客户信息
     * @param custoemrId
     * @return
     */
    @Override
    public CustomerBaseInfo getOrderCustomerInfoByCustomerId(String custoemrId) {
        return (CustomerBaseInfo) this.queryForObject(GET_ORDER_BY_CUSTOMERID,custoemrId);
    }

    public List<CustomerBaseInfo> getAllCustomerBaseInfos() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<CustomerBaseInfo> getCustomerBaseInfosByQuery(QueryCustomerBaseInfo queryCustomerBaseInfo) {
    	return this.queryForList(GET_BY_QUERY, queryCustomerBaseInfo);
    }
    	
    public CustomerBaseInfo getCustomerBaseInfoById(String customer_id) {
    	return (CustomerBaseInfo) this.queryForObject(GET_BY_ID, customer_id);
    }

    @Override
    public CustomerBaseInfoLinkman getCustomerBaseInfoLinkmanByCustomerId(String customerId) {
        return (CustomerBaseInfoLinkman) this.queryForObject(GET_BASEINFO_LINKMANINFO_BY_CUSTOMERID,customerId);
    }

    @Override
    public CustomerBaseInfoVO getCustomerInfoById(String customerId) {
        System.out.println(customerId);
        try {
            CustomerBaseInfoVO customerBaseInfoVO = (CustomerBaseInfoVO) this.queryForObject(GET_CUSTOMER_BASEINFO,customerId);
            return customerBaseInfoVO;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CustomerMakeProduct> getCustomerMakeProductById(String customerId) {
        return this.queryForList(GET_RPODUCT_BY_ID,customerId);
    }

    public List<CustomerBaseInfo> getCustomerBaseInfoByPage(QueryCustomerBaseInfo queryCustomerBaseInfo) {
    	return this.queryForList(GET_PAGE, queryCustomerBaseInfo);
    }

    public int count(QueryCustomerBaseInfo queryCustomerBaseInfo) {
    	return ((Integer) this.queryForObject(COUNT, queryCustomerBaseInfo)).intValue();
    }

    public CustomerBaseInfo countOrderByCustomer(String customerId) {
        try {
            return (CustomerBaseInfo)this.queryForObject(COUNT_ORDER,customerId);
        } catch (DataAccessException e) {
           e.printStackTrace();
        }
        return null;
    }

    public List<CountCustomersOrderProduct> countOrderProduct(String customerId) {
        try {
            return  this.queryForList(COUNT_ORDER_PRODUCT,customerId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CustomerBaseInfo queryCooperationByCid(String customerId){
        try {
            return (CustomerBaseInfo)this.queryForObject(QUERY_COOPERATION,customerId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Formatdoc> getFormatdoc() {
        return this.queryForList(GET_FORMATDOC);
    }

    @Override
    public List<Countryzone> getCountryzone(Countryzone countryzone) {
        return this.queryForList(GET_COUNTRYZONE,countryzone);
    }

    @Override
    public List<Timezone> getTimezone(Timezone timezone) {
        return this.queryForList(GET_TIMEZONE,timezone);
    }

    @Override
    public List<CategoryVO> getCustclass() {
        return this.queryForList(GET_CUSTCLASS);
    }
}