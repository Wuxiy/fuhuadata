package com.fuhuadata.dao.impl;
import java.util.List;
import com.fuhuadata.domain.query.QueryCustomerLinkman;
import com.fuhuadata.dao.CustomerLinkmanDao;
import com.fuhuadata.domain.CustomerLinkman;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import java.util.Map;
import java.io.Serializable;
/**
 * @author wangbo
 * @date 2017-01-13 16:10:56
 */
@SuppressWarnings("unchecked")
public class CustomerLinkmanDaoImpl extends SqlMapClientTemplate implements CustomerLinkmanDao {

    public static final String ADD = "CUSTOMERLINKMAN.ADD";
    public static final String UPDATE = "CUSTOMERLINKMAN.UPDATE";
    public static final String DELETE_BY_ID = "CUSTOMERLINKMAN.DELETE-BY-ID";
    public static final String GET_ALL = "CUSTOMERLINKMAN.GET-ALL";
    public static final String GET_BY_QUERY = "CUSTOMERLINKMAN.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERLINKMAN.GET-BY-ID";
    public static final String GET_PAGE = "CUSTOMERLINKMAN.GET-PAGE";
    public static final String COUNT = "CUSTOMERLINKMAN.COUNT";
    public static final String GET_BY_CUSTOMER_ID="CUSTOMERLINKMAN.GET-BY-CUSTOMER-ID";
    public static final String GET_IS_DEFAULT="CUSTOMERLINKMAN.GET-IS-DEFAULT";
    
    public CustomerLinkman addCustomerLinkman(CustomerLinkman customerLinkman) {
		customerLinkman.setLinkmanId((String) this.insert(ADD, customerLinkman));
    	return customerLinkman;
    }
    
    public int updateCustomerLinkmanById(String linkman_id, CustomerLinkman customerLinkman) {
    	customerLinkman.setLinkmanId(linkman_id);
		return this.update(UPDATE, customerLinkman);
    }
    
    public int deleteCustomerLinkmanById(String linkman_id) {
    	return this.update(DELETE_BY_ID, linkman_id);
    }

    @Override
    public CustomerLinkman getCustomerLinkmanDefaultByCustomerId(String customerId) {
        return (CustomerLinkman) queryForObject(GET_IS_DEFAULT,customerId);
    }

    public List<CustomerLinkman> getAllCustomerLinkmans() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<CustomerLinkman> getCustomerLinkmansByQuery(QueryCustomerLinkman queryCustomerLinkman) {
    	return this.queryForList(GET_BY_QUERY, queryCustomerLinkman);
    }
    	
    public CustomerLinkman getCustomerLinkmanById(String linkman_id) {
    	return (CustomerLinkman) this.queryForObject(GET_BY_ID, linkman_id);
    }

    @Override
    public List<CustomerLinkman> getCustomerLinkmanByCustomerId(String customerId) {
        return this.queryForList(GET_BY_CUSTOMER_ID,customerId);

    }

    public List<CustomerLinkman> getCustomerLinkmansByPage(QueryCustomerLinkman queryCustomerLinkman) {
    	return this.queryForList(GET_PAGE, queryCustomerLinkman);
    }
    	
    public int count(QueryCustomerLinkman queryCustomerLinkman) {
    	return ((Integer) this.queryForObject(COUNT, queryCustomerLinkman)).intValue();
    }
}