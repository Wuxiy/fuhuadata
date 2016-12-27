package com.fuhuadata.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.fuhuadata.dao.UserAccountDao;
import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.UserAccountQuery;
import com.fuhuadata.manager.UserAccountManager;

public class UserAccountManagerImpl implements UserAccountManager{
	private UserAccountDao userAccountDao;
	/**
	 * 新增 userAccount,返回userAccount对象(设置了新生成id)
	 * @param userAccount
	 * @return
	 */
	public UserAccount addUserAccount(UserAccount userAccount) {
		return userAccountDao.addUserAccount(userAccount);
	}

	/**
     * 通过主键id查询UserAccount
	 * 查询不到返回NULL值
     * @param id
     * @return
     */	
	public UserAccount getUserAccountById(int id) {
		return userAccountDao.getUserAccountById(id);
	}

	 /**
     * 按照主键id更新userAccount，请重新new UserAccount 的更新对象，设置要更新的字段
	 * 成功返回true，失败返回false
     * @param id
     * @param userAccount
     * @return
     */
	public boolean updateUserAccountById(int id, UserAccount userAccount) {
		return userAccountDao.updateUserAccountById(id, userAccount) == 1 ? true : false;
	}

	 /**
     * 按照主键id 删除 记录
	 * 成功返回true，失败返回false
     * @param id
     * @return
     */
	public boolean deleteUserAccountById(int id) {
		return userAccountDao.deleteUserAccountById(id) == 1 ? true : false;
	}

	 /**
     * 返回数据库所有记录，谨慎使用，最好不用
     * @return
     */
	public List<UserAccount> getAllUserAccounts() {
		return userAccountDao.getAllUserAccounts();
	}

	/**
     * 查询列表，此接口不包含分页查询，查询结果为空返回空的List对象
     * @param userAccountQuery
     * @return
     */   
	public List<UserAccount> getUserAccountsByQuery(UserAccountQuery userAccountQuery) {
		return userAccountDao.getUserAccountsByQuery(userAccountQuery);
	}

	 /**
     * 查询列表，包含分页查询，
	 * 查询分页信息，请设置
	 * Query(设置当前页数)
	 * Query(设置当前页面数据行数)
	 * 返回Result中，可以通过result.getTotal()返回结果总数，
	 * result中包装了分页需要的信息，和当前列表
     * @param userAccountQuery
     * @return
     */
	public Result<List<UserAccount>> getUserAccountsByPage(UserAccountQuery userAccountQuery) {
		Result<List<UserAccount>> result = new Result<List<UserAccount>>();
		int totalItem = userAccountDao.count(userAccountQuery);
		userAccountQuery.setTotalItem(totalItem);
		if (totalItem > 0) {
			result.addDefaultModel("UserAccounts", userAccountDao.getUserAccountsByQuery(userAccountQuery));		
		} else {
			result.addDefaultModel("UserAccounts", new ArrayList<UserAccount>());
		}
		
		result.setPageSize(userAccountQuery.getPageSize());
		result.setIndex(userAccountQuery.getIndex());
		result.setTotalItem(totalItem);
		
		return result;
	}

	/**
     * 查询总数
     * @param userAccountQuery
     * @return
     */
	public int count(UserAccountQuery userAccountQuery) {
		return userAccountDao.count(userAccountQuery);
	}

	public UserAccountDao getUserAccountDao() {
		return userAccountDao;
	}

	public void setUserAccountDao(UserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

}
