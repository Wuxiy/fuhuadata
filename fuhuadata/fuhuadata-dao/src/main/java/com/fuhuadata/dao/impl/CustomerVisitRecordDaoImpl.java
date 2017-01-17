package com.fuhuadata.dao.impl;
import java.util.List;
import com.fuhuadata.dao.CustomerVisitRecordDao;
import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.query.QueryCustomerVisitRecord;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import java.util.Map;
import java.io.Serializable;
/**
 * @author wangbo
 * @date 2017-01-13 16:22:04
 */
@SuppressWarnings("unchecked")
public class CustomerVisitRecordDaoImpl extends SqlMapClientTemplate implements CustomerVisitRecordDao {

    public static final String ADD = "CUSTOMERVISITRECORD.ADD";
    public static final String UPDATE = "CUSTOMERVISITRECORD.UPDATE";
    public static final String DELETE_BY_ID = "CUSTOMERVISITRECORD.DELETE-BY-ID";
    public static final String GET_ALL = "CUSTOMERVISITRECORD.GET-ALL";
    public static final String GET_BY_QUERY = "CUSTOMERVISITRECORD.GET-BY-QUERY";
    public static final String GET_BY_ID = "CUSTOMERVISITRECORD.GET-BY-ID";
    public static final String GET_PAGE = "CUSTOMERVISITRECORD.GET-PAGE";
    public static final String COUNT = "CUSTOMERVISITRECORD.COUNT";
    
    public CustomerVisitRecord addCustomerVisitRecord(CustomerVisitRecord customerVisitRecord) {
		customerVisitRecord.setVisitrecordId((Integer) this.insert(ADD, customerVisitRecord));
    	return customerVisitRecord;
    }
    
    public int updateCustomerVisitRecordById(int visitrecord_id, CustomerVisitRecord customerVisitRecord) {
    	customerVisitRecord.setVisitrecordId(visitrecord_id);
		return this.update(UPDATE, customerVisitRecord);
    }
    
    public int deleteCustomerVisitRecordById(int visitrecord_id) {
    	return this.update(DELETE_BY_ID, visitrecord_id);
    }
    
    public List<CustomerVisitRecord> getAllCustomerVisitRecords() {
    	return this.queryForList(GET_ALL);
    }
    	
    public List<CustomerVisitRecord> getCustomerVisitRecordsByQuery(QueryCustomerVisitRecord queryCustomerVisitRecord) {
    	return this.queryForList(GET_BY_QUERY, queryCustomerVisitRecord);
    }
    	
    public CustomerVisitRecord getCustomerVisitRecordById(int visitrecord_id) {
    	return (CustomerVisitRecord) this.queryForObject(GET_BY_ID, visitrecord_id);
    }
    
    public List<CustomerVisitRecord> getCustomerVisitRecordsByPage(QueryCustomerVisitRecord queryCustomerVisitRecord) {
    	return this.queryForList(GET_PAGE, queryCustomerVisitRecord);
    }
    	
    public int count(QueryCustomerVisitRecord queryCustomerVisitRecord) {
    	return ((Integer) this.queryForObject(COUNT, queryCustomerVisitRecord)).intValue();
    }
}