package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.FreightCost;
import com.fuhuadata.domain.query.FreightCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerProductArchivesService;
import com.fuhuadata.service.FreightCostService;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.vo.CustomerProductPackagingArchives;
import com.fuhuadata.web.util.CustomerUtils;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
/**
 * 客户产品要求action
 * Created by wuxi on 2017/1/13.
 */

@Controller
@RequestMapping("/customerProductPacking/*")
public class CustomerProductPackingAction {

    private final static Log log= LogFactory.getLog(CustomerProductPackingAction.class);

    @Resource
    private CustomerProductArchivesService customerProductInfoService;

    @Autowired
    private FreightCostService freightCostService;

    /**
     * 客户产品包装要求列表
     * @return
     */
    @RequestMapping(value="/customerProductPackingList",method= RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerProductPackaging  ",methods = "into")
    public ModelAndView customerProductPackingList(){
        FreightCostQuery freightCostQuery = new FreightCostQuery();
        List<FreightCost> list = freightCostService.getFreightCostsByPage(freightCostQuery).getModel();
        return new ModelAndView("knowledgeBase/customerProductPackingList").addObject("freightCosts",list);
    }

    /**
     * 新增客户产品包装详情
     * @return
     */
    @RequestMapping(value="/infocustomerProductPacking",method=RequestMethod.GET)
    public ModelAndView infocustomerProductPacking(){return new ModelAndView("knowledgeBase/customerProductPackingInfo");}

    /**
     * 知识库，客户产品包装要求前端分页
     * @return
     */
    @RequestMapping(value = "/queryCustomerProductPackingList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerProductPackaging",methods = "list")
    @ResponseBody
    public ResultPojo getCustomerProductPackagingArchives() {
        try {
            CustomerProductPackagingArchives customerProductPackagingArchives = new CustomerProductPackagingArchives();

            Result<List<CustomerProductPackagingArchives>> result = customerProductInfoService.getCustomerProductPackagingArchives(customerProductPackagingArchives);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("获取客户产品包装要求列表错误",e);
        }
        return null;
    }


    /**
     * 知识库，客户产品包装要求后端分页
     * @return
     */
    @RequestMapping(value = "/getCustomerProductPackingByPage",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-customerProductPackaging",methods = "list")
    @ResponseBody
    public ResultPojo getCustomerProductInfoByQuery(@RequestBody  CustomerProductPackagingArchives customerProductPackagingArchives) {
        try {
            Result<List<CustomerProductPackagingArchives>> result = customerProductInfoService.getCustomerProductPackagingArchives(customerProductPackagingArchives);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("获取客户产品包装要求列表错误",e);
        }
        return null;
    }

    /**
     * 知识库，客户产品包装要求count
     * @return
     */
    @RequestMapping(value = "/countCustomerProductPackingByPage",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-customerProductPackaging",methods = "list")
    @ResponseBody
    public ResultPojo countCustomerProductInfoByQuery(@RequestBody CustomerProductPackagingArchives customerProductPackagingArchives) {
        try {
            Result<Integer> result = customerProductInfoService.countCustomerProductPackagingArchives(customerProductPackagingArchives);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("获取客户产品包装要求数量错误",e);
        }
        return null;
    }

    /**
     *客户信息页面客户产品要求
     * @return
     */
    @RequestMapping(value="/intoCustomerProductInfo",method= RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerProductPackaging  ",methods = "into")
    public ModelAndView intoCustomerProductInfo(String customerId,String customerType,String fullName){

        Subject subject = LoginUtils.getSubject();
        subject.checkPermission(CustomerUtils.getCustomerPermissonPrefix(customerType) + ":prod:view");

        return new ModelAndView("customerInfo/customerProductRequest")
                .addObject("customerType",customerType)
                .addObject("fullName",fullName)
                .addObject("customerId",customerId);
    }

    /**
     *  客户信息产品要求列表
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/getCustomerProductInfoById",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerProductPackaging",methods = "getCustomerProductInfoById")
    @ResponseBody
    public ResultPojo getCustomerProductInfoById(String customerId) {
        try {
            Result<List<CustomerProductPackagingArchives>> result = customerProductInfoService.getCustomerProductPackagingArchivesById(customerId);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("获取客户产品包装要求错误",e);
        }
        return null;
    }

    /**
     * 百科和客户产品要求-客户商品名详情页
     * @return
     */
    @RequestMapping(value="/intoCustomerProductInfoDetails",method= RequestMethod.GET)
    @SystemLogAnnotation(module = "customerProductPackaging  ",methods = "into")
    public ModelAndView intoCustomerProductInfoDetails(int id){
        Result<CustomerProductPackagingArchives> result = customerProductInfoService.getCustomerProductIds(id);
        CustomerProductPackagingArchives cppa = result.getModel();
        if(cppa !=null) {
            return new ModelAndView("salesStatistics/productProcCompRequire").addObject("orderId", cppa.getOrderId()).addObject("businessProductId", cppa.getBusinessProductId()).
                    addObject("productRequireId", cppa.getBusinessRequireId()).addObject("edit", 2);
        }
        else return new ModelAndView("salesStatistics/productProcCompRequire");
    }






}
