package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerEncyclopedia;
import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerEncyclopediaService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import oracle.jrockit.jfr.events.RequestableEventEnvironment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 客户百科action
 * Created by wuxi on 2017/1/16.
 */
@Controller
@RequestMapping("/customerEncyclopedia/*")
public class CustomerEncyclopediaAction {
    private final static Log log = LogFactory.getLog(CustomerEncyclopediaAction.class);
    @Resource
    private CustomerEncyclopediaService customerEncyclopediaService;
    private Integer pageSize=5;
    private String page="1";

    /**
     * 百科列表
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/customerEncyclopediaList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-企业百科",methods = "百科列表")
    public ModelAndView customerEncyclopediaList(){
        Result<List<CustomerEncyclopedia>> result = new Result<List<CustomerEncyclopedia>>();
        try{
            CustomerEncyclopediaQuery query = new CustomerEncyclopediaQuery();
            query.setPageSize(pageSize);
            try{
                query.setIndex(Integer.valueOf(page.trim()));
            }catch(Exception e){
                query.setIndex(1);
            }
            result=customerEncyclopediaService.getCustomerEncyclopediasByPage(query);
        }catch(Exception e){
            log.error("获取企业百科列表失败",e);
        }

        ModelAndView model= new ModelAndView("knowledgeBase/encyclopediaList","customerEncyclopedias",result.getModel());
        model.addObject("message","企业百科列表");
        return model;
    }
    @RequestMapping(value = "/addCustomerEncyclopedia",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-企业百科",methods = "新增企业百科")
    public ModelAndView addCustomerEncyclopedia(){
        return new ModelAndView("knowledgeBase/addCustomerEncyclopedia");
    }

    /**
     * 新增
     * @param customerEncyclopedia
     * @return
     */
    @RequestMapping(value = "/doAddCustomerEncyclopedia",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-客户百科",methods = "执行新增")
    @ResponseBody
     public ResultPojo doAddCustomerEncyclopedia(@RequestBody CustomerEncyclopedia customerEncyclopedia){
        //
        try{
            Result<CustomerEncyclopedia> result = customerEncyclopediaService.addCustomerEncyclopedia(customerEncyclopedia);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("添加客户百科信息失败",e);
        }
        return null;
    }

    /**
     * 条件查询
     * @param customerEncyclopediaQuery
     * @return
     */
    @RequestMapping(value = "/queryCustomerEncyclopediaList",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-客户百科",methods = "条件查询")
    public ModelAndView queryCustomerEncyclopediaList(@RequestBody CustomerEncyclopediaQuery customerEncyclopediaQuery){
         Result<List<CustomerEncyclopedia>> result = new Result<List<CustomerEncyclopedia>>();
         try{
             customerEncyclopediaQuery.setPageSize(pageSize);
             if(customerEncyclopediaQuery.getIndex()==0){
                 customerEncyclopediaQuery.setIndex(Integer.valueOf(page.trim()));
             }
             result=customerEncyclopediaService.getCustomerEncyclopediasByPage(customerEncyclopediaQuery);
         }catch(Exception e){
             log.error("条件查询客户百科失败",e);
         }
         ModelAndView model = new ModelAndView("knowledgeBase/customerEncyclopediaList","customerEncyclopedias",result.getModel());
         model.addObject("message","客户百科列表");
         return model;
    }

}
