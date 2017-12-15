package com.fuhuadata.service.impl;
import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.domain.*;
import com.fuhuadata.manager.CustomerBaseInfoManager;

import java.text.DecimalFormat;
import java.util.*;

import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.CustomerBaseInfoService;
import com.fuhuadata.service.SaleCustomerService;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.vo.CategoryTree;
import com.fuhuadata.vo.CategoryVO;
import com.fuhuadata.vo.CustomerBaseInfoLinkman;
import com.fuhuadata.vo.CustomerBaseInfoVO;
import com.fuhuadata.vo.DataArchive.Countryzone;
import com.fuhuadata.vo.DataArchive.Custclass;
import com.fuhuadata.vo.DataArchive.Formatdoc;
import com.fuhuadata.vo.DataArchive.Timezone;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangbo
 * @date 2017-01-12 11:49:51
 */
public class CustomerBaseInfoServiceImpl implements CustomerBaseInfoService {
	private static final org.apache.commons.logging.Log log = LogFactory.getLog(CustomerBaseInfoServiceImpl.class);

	@Autowired
    private CustomerBaseInfoManager customerBaseInfoManager;

	@Autowired
	private CustomerBaseInfoDao customerBaseInfoDao;

    public Result<CustomerBaseInfo> addCustomerBaseInfo(CustomerBaseInfo customerBaseInfo) {
		Result<CustomerBaseInfo> result = new Result<CustomerBaseInfo>();
		try {
			result.addDefaultModel(customerBaseInfoManager.addCustomerBaseInfo(customerBaseInfo));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }

	@Override
	public Result<CustomerBaseInfoVO> addCustomerBaseInfo(List<CustomerEnterpriceNature> customerEnterpriceNatures, List<CustomerMakeProduct> customerMakeProducts, CustomerBaseInfo customerBaseInfo) {
		Result<CustomerBaseInfoVO> result = new Result<CustomerBaseInfoVO>();
		try {
			//计算百科信息完整度
			calculateCompletion(customerBaseInfo);
			//新增潜在客户默认为客户关系,非竞对关系
			customerBaseInfo.setCompanyType(0);
			//设置操作人信息，临时处理，登录机制做好后更新此处代码
			customerBaseInfo.setCreateUserId(LoginUtils.getLoginId());
			customerBaseInfo.setCreateUserName(LoginUtils.getLoginName());
			customerBaseInfo.setLastmodifyUserId(LoginUtils.getLoginId());
			customerBaseInfo.setLastmodifyUserName(LoginUtils.getLoginName());
			result.addDefaultModel(customerBaseInfoManager.addCustomerBaseInfo(customerEnterpriceNatures,customerMakeProducts,customerBaseInfo));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("新增潜在客户基本信息出错",e);
		}
		return result;
	}
	//计算百科信息完整度
	private void calculateCompletion(CustomerBaseInfo customerBaseInfo){
		int total = 12;//百科页面除了自定义字段外的所有总字段数量
		int complete_num = 0;
		if(StringUtils.isNotBlank(customerBaseInfo.getFullName())){
			complete_num++;
		}
		if(StringUtils.isNotBlank(customerBaseInfo.getShortName())){
			complete_num++;
		}
		if(StringUtils.isNotBlank(customerBaseInfo.getArea())){
			complete_num++;
		}
		if(StringUtils.isNotBlank(customerBaseInfo.getCountryzone())){
			complete_num++;
		}
		if(StringUtils.isNotBlank(customerBaseInfo.getFullEnterpriseNature())){
			complete_num++;
		}
		if(StringUtils.isNotBlank(customerBaseInfo.getRegisteredFunds())){
			complete_num++;
		}
		if(StringUtils.isNotBlank(customerBaseInfo.getRegisteredAddress())){
			complete_num++;
		}
		if(StringUtils.isNotBlank(customerBaseInfo.getManagementScope())){
			complete_num++;
		}
		float num= (float)complete_num*100/total;
		DecimalFormat df = new DecimalFormat("0.00");//格式化小数
		customerBaseInfo.setCustomerCompletion(df.format(num));
	}
	@Override
	public Result updateCustomerBaseInfoById(String customerId, CustomerBaseInfo customerBaseInfo) {
    	Result result = new Result();
    	try{
    		customerBaseInfo.setLastmodifyUserId(LoginUtils.getLoginId());
			customerBaseInfo.setLastmodifyUserName(LoginUtils.getLoginName());
    		result.setSuccess(customerBaseInfoManager.updateCustomerBaseInfoById(customerId,customerBaseInfo));
    		return result;
		}catch(Exception e){
    		result.setSuccess(false);
    		log.error("根据id更新客户最基本信息错误",e);
		}
		return null;
	}

	public Result updateCustomerBaseInfo(List<CustomerEnterpriceNature> customerEnterpriceNatures, List<CustomerMakeProduct> customerMakeProducts , CustomerBaseInfo customerBaseInfo) {
		Result result = new Result();
		try {
            customerBaseInfo.setLastmodifyUserId(LoginUtils.getLoginId());
            customerBaseInfo.setLastmodifyUserName(LoginUtils.getLoginName());
			result.setSuccess(customerBaseInfoManager.updateCustomerBaseInfo(customerEnterpriceNatures,customerMakeProducts,customerBaseInfo));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("根据客户id更新客户信息错误",e);
		}
		return result;
    }

    public Result deleteCustomerBaseInfoById(String customer_id) {
		Result result = new Result();
		try {
			result.setSuccess(customerBaseInfoManager.deleteCustomerBaseInfoById(customer_id));
		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }

    public Result<List<CustomerBaseInfo>> getCustomerBaseInfoByQuery(QueryCustomerBaseInfo queryCustomerBaseInfo) {
		Result<List<CustomerBaseInfo>> result = new Result<List<CustomerBaseInfo>>();
		try {
			result.addDefaultModel("CustomerBaseInfo", customerBaseInfoManager.getCustomerBaseInfoByQuery(queryCustomerBaseInfo));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("条件获取客户列表失败",e);
		}
		return result;
    }

    public Result<CustomerBaseInfo> getCustomerBaseInfoById(String customer_id) {
		Result<CustomerBaseInfo> result = new Result<CustomerBaseInfo>();
		try {
		    CustomerBaseInfo customerBaseInfo = customerBaseInfoManager.getCustomerBaseInfoById(customer_id);
		    if(customerBaseInfo == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerBaseInfo", customerBaseInfo);
			}

		} catch(Exception e) {
			result.setSuccess(false);
		}
		return result;
    }

	@Override
	public Result<CustomerBaseInfoVO> getCustomerInfoById(String id) {
		Result<CustomerBaseInfoVO> result = new Result<CustomerBaseInfoVO>();
		try {
			CustomerBaseInfoVO customerBaseInfoVO = customerBaseInfoManager.getCustomerInfoById(id);
			if(customerBaseInfoVO == null){
				result.setSimpleErrorMsg(0, "当前数据不存在，请重试");
			}else{
				result.addDefaultModel("CustomerBaseInfo", customerBaseInfoVO);
			}

		} catch(Exception e) {
			result.setSuccess(false);
			log.error("客户基本信息显示错误",e);
		}
		return result;
	}

	@Override
	public Result<CustomerBaseInfoLinkman> getCustomerBaseInfoLinkmanByCustomerId(String customerId) {
		Result<CustomerBaseInfoLinkman> result = new Result<CustomerBaseInfoLinkman>();
		try{
			CustomerBaseInfoLinkman customerBaseInfoLinkman = customerBaseInfoManager.getCustomerBaseInfoLinkmanByCustomerId(customerId);
			if(customerBaseInfoLinkman!=null) {
				result.addDefaultModel("CustomerBaseInfoLinkman",customerBaseInfoLinkman );
			}else {
				result.setMessage("无当前客户数据请新增");
			}
		}catch (Exception e){
			result.setSuccess(false);
			log.error("根据客户id获取客户及默认联系人信息出错",e);
		}
		return result;
	}


	public Result<List<CustomerBaseInfo>> getCustomerBaseInfoByPage(QueryCustomerBaseInfo queryCustomerBaseInfo) {
		Result<List<CustomerBaseInfo>> result = new Result<List<CustomerBaseInfo>>();
			try {
			result = customerBaseInfoManager.getCustomerBaseInfoByPage(queryCustomerBaseInfo);
		} catch(Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
    }

    public Result<Integer> count(QueryCustomerBaseInfo queryCustomerBaseInfo) {
		Result<Integer> result = new Result<Integer>();
		try {
			result.addDefaultModel(customerBaseInfoManager.count(queryCustomerBaseInfo));
		} catch(Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;	
    }

	public List<CountCustomersOrderProduct> countOrderProduct(String customerId) {
		return customerBaseInfoManager.countOrderProduct(customerId);
	}

	public CustomerBaseInfo queryCooperationByCid(String customerId) {
		return customerBaseInfoDao.queryCooperationByCid(customerId);
	}

	@Override
	public Result<List<Formatdoc>> getFormatdoc( ) {

		Result<List<Formatdoc>> result = new Result<List<Formatdoc>>();
		try {
			result.addDefaultModel(customerBaseInfoManager.getFormatdoc());
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("获取客户 数据格式档案错误");
		}
		return result;
	}

	@Override
	public Result<List<Countryzone>> getCountryzone(Countryzone countryzone) {
		Result<List<Countryzone>> result = new Result<List<Countryzone>>();
		try {
			result.addDefaultModel(customerBaseInfoManager.getCountryzone(countryzone));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("获取客户 贸易国别档案错误");
		}
		return result;
	}

	@Override
	public Result<List<Timezone>> getTimezone(Timezone timezone) {
		Result<List<Timezone>> result = new Result<List<Timezone>>();
		try {
			result.addDefaultModel(customerBaseInfoManager.getTimezone(timezone));
		} catch(Exception e) {
			result.setSuccess(false);
			log.error("获取客户 时区档案错误");
		}
		return result;
	}

	public Result<List<CategoryTree>> getCustclass() {
		Result<List<CategoryTree>> result=new Result<List<CategoryTree>>();
		try {
			List<CategoryVO> list = customerBaseInfoManager.getCustclass();

			result.addDefaultModel("CategoryTree", getAllNodes(list));
		}catch(Exception e){
			result.setSuccess(false);
			log.error("获取包材目录树错误",e);
		}
		return result;
	}


	/**
	 * map构造tree
	 * @param list,fourNode 为 0 获取三级目录 , 1 为获取三层目录
	 * @return
	 */
	public List<CategoryTree> getAllNodes(List<CategoryVO> list){
		Map<String,CategoryTree> map = new HashMap<String,CategoryTree>();
		List<CategoryTree> root_list = new ArrayList<CategoryTree>();
		try {
			for (CategoryVO vo : list) {
				CategoryTree small = null;
				CategoryTree middle = null;
				CategoryTree big = null;

				if (vo.getChildId() != null) {
						small = new CategoryTree();
						small.setCname(vo.getChildName());
						small.setPid(vo.getMidId());
						small.setCid(vo.getChildId());
						map.put(small.getCid(),small);
				}
				if (vo.getMidId() != null) {
					middle = map.get(vo.getMidId());
					if (middle == null) {
						middle = new CategoryTree();
						middle.setCid(vo.getMidId());
						middle.setCname(vo.getMidName());
						middle.setPid(vo.getParentId());
						if (small != null) {
							middle.addChildNode(small);
						}
					}else{
						//判断当前middle结点是否存在small子节点
						boolean flag=false;
						for(int i=0;i<middle.getNodes().size();i++){
							if(middle.getNodes().get(i).getCid()==small.getCid()){
								flag=true;
							}
						}
						if(flag==false){
							middle.addChildNode(small);
						}
					}
					map.put(middle.getCid(), middle);
				}

				big = map.get(vo.getParentId());
				if (big == null) {
					big = new CategoryTree();
					big.setCid(vo.getParentId());
					big.setPid("0");
					big.setCname(vo.getParentName());
					if (middle != null) {
						big.addChildNode(middle);
					}
				}else{
					//判断当前头结点是否存在middle子节点
					boolean flag=false;
					for(int i=0;i<big.getNodes().size();i++){
						if(big.getNodes().get(i).getCid()==middle.getCid()){
							flag=true;
						}
					}
					if(flag==false){
						big.addChildNode(middle);
					}

				}
				map.put(big.getCid(), big);
			}

			Set<Map.Entry<String, CategoryTree>> entrys = map.entrySet();
			for (Map.Entry<String, CategoryTree> entry : entrys) {
				if ("0".equals(entry.getValue().getPid())){
					root_list.add(entry.getValue());
				}
			}
		}catch(Exception e){
			log.error("获取客户基本分类",e);
		}
		return root_list;
	}

	public Result<String> checkCustByName(String custName){
		Result<String> result=new Result<String>();
		Integer res= customerBaseInfoDao.checkNewCustName(custName);
		if (res==1){
			result.setSuccess(false);
			result.setMessage(custName+"-对应的客户已存在");
		}else if (res ==0){
			result.setSuccess(true);
		}
		return result;
	};
}