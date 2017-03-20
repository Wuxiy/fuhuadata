package com.fuhuadata.service;
import java.util.List;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.QueryCustomerLinkman;
import com.fuhuadata.domain.CustomerLinkman;
import com.fuhuadata.vo.CustomerLinkmanVO;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangbo
 * @date 2017-01-13 16:10:56
 */
public interface CustomerLinkmanService {

	/**
	 * 新增 customerLinkman
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 customerLinkman
	 * @param customerLinkman
	 * @return
	 */
    public Result<CustomerLinkman> addCustomerLinkman(CustomerLinkman customerLinkman) ;
 
    /**
     * 按照主键id更新customerLinkman，请重新new CustomerLinkman 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param linkman_id
     * @param customerLinkman
     * @return
     */
    public Result updateCustomerLinkmanById(String linkman_id, CustomerLinkman customerLinkman);

    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param linkman_id
     * @return
     */
    public Result deleteCustomerLinkmanById(String linkman_id);
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param queryCustomerLinkman
     * @return
     */
    public Result<List<CustomerLinkman>> getCustomerLinkmansByQuery(QueryCustomerLinkman queryCustomerLinkman);

    /**
     * 通过主键id查询CustomerLinkman
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条customerLinkman信息
     * @param linkman_id
     * @return
     */
    public Result<CustomerLinkman> getCustomerLinkmanById(String linkman_id);

	/**
	 * 根据联系人id获取详情（包含沟通记录）
	 * @param linkmanId
	 * @return
	 */
	public Result<CustomerLinkmanVO> getCustomerLinkmanDetailsById(String linkmanId);

	/**
	 * 根据客户id查询客户联系人列表
	 * @param customerId
	 * @return
	 */
	public Result<List<CustomerLinkman>> getCustomerLinkmanByCustomerId(String customerId);

	/**
	 * 根据客户id查找客户默认联系人
	 * @param customerId
	 * @return
	 */
	public Result<CustomerLinkman> getCustomerLinkmanDefaultByCustomerId(String customerId);

    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param queryCustomerLinkman
     * @return
     */
    public Result<List<CustomerLinkman>> getCustomerLinkmansByPage(QueryCustomerLinkman queryCustomerLinkman);

    /**
     * 查询总数
     * @param queryCustomerLinkman
     * @return
     */
    public Result<Integer> count(QueryCustomerLinkman queryCustomerLinkman);
	
}