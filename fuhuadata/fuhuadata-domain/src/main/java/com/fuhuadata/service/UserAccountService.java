package com.fuhuadata.service;
import java.util.List;

import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.UserAccountQuery;
/**
 * 用户账号信息demo
 * @author wangbo
 */
public interface UserAccountService {
	/**
	 * 新增 userAccount
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增  userAccount
	 * @param  userAccount
	 * @return
	 */
    public Result<UserAccount> addUserAccount(UserAccount userAccount) ;
 
    /**
     * 按照主键id更新userAccount，请重新new UserAccount 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
     * @param id
     * @param userAccount
     * @return
     */
	@SuppressWarnings("rawtypes")
	public Result updateUserAccountById(int id, UserAccount  userAccount);
    
    /**
     * 按照主键id 删除 记录
	 * 返回result，通过result.isSuccess()判断删除是否成功
     * @param id
     * @return
     */
	@SuppressWarnings("rawtypes")
	public Result deleteUserAccountById(int id);
    
    /**
     * 获取所有发布的品牌数据
     * @return
     */
	public List<UserAccount> getAllUserAccounts();
    
    /**
     * 查询列表，此接口不包含分页查询
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
     * @param userAccountQuery
     * @return
     */
    public Result<List<UserAccount>> getUserAccountsByQuery(UserAccountQuery userAccountQuery);
    
    /**
     * 通过主键id查询UserAccount
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条UserAccount信息
     * @param id
     * @return
     */
    public Result<UserAccount> getUserAccountById(int id);
    
    /**
     * 查询列表，包含分页查询
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
     * @param userAccountQuery
     * @return
     */
    public Result<List<UserAccount>> getUserAccountsByPage(UserAccountQuery userAccountQuery);
    
    /**
     * 查询总数
     * @param userAccountQuery
     * @return
     */
    public Result<Integer> count(UserAccountQuery userAccountQuery);
}
