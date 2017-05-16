package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.query.QueryCustomerVisitRecord;
import com.fuhuadata.vo.CustomerVisitRecordLinkman;
import com.fuhuadata.vo.CustomerVisitRecordVO;
import com.fuhuadata.vo.VisitRecordVO;

import javax.management.Query;

/**
 * @author wangbo
 * @date 2017-01-13 16:22:04
 */
public interface CustomerVisitRecordService {

	/**
	 * 新增 customerVisitRecord
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 customerVisitRecord
	 * @param customerVisitRecord
	 * @return
	 */
    public Result<CustomerVisitRecord> addCustomerVisitRecord(CustomerVisitRecord customerVisitRecord) ;

    public Result addVisitRecord(CustomerVisitRecordVO customerVisitRecordVO);
 
    /**
     * 按照主键id更新customerVisitRecord，请重新new CustomerVisitRecord 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param visitrecord_id
     * @param customerVisitRecord
     * @return
     */
    public Result updateCustomerVisitRecordById(int visitrecord_id, CustomerVisitRecord customerVisitRecord);


    public Result updateCustomerVisitRecord(CustomerVisitRecordVO customerVisitRecordVO);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param visitrecord_id
     * @return
     */
    public Result deleteCustomerVisitRecordById(int visitrecord_id);

	/**
	 * 根据客户id返回关于客户的沟通记录
	 * @param customerId
	 * @return
	 */
	public Result<List<VisitRecordVO>> getCustomerVisitRecordByCustomerId(String customerId);

	/**
	 * 根据联系人id返回关于联系人的沟通记录
	 * @param linkmanId
	 * @return
	 */
	public Result<List<VisitRecordVO>> getCustomerVisitRecordByLinkmanId(String linkmanId);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryCustomerVisitRecord
     * @return
     */
    public Result<List<CustomerVisitRecord>> getCustomerVisitRecordsByQuery(QueryCustomerVisitRecord queryCustomerVisitRecord);

    /**
     * 通过主键id查询CustomerVisitRecord
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条customerVisitRecord信息
     * @param visitrecord_id
     * @return
     */
    public Result<CustomerVisitRecordLinkman> getCustomerVisitRecordById(int visitrecord_id);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryCustomerVisitRecord
     * @return
     */
    public Result<List<QueryCustomerVisitRecord>> getCustomerVisitRecordsByPage(QueryCustomerVisitRecord queryCustomerVisitRecord);

    /**
     * 查询总数
     * @param queryCustomerVisitRecord
     * @return
     */
    public Result<Integer> count(QueryCustomerVisitRecord queryCustomerVisitRecord);
	
}