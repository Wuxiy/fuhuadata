package com.fuhuadata.web.springmvc;

import java.util.List;

import javax.annotation.Resource;

import com.fuhuadata.web.util.SystemLogAnnotation;
import com.fuhuadata.domain.SaleCustomer;
import com.fuhuadata.domain.query.QuerySaleCustomer;
import com.fuhuadata.service.SaleCustomerService;
import com.fuhuadata.domain.SaleCustomer;
import com.fuhuadata.domain.query.QuerySaleCustomer;
import com.fuhuadata.service.SaleCustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fuhuadata.domain.UserAccount;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.domain.query.UserAccountQuery;
import com.fuhuadata.service.UserAccountService;

@Controller
@RequestMapping("/userAccount/*")
public class UserAccountAction{
	private final static Log log = LogFactory.getLog(UserAccountAction.class);
	@Resource
	private UserAccountService userAccountService;
	@Resource
	private SaleCustomerService saleCustomerService;
	private Integer pageSize = 10;
	private String page = "1";
	/**
	 * 用户列表
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="/userAccountList",method=RequestMethod.GET)
	@SystemLogAnnotation(module = "用户管理",methods = "用户列表")
    public ModelAndView  userAccountList(){
		Result<List<UserAccount>>  result = new Result<List<UserAccount>>();
		try{
			UserAccountQuery query = new UserAccountQuery();
			query.setPageSize(pageSize);
			try{				
				query.setIndex(Integer.valueOf(page.trim()));
			}catch(Exception e){
				query.setIndex(1);				
			}
			result = userAccountService.getUserAccountsByPage(query);
		}catch(Exception e){
			//打印日志
			log.error("获取用户列表错误",e);
		}
		ModelAndView model = new ModelAndView("userAccount/userAccountList","userAccountList",result.getModel());
		model.addObject("defaultObject",result.getResultPojo());
		model.addObject("message","测试数据");
		return model;
    }
	
	/**
	 * 添加用户信息
	 * @return
	 */
	@RequestMapping(value="/addUserAccount",method=RequestMethod.GET)
	public ModelAndView addUserAccount(){
		return new ModelAndView("userAccount/addUserAccount"); 
	}
	
	/***
	 * 执行添加操作
	 * @return
	 */
	@RequestMapping(value="/doAddUserAccount",method=RequestMethod.GET)
	@ResponseBody
	public ResultPojo doAddUserAccount(String name){
		try{
			UserAccount userAccount = new UserAccount();
			userAccount.setName(name);
			Result<UserAccount>  result = userAccountService.addUserAccount(userAccount);
            return result.getResultPojo();
		}catch(Exception e){
			//打印日志
			log.error("添加用户信息错误",e);
		}
		return null; 
	}
	
	/**
	 * 编辑用户信息
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="/modifyUserAccount",method=RequestMethod.GET)
	public ModelAndView modifyUserAccount(int id){
		try{
			Result<UserAccount>  result = userAccountService.getUserAccountById(id);
		}catch(Exception e){
			//打印日志
			log.error("获取用户信息错误",e);
		}
		return new ModelAndView("userAccount/modifyUserAccount"); 
	}
	
	/***
	 * 执行修改操作
	 * @return
	 */
	@RequestMapping(value="/doModifyUserAccount",method=RequestMethod.GET)
	@ResponseBody
	public ResultPojo doModifyUserAccount(int id,String name){
		try{
			UserAccount userAccount = new UserAccount();
			userAccount.setName(name);
			@SuppressWarnings("unchecked")
			Result<UserAccount>  result = userAccountService.updateUserAccountById(id, userAccount);
			return result.getResultPojo();
		}catch(Exception e){
			//打印日志
			log.error("修改用户信息错误",e);
		}
		return null;
	}
	
	/**
	 * 删除用户信息
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/deleteUserAccount",method=RequestMethod.GET)
	@ResponseBody
	public ResultPojo deleteUserAccount(int id){
		try{
			Result result = userAccountService.deleteUserAccountById(id);
			return result.getResultPojo();
		}catch(Exception e){
			//打印日志
			log.error("根据id删除用户信息错误",e);
		}
		return null;
	}
	
	/**
	 * 获取json返回值
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getUserAccountJson")
	@ResponseBody
	 public UserAccount getUserAccountJson(int id){
		try{
			Result<UserAccount>  result = userAccountService.getUserAccountById(id);
			return result.getModel();
		}catch(Exception e){
			//打印日志
			log.error("获取用户信息错误",e);
		}
		return null;
	}
	
	/**
	 * 获取json返回值
	 * @param
	 * @return
	 */
	@RequestMapping(value="/getUserAccountJsonParam")
	@ResponseBody
	public UserAccount getUserAccountJsonParam(@RequestBody UserAccount userAccount){
		try{
			Result<UserAccount>  result = userAccountService.getUserAccountById(userAccount.getId());
			return result.getModel();
		}catch(Exception e){
			//打印日志
			log.error("获取用户信息错误",e);
		}
		return null;
	}
}
