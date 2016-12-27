package com.fuhuadata.dao;
import java.util.List;

import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.UserAccountQuery;
/**
 * 用户账号信息demo
 * @author wangbo
 */
public interface UserAccountDao {
	/**
	 * 新增 userAccount,返回userAccount对象(设置了新生成id)
	 * @param userAccount
	 * @return
	 */
    public UserAccount addUserAccount(UserAccount userAccount);
    
	 /**
     * 按照主键id更新userAccount，成功返回1，使用接口时，请重新new SmyBrand 的更新对象，设置要更新的字段
     * @param id
     * @param userAccount
     * @return
     */
    public int updateUserAccountById(int id, UserAccount userAccount);
    
	 /**
     * 按照主键id 删除 记录，返回1为成功
     * @param id
     * @return
     */
    public int deleteUserAccountById(int id);
    
	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
    public List<UserAccount> getAllUserAccounts();
    
    /**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param userAccountQuery
     * @return
     */
    public List<UserAccount> getUserAccountsByQuery(UserAccountQuery userAccountQuery);
    
    /**
     * 通过主键id查询UserAccount，查询不到返回NULL值
     * @param id
     * @return
     */
    public UserAccount getUserAccountById(int id);
        
	 /**
     * 查询列表，包含分页查询，查询结果为空返回空的List对象
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
     * @param userAccountQuery
     * @return
     */
    public List<UserAccount> getUserAccountsByPage(UserAccountQuery userAccountQuery);
    	
	 /**
     * 查询总数
     * @param userAccountQuery
     * @return
     */
    public int count(UserAccountQuery userAccountQuery);
}
