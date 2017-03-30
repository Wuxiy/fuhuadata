package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.CustomerEnterpriceNature;
import com.fuhuadata.domain.CustomerMakeProduct;
import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerAreaService;
import com.fuhuadata.service.CustomerBaseInfoService;
import com.fuhuadata.service.CustomerMakeProductService;
import com.fuhuadata.vo.CategoryTree;
import com.fuhuadata.vo.CustomerBaseInfoVO;
import com.fuhuadata.vo.CustomerBaseInfoDO;
import com.fuhuadata.web.util.SystemLogAnnotation;
import com.thoughtworks.xstream.core.util.CustomObjectInputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.org.eclipse.jdt.internal.compiler.ast.ArrayReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hexingfu on 2017/3/8.
 */
@Controller
@RequestMapping("/customerBaseInfo/*")
public class CustomerBaseInfoAction {

    private final static Log log = LogFactory.getLog(CustomerBaseInfoAction.class);

    @Resource
    private CustomerBaseInfoService customerBaseInfoService;
    @Autowired
    private CustomerAreaService  customerAreaService;
    @Autowired
    private CustomerMakeProductService customerMakeProductService;

    /**
     * 客户信息列表页入口
     * @param  customerType 1:合作 2:潜在 3:流失
     * @return
     */
    @RequestMapping("/customerListPageInit")
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "customerListPageInit")
    public ModelAndView init(Integer customerType){
        if(customerType==1){
            return new ModelAndView("customerInfo/customerList").addObject("customerType",customerType);
        }else if(customerType==2){
            return new ModelAndView("customerInfo/customerPotentialList").addObject("customerType",customerType);
        }else if(customerType==3){
            return new ModelAndView("customerInfo/customerRunOffList").addObject("customerType",customerType);
        }
        return null;
    }
    @ResponseBody
    @RequestMapping(value = "/initAreaCategoryTree",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "initAreaCategoryTree")
    public ResultPojo initAreaCategoryTree(){
        try{
            Result<List<CategoryTree>> result = customerAreaService.getAllCustomerAreaList();
            return result.getResultPojo();
        }catch (Exception e){

            log.error("初始化客户地区目录树失败",e);
        }
        return null;
    }


    @RequestMapping(value = "/countCustomerList",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "countCustomerList")
    @ResponseBody
    public ResultPojo countCustomerList( QueryCustomerBaseInfo queryCustomerBaseInfo){
        try{
            Result<Integer> result = customerBaseInfoService.count(queryCustomerBaseInfo);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("统计客户列表总条目数失败",e);
        }
        return null;
    }

    @RequestMapping(value = "/queryCustomerPageList",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "queryCustomerPageList")
    @ResponseBody
    public ResultPojo queryCustomerPageList(QueryCustomerBaseInfo queryCustomerBaseInfo){
        try{
            Result<List<CustomerBaseInfo>> result = customerBaseInfoService.getCustomerBaseInfoByPage(queryCustomerBaseInfo);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("查询客户列表数据失败",e);
        }
        return null;
    }

    @RequestMapping(value = "/showCustomerOrderProductDetail",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "showCustomerOrderProductDetail")
    @ResponseBody
    public ResultPojo showCustomerOrderProductDetail(String customerId){
        try{
            ResultPojo pojo = new  ResultPojo();
            pojo.setData(customerBaseInfoService.countOrderProduct(customerId));
            return pojo;
        }catch (Exception e){
            log.error("统计客户购买产品列表明细失败",e);
        }
        return null;
    }

    @RequestMapping(value = "/showCustomerBaseInfo",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "showCustomerBaseInfo")
    public ModelAndView showCustomerBaseInfo(Integer customerType){
        if(customerType==1){
            return new ModelAndView("customerInfo/customerDetails").addObject("customerType",customerType);
        }else if(customerType==2){
            return new ModelAndView("customerInfo/customerDetails").addObject("customerType",customerType);
        }else if(customerType==3){
            return new ModelAndView("customerInfo/customerDetails").addObject("customerType",customerType);
        }
        return null;
    }




    /**
     * 进入详情页
     * @param
     * @return
     */
    @RequestMapping(value = "/intoCustomerBaseInfoDetails",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "intoCostomerBaseInfoDetails")
    public ModelAndView intoCustomerBaseInfoDetails(String customerId,String customerType,String fullName){
        if(customerId==null || customerId.trim().equals("")){
            customerId = "";
        }
        ModelAndView model = new ModelAndView("customerInfo/customerBasicInfo").addObject("customerId",customerId)
                .addObject("customerType",customerType)
                .addObject("fullName",fullName);
        return model;
    }

    /**
     * 客户基本信息详情
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/showCustomerBaseInfoDetails",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "showCostomerBaseInfoDetails")
    @ResponseBody
    public ResultPojo showCustomerBaseInfoDetails(String customerId){
        Result<CustomerBaseInfoVO> result = new Result<CustomerBaseInfoVO>();
        try{
            result=customerBaseInfoService.getCustomerInfoById(customerId);
        }catch (Exception e){
            result.setSuccess(false);
            log.error("获取客户基本信息错误",e);
        }
        return result.getResultPojo();
    }


    /**
     * update
     * @param
     * @return
     */
    @RequestMapping(value = "/updateCustomerBaseInfo",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "updateCustomerBaseInfo")
    @ResponseBody
    public ResultPojo updateCustomerBaseInfo(@RequestBody CustomerBaseInfoDO customerBaseInfoDO){
        Result result = new Result();
        CustomerBaseInfo customerBaseInfo = customerBaseInfoDO.getCustomerBaseInfo();

        CustomerMakeProduct[] customerMakeProducts = customerBaseInfoDO.getCustomerMakeProducts();
        CustomerEnterpriceNature[] customerEnterpriceNatures = customerBaseInfoDO.getCustomerEnterpriceNatures();
        try{
            List<CustomerEnterpriceNature> list1 = new ArrayList<CustomerEnterpriceNature>();
            if(customerEnterpriceNatures!=null&&customerEnterpriceNatures.length>0) {
                list1=Arrays.asList(customerEnterpriceNatures);
            }
            List<CustomerMakeProduct> list2 = new ArrayList<CustomerMakeProduct>();
            if(customerMakeProducts !=null && customerMakeProducts.length>0){
               list2= Arrays.asList(customerMakeProducts);
            }
            result =  customerBaseInfoService.updateCustomerBaseInfo(list1,list2,customerBaseInfo);
            }catch(Exception e){
                result.setSuccess(false);
                log.error("更新客户信息错误");
            }
            return result.getResultPojo();
    }

    /**
     * doAdd,潜在客户新增
     * @param
     * @return
     */
    @RequestMapping(value = "/doAddCustomerBaseInfo",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "doAddCustomerBaseInfo")
    @ResponseBody
    public ResultPojo doAddCustomerBaseInfo(@RequestBody CustomerBaseInfoDO customerBaseInfoDO){
        Result result = new Result();
        CustomerBaseInfo customerBaseInfo = customerBaseInfoDO.getCustomerBaseInfo();
        CustomerMakeProduct[] customerMakeProducts = customerBaseInfoDO.getCustomerMakeProducts();
        CustomerEnterpriceNature[] customerEnterpriceNatures = customerBaseInfoDO.getCustomerEnterpriceNatures();
        try{
            List<CustomerEnterpriceNature> list1 = new ArrayList<CustomerEnterpriceNature>();
            if(customerEnterpriceNatures!=null&&customerEnterpriceNatures.length>0) {
                list1=Arrays.asList(customerEnterpriceNatures);
            }
            List<CustomerMakeProduct> list2 = new ArrayList<CustomerMakeProduct>();
            if(customerMakeProducts !=null && customerMakeProducts.length>0){
                list2= Arrays.asList(customerMakeProducts);
            }
            result =  customerBaseInfoService.addCustomerBaseInfo(list1,list2,customerBaseInfo);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("新增客户基本信息错误");
        }
        return result.getResultPojo();
    }

}
