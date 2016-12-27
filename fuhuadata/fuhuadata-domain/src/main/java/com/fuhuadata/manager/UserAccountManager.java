package com.fuhuadata.manager;
import java.util.List;

import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.UserAccountQuery;
/**
 * 用户账号信息demo
 * @author wangbo
 */
public interface UserAccountManager {
	/**
	 * 新增 UserAccount,返回userAccount对象(设置了新生成id)
	 * @param userAccount
	 * @return
	 */
    public UserAccount addUserAccount(UserAccount userAccount) ;
    
    /**
     * 通过主键id查询UserAccount
	 * 查询不到返回NULL值
     * @param id
     * @return
     */
    public UserAccount getUserAccountById(int id);
    
	 /**
     * 按照主键id更新UserAccount，请重新new UserAccount 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param id
     * @param userAccount
     * @return
     */
    public boolean updateUserAccountById(int id, UserAccount userAccount);
    
   /**
    * 根据主键id删除用户账号
    * @param id
    * @param userAccount
    */
    public boolean deleteUserAccountById(int id);

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
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param querySmyBrand
     * @return
     */
    public Result<List<UserAccount>> getUserAccountsByPage(UserAccountQuery userAccountQuery);

    /**
     * 查询总数
     * @param userAccountQuery
     * @return
     */
    public int count(UserAccountQuery userAccountQuery);
}
