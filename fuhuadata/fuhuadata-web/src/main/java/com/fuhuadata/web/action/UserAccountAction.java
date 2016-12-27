package com.fuhuadata.web.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.UserAccountQuery;
import com.fuhuadata.service.UserAccountService;
import com.fuhuadata.web.util.BaseAction;

public class UserAccountAction extends BaseAction{
	private final static Log log = LogFactory.getLog(UserAccountAction.class);
	private static final long serialVersionUID = -7103831402883881403L;
	private UserAccountService userAccountService;
	private Integer id;
	private String name;
	private Integer pageSize = 10;
	private String page = "1";
	/**
	 * 用户列表
	 * @return
	 */
	public String userAccountList(){
		try{
			UserAccountQuery query = new UserAccountQuery();
			query.setPageSize(pageSize);
			try{				
				query.setIndex(Integer.valueOf(page.trim()));
			}catch(Exception e){
				query.setIndex(1);				
			}
			Result<List<UserAccount>>  result = userAccountService.getUserAccountsByPage(query);
			toVm(result);
		}catch(Exception e){
			//打印日志
		}
		return SUCCESS;
	}
	
	/**
	 * 添加用户信息
	 * @return
	 */
	public String addUserAccount(){
		try{
			Result<UserAccount>  result = userAccountService.getUserAccountById(id);
			toVm(result);
		}catch(Exception e){
			//打印日志
		}
		return SUCCESS;
	}
	
	/***
	 * 执行添加操作
	 * @return
	 */
	public String doAddUserAccount(){
		try{
			UserAccount userAccount = new UserAccount();
			userAccount.setName(name);
			Result<UserAccount>  result = userAccountService.addUserAccount(userAccount);
			if(result.getSuccess()){
				sendAjaxMsg(1,"成功");
			}else{
				sendAjaxMsg(0,"失败");
			}
		}catch(Exception e){
			//打印日志
			sendAjaxMsg(0,"失败");
		}
		return SUCCESS;
	}
	
	/**
	 * 编辑用户信息
	 * @return
	 */
	public String modifyUserAccount(){
		try{
			Result<UserAccount>  result = userAccountService.getUserAccountById(id);
			toVm(result);
		}catch(Exception e){
			//打印日志
		}
		return SUCCESS;
	}
	
	/***
	 * 执行修改操作
	 * @return
	 */
	public String doModifyUserAccount(){
		try{
			UserAccount userAccount = new UserAccount();
			userAccount.setName(name);
			Result<UserAccount>  result = userAccountService.updateUserAccountById(id, userAccount);
			if(result.getSuccess()){
				sendAjaxMsg(1,"成功");
			}else{
				sendAjaxMsg(0,"失败");
			}
		}catch(Exception e){
			//打印日志
			sendAjaxMsg(0,"失败");
		}
		return SUCCESS;
	}
	
	/**
	 * 删除用户信息
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String deleteUserAccount(){
		try{
			Result result = userAccountService.deleteUserAccountById(id);
			if(result.getSuccess()){
				sendAjaxMsg(1,"成功");
			}else{
				sendAjaxMsg(0,"失败");
			}
		}catch(Exception e){
			//打印日志
			sendAjaxMsg(0,"失败");
		}
		return null;
	}
	
	public UserAccountService getUserAccountService() {
		return userAccountService;
	}
	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
}
