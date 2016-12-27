package com.fuhuadata.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.UserAccountQuery;
import com.fuhuadata.manager.UserAccountManager;
import com.fuhuadata.service.UserAccountService;
public class UserAccountServiceImpl implements UserAccountService{
	private final static Log log = LogFactory.getLog(UserAccountServiceImpl.class);
	private UserAccountManager userAccountManager;

	/**
	 * 新增 userAccount 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到新增 userAccount
	 * 
	 * @param userAccount
	 * @return
	 */
	public Result<UserAccount> addUserAccount(UserAccount userAccount) {
		Result<UserAccount> result = new Result<UserAccount>();
		try {
			result.addDefaultModel(userAccountManager.addUserAccount(userAccount));
		} catch (Exception e) {
			result.setSuccess(false);
			// 打印日志
			log.error("添加用户信息错误",e);
		}
		return result;
	}

	/**
	 * 按照主键id更新userAccount，请重新new UserAccount 的更新对象，设置要更新的字段
	 * 返回result，通过result.isSuccess()判断更新是否成功
	 * 
	 * @param id
	 * @param userAccount
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Result updateUserAccountById(int id, UserAccount userAccount) {
		Result result = new Result();
		try {
			result.setSuccess(userAccountManager.updateUserAccountById(id, userAccount));
		} catch (Exception e) {
			result.setSuccess(false);
			// 打印日志
			log.error("修改用户信息错误",e);
		}
		return result;
	}

	/**
	 * 按照主键id 删除 记录 返回result，通过result.isSuccess()判断删除是否成功
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Result deleteUserAccountById(int id) {
		Result result = new Result();
		try {
			result.setSuccess(userAccountManager.deleteUserAccountById(id));
		} catch (Exception e) {
			result.setSuccess(false);
			// 打印日志
			log.error("根据id删除用户信息错误",e);
		}
		return result;
	}

	/**
	 * 返回数据库所有记录，谨慎使用，最好不用
	 * 
	 * @return
	 */
	public List<UserAccount> getAllUserAccounts() {
		return userAccountManager.getAllUserAccounts();
	}

	/**
	 * 查询列表，此接口不包含分页查询 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到列表信息
	 * 
	 * @param userAccountQuery
	 * @return
	 */
	public Result<List<UserAccount>> getUserAccountsByQuery(UserAccountQuery userAccountQuery) {
		Result<List<UserAccount>> result = new Result<List<UserAccount>>();
		try {
			result.addDefaultModel("UserAccounts", userAccountManager.getUserAccountsByQuery(userAccountQuery));
		} catch (Exception e) {
			result.setSuccess(false);
			// 打印日志
			log.error("查询用户信息错误",e);
		}
		return result;
	}

	/**
	 * 通过主键id查询UserAccount 返回result，通过result.isSuccess()判断服务调用是否成功
	 * 通过result.getModel()得到查询的单条UserAccount信息
	 * 
	 * @param id
	 * @return
	 */
	public Result<UserAccount> getUserAccountById(int id) {
		Result<UserAccount> result = new Result<UserAccount>();
		try {
			UserAccount userAccount = userAccountManager.getUserAccountById(id);
			if(userAccount == null){
				result.setSimpleErrorMsg(0, "当前用户数据不存在，请重试");
			}else{
				result.addDefaultModel("UserAccount", userAccount);
			}
		} catch (Exception e) {
			result.setSuccess(false);
			// 打印日志
			log.error("根据id获取用户信息错误",e);
		}
		return result;
	}

	/**
	 * 查询列表，包含分页查询 查询分页信息，请设置 Query(设置当前页数) Query(设置当前页面数据行数)
	 * 返回result，通过result.isSuccess()判断服务调用是否成功 通过result.getTotal()返回结果总数
	 * 通过result.getModel()得到查询的单页列表信息
	 * 
	 * @param userAccountQuery
	 * @return
	 */
	public Result<List<UserAccount>> getUserAccountsByPage(UserAccountQuery userAccountQuery) {
		Result<List<UserAccount>> result = new Result<List<UserAccount>>();
		try {
			result = userAccountManager.getUserAccountsByPage(userAccountQuery);
		} catch (Exception e) {
			result.setSuccess(false);
			// 打印日志
			log.error("分页获取用户信息错误",e);
		}
		return result;
	}

	/**
	 * 查询总数
	 * 
	 * @param userAccountQuery
	 * @return
	 */
	public Result<Integer> count(UserAccountQuery userAccountQuery) {
		Result<Integer> result = new Result<Integer>();
		try {
			result.addDefaultModel(userAccountManager.count(userAccountQuery));
		} catch (Exception e) {
			result.setSuccess(false);
			// 打印日志
			log.error("查询用户信息数量错误",e);
		}
		return result;
	}

	public UserAccountManager getUserAccountManager() {
		return userAccountManager;
	}

	public void setUserAccountManager(UserAccountManager userAccountManager) {
		this.userAccountManager = userAccountManager;
	}

}
