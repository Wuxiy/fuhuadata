package com.fuhuadata.manager;
import java.util.List;
import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.query.QueryCustomerVisitRecord;
import com.fuhuadata.vo.CustomerVisitRecordLinkman;
import com.fuhuadata.vo.CustomerVisitRecordVO;
import com.fuhuadata.vo.VisitRecordVO;


/**
 * @author wangbo
 * @date 2017-01-13 16:22:04
 */
public interface CustomerVisitRecordManager {
	/**
	 * 新增 customerVisitRecord,返回customerVisitRecord对象(设置了新生成id)
	 * @param customerVisitRecord
	 * @return
	 */
    public CustomerVisitRecord addCustomerVisitRecord(CustomerVisitRecord customerVisitRecord) ;

    public boolean addVisitRecord(CustomerVisitRecordVO customerVisitRecordVO);
    
	 /**
     * 按照主键id更新customerVisitRecord，请重新new CustomerVisitRecord 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param visitrecord_id
     * @param customerVisitRecord
     * @return
     */
    public boolean updateCustomerVisitRecordById(int visitrecord_id, CustomerVisitRecord customerVisitRecord);

    /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param visitrecord_id
     * @return
     */
    public boolean deleteCustomerVisitRecordById(int visitrecord_id);

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
     * 通过主键id查询CustomerVisitRecord
	 * 查询不到返回NULL值
     * @param visitrecord_id
     * @return
     */
    public CustomerVisitRecordLinkman getCustomerVisitRecordById(int visitrecord_id);

	/**
	 * 根据客户id返回关于客户的沟通记录
	 * @param customerId
	 * @return
	 */
	public List<VisitRecordVO> getCustomerVisitRecordByCustomerId(String customerId);

	/**
	 * 根据联系人id返回关于联系人的沟通记录
	 * @param linkmanId
	 * @return
	 */
	public List<VisitRecordVO> getCustomerVisitRecordByLinkmanId(String linkmanId);

    /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param queryCustomerVisitRecord
     * @return
     */
    public List<QueryCustomerVisitRecord> getCustomerVisitRecordsByPage(QueryCustomerVisitRecord queryCustomerVisitRecord);

    /**
     * 查询总数
     * @param queryCustomerVisitRecord
     * @return
     */
    public int count(QueryCustomerVisitRecord queryCustomerVisitRecord);
	
}