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
     * 百科列表
     * @return
     */
    @SuppressWarnings("unused")
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

    /**
     * 条件查询
     * @param
     * @return
     */
    @RequestMapping(value = "/queryCustomerEncyclopediaList",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-客户百科",methods = "query")
    public ModelAndView queryCustomerEncyclopediaList(String type,String companyName,String index){
        CustomerEncyclopediaQuery customerEncyclopediaQuery = new CustomerEncyclopediaQuery();
         Result<List<CustomerEncyclopedia>> result = new Result<List<CustomerEncyclopedia>>();
         try{
             customerEncyclopediaQuery.setPageSize(pageSize);
             customerEncyclopediaQuery.setType(type);
             customerEncyclopediaQuery.setCompanyName(companyName);
             if(index==null){
                 customerEncyclopediaQuery.setIndex(Integer.valueOf(page.trim()));
             }else{
                 customerEncyclopediaQuery.setIndex(Integer.valueOf(index.trim()));
             }
             result=customerEncyclopediaService.getCustomerEncyclopediasByPage(customerEncyclopediaQuery);
         }catch(Exception e){
             log.error("条件查询客户百科失败",e);
         }
         ModelAndView model = new ModelAndView("knowledgeBase/customerEncyclopediaList","customerEncyclopedias",result.getModel());
         model.addObject("totalItem",result.getTotalItem());//总记录数
         model.addObject("totalPage",result.getTotalPage());//总页数
         model.addObject("query",customerEncyclopediaQuery);//查询条件反写
         model.addObject("message","客户百科列表");
         return model;
    }

}
