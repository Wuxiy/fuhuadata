package com.fuhuadata.dao;
import java.util.List;
import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.query.QueryCustomerVisitRecord;
import java.util.Map;
import java.io.Serializable;

/**
 * @author wangbo
 * @date 2017-01-13 16:22:04
 */
public interface CustomerVisitRecordDao {
	/**
	 * 新增 customerVisitRecord,返回customerVisitRecord对象(设置了新生成id)
	 * @param customerVisitRecord
	 * @return
	 */
    public CustomerVisitRecord addCustomerVisitRecord(CustomerVisitRecord customerVisitRecord);
    
	 /**
     * 按照主键id更新customerVisitRecord，成功返回1，使用接口时，请重新new CustomerVisitRecord 的更新对象，设置要更新的字段
     * @paramid
     * @param customerVisitRecord
     * @return
     */
    public int updateCustomerVisitRecordById(int visitrecord_id, CustomerVisitRecord customerVisitRecord);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @paramid
     * @return
     */
    public int deleteCustomerVisitRecordById(int visitrecord_id);
    
	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<CustomerVisitRecord> getAllCustomerVisitRecords();
    
    /**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param queryCustomerVisitRecord
     * @return
     */
    public List<CustomerVisitRecord> getCustomerVisitRecordsByQuery(QueryCustomerVisitRecord queryCustomerVisitRecord);
    
    /**
     * 通过主键id查询CustomerVisitRecord，查询不到返回NULL值
     * @paramid
     * @return
     */
    public CustomerVisitRecord getCustomerVisitRecordById(int visitrecord_id);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param queryCustomerVisitRecord
     * @return
     */
    public List<CustomerVisitRecord> getCustomerVisitRecordsByPage(QueryCustomerVisitRecord queryCustomerVisitRecord);
    	
	 /**
     * 查询总数
     * @param queryCustomerVisitRecord
     * @return
     */
    public int count(QueryCustomerVisitRecord queryCustomerVisitRecord);
    		
}