package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerEncyclopedia;
import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerEncyclopediaService;
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
    private Integer pageSize=5;
    private String page="1";

    @SuppressWarnings("unused")
    @RequestMapping(value = "/customerEncyclopediaList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "into")
    public ModelAndView customerEncyclopedia(){
        return new ModelAndView("knowledgeBase/customerEncyclopediaList");
    }

    /**
     * list
     * @return
     */
    @RequestMapping(value = "/customerEncyclopediaList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "list")
    @ResponseBody
    public ResultPojo customerEncyclopediaList(){
        Result<List<CustomerEncyclopedia>> result = new Result<List<CustomerEncyclopedia>>();
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
    @SystemLogAnnotation(module = "知识库-企业百科",methods = "add")
    public ModelAndView addCustomerEncyclopedia(){
        return new ModelAndView("knowledgeBase/addCustomerEncyclopedia");
    }

    @RequestMapping(value = "/doAddCustomerEncyclopedia",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-客户百科",methods = "doAdd")
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



}
