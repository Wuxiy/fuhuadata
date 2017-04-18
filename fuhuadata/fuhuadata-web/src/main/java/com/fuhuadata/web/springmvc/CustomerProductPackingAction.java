package com.fuhuadata.web.springmvc;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerProductArchivesService;
import com.fuhuadata.vo.CustomerProductPackagingArchives;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
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

    /**
     * 客户产品包装要求列表
     * @return
     */
    @RequiresPermissions({"wiki:pack:view"})
    @SuppressWarnings("unused")
    @RequestMapping(value="/customerProductPackingList",method= RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerProductPackaging  ",methods = "into")
    public ModelAndView customerProductPackingList(){
        return new ModelAndView("knowledgeBase/customerProductPackingList");
    }

    /**
     * 新增客户产品包装详情
     * @return
     */
    @RequestMapping(value="/infocustomerProductPacking",method=RequestMethod.GET)
    public ModelAndView infocustomerProductPacking(){return new ModelAndView("knowledgeBase/customerProductPackingInfo");}

    @RequestMapping(value = "/queryCustomerProductPackingList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerProductPackaging",methods = "list")
    @ResponseBody
    public ResultPojo getCustomerProductPackagingArchives() {
        try {
            Result<List<CustomerProductPackagingArchives>> result = customerProductInfoService.getCustomerProductPackagingArchives();
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("获取客户产品包装要求错误",e);
        }
        return null;
    }


    /**
     *客户信息页面客户产品要求
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value="/intoCustomerProductInfo",method= RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerProductPackaging  ",methods = "into")
    public ModelAndView intoCustomerProductInfo(String customerId,String customerType,String fullName){
        return new ModelAndView("customerInfo/customerProductRequest")
                .addObject("customerType",customerType)
                .addObject("fullName",fullName)
                .addObject("customerId",customerId);
    }


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


}
