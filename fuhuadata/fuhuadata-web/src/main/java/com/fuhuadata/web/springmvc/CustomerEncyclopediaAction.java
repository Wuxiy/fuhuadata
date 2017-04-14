package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerEncyclopedia;
import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerEncyclopediaService;
import com.fuhuadata.vo.CustomerEncyVO;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
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


    @SuppressWarnings("unused")
    @RequestMapping(value = "/customerEncyclopediaList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "into")
    public ModelAndView customerEncyclopedia(){
        return new ModelAndView("knowledgeBase/encyclopediaList");
    }

    /**
     * list
     * @return
     */
    @RequestMapping(value = "/queryCustomerEncyclopediaList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "list")
    @ResponseBody
    public ResultPojo customerEncyclopediaList(){
        Result<List<CustomerEncyVO>> result = new Result<List<CustomerEncyVO>>();
        try{
            CustomerEncyclopediaQuery query = new CustomerEncyclopediaQuery();
            result=customerEncyclopediaService.getCustomerEncyclopediaByQuery(query);
        }catch(Exception e){
            log.error("获取企业百科列表失败",e);
        }
        return result.getResultPojo();
    }

    /**
     * add
     * @return
     */
    @RequestMapping(value = "/addCustomerEncyclopedia",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "add")
    public ModelAndView addCustomerEncyclopedia(){
        return new ModelAndView("knowledgeBase/customerEncyclopediaAdd");
    }

    @RequestMapping(value = "/doAddCustomerEncyclopedia",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "doAdd")
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

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "delete")
    @ResponseBody
    public ResultPojo delete(String id){
         try{
             Result result = customerEncyclopediaService.deleteCustomerEncyclopediaById(id);
             return result.getResultPojo();
        }catch(Exception e){
             log.error("根据ID删除客户百科信息错误",e);
         }
         return null;
    }

    /**
     * 进入详情页编辑
     * @param
     * @return
     */
    @RequestMapping(value = "/modify",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "doUpdate")
    public ModelAndView update(String encyId){
        return new ModelAndView("knowledgeBase/encyclopediaInfo").addObject("customerId",encyId);

    }

    /**
     * 更新百科信息
     * @param customerEncyclopedia
     * @return
     */
    @RequestMapping(value = "/doModify",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "doUpdate")
    @ResponseBody
    public ResultPojo update(@RequestBody CustomerEncyclopedia customerEncyclopedia){
        try{
            String id =customerEncyclopedia.getEncyId();
            Result result = customerEncyclopediaService.updateCustomerEncyclopediaById(id,customerEncyclopedia);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id更新客户信息错误",e);
        }
        return null;
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "GET-BY-ID")
    @ResponseBody
    public ResultPojo getById(String encyId){
        try{
            Result<CustomerEncyclopedia> result = customerEncyclopediaService.getCustomerEncyclopediaById(encyId);
<<<<<<< HEAD
=======

>>>>>>> 6467016cb736b6b3245b292e2ef52df9b057a7c5
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据ID获取客户百科信息错误",e);
        }
        return null;
    }





}
