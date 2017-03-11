package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.query.QueryCustomerBaseInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerAreaService;
import com.fuhuadata.service.CustomerBaseInfoService;
import com.fuhuadata.vo.CategoryTree;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hexingfu on 2017/3/8.
 */
@Controller
@RequestMapping("/customerBaseInfo/*")
public class CustomerBaseInfoAction {

    private final static Log log = LogFactory.getLog(CustomerBaseInfoAction.class);

    @Autowired
    private CustomerBaseInfoService customerBaseInfoService;
    @Autowired
    private CustomerAreaService  customerAreaService;

    /**
     * 客户信息列表页入口
     * @param  customerType 1:合作 2:潜在 3:流失
     * @return
     */
    @RequestMapping("/customerListPageInit")
    @SystemLogAnnotation(module = "customerInfo-customerList",methods = "customerListPageInit")
    public ModelAndView init(Integer customerType){
        return new ModelAndView("customerInfo/customerList").addObject("customerType",customerType);
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
    public ResultPojo queryCustomerPageList(HttpServletRequest req,QueryCustomerBaseInfo queryCustomerBaseInfo){
        try{
            Result<List<CustomerBaseInfo>> result = customerBaseInfoService.getCustomerBaseInfoByPage(queryCustomerBaseInfo);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("统计客户列表总条目数失败",e);
        }
        return null;
    }

}
