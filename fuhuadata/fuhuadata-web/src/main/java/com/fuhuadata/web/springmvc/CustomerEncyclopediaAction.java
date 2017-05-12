package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerEncyclopedia;
import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerEncyclopediaService;
import com.fuhuadata.service.DataArchivesService;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.vo.CustomerEncyVO;
import com.fuhuadata.vo.DataArchive.Currtype;
import com.fuhuadata.web.exception.InvalidRequestException;
import com.fuhuadata.web.util.DateUtil;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
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
    @Autowired
    private DataArchivesService dataArchivesService;


    @RequiresPermissions({"wiki:wiki:view"})
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
            result.setSuccess(false);
            log.error("获取企业百科列表失败",e);
        }
        return result.getResultPojo();
    }

    /**
     *  分页获取企业百科
     * list
     * @return
     */
    @RequestMapping(value = "/getCustomerEncyclopediaListByQuery",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "list")
    @ResponseBody
    public ResultPojo getCustomerEncyclopediaListByQuery(@RequestBody CustomerEncyclopediaQuery query){
        Result<List<CustomerEncyVO>> result = new Result<List<CustomerEncyVO>>();
        try{
            result=customerEncyclopediaService.getCustomerEncyclopediaByQuery(query);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分页获取企业百科列表失败",e);
        }
        return result.getResultPojo();
    }

    /**
     *  分页获取企业百科数量
     * list
     * @return
     */
    @RequestMapping(value = "/count",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "count_list")
    @ResponseBody
    public ResultPojo count(@RequestBody CustomerEncyclopediaQuery query){
        Result<Integer> result = new Result<Integer>();
        try{
            result=customerEncyclopediaService.count(query);
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分页获取企业百科列表失败",e);
        }
        return result.getResultPojo();
    }




    /**
     * add
     * @return
     */
    @RequestMapping(value = "/addCustomerEncyclopedia",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "add")
    public ModelAndView addCustomerEncyclopedia(String encyId,String customerId){
        Result<List<Currtype>> rcurrtype = dataArchivesService.getCurrtype();
        System.out.println(rcurrtype.getModel().get(1).getPkCurrtype());
        return new ModelAndView("knowledgeBase/encyclopediaAdd").addObject("encyId",encyId).addObject("customerId",customerId)
                .addObject("currtype",rcurrtype.getModel());
    }

    @RequestMapping(value = "/doAddCustomerEncyclopedia",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "doAdd")
    @ResponseBody
     public ResultPojo doAddCustomerEncyclopedia(@RequestBody @Valid  CustomerEncyclopedia customerEncyclopedia, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("请求参数错误",bindingResult);
        }
        Result<CustomerEncyclopedia> result = new Result<CustomerEncyclopedia>();
        try{
            customerEncyclopedia.setCreateUserId(LoginUtils.getLoginId());
            customerEncyclopedia.setCreateUserName(LoginUtils.getLoginName());
            customerEncyclopedia.setLastmodifyUserId(LoginUtils.getLoginId());
            customerEncyclopedia.setLastmodifyUserName(LoginUtils.getLoginName());
            customerEncyclopedia.setCreateTime(DateUtil.getDateTimeFormat());
            customerEncyclopedia.setModifyTime(DateUtil.getDateTimeFormat());
            result = customerEncyclopediaService.addCustomerEncyclopedia(customerEncyclopedia);
            return result.getResultPojo();
        }catch(Exception e){
            result.setSuccess(false);
            log.error("添加客户百科信息失败",e);
        }
        return null;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "delete")
    @ResponseBody
    public ResultPojo delete(String id){
         Result result = new Result();
         try{
             result = customerEncyclopediaService.deleteCustomerEncyclopediaById(id);
             return result.getResultPojo();
        }catch(Exception e){
             result.setSuccess(false);
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
    public ModelAndView update(String encyId,String customerId){
        Result<List<Currtype>> currtype = dataArchivesService.getCurrtype();
        return new ModelAndView("knowledgeBase/encyclopediaInfo").addObject("encyId",encyId).addObject("customerId",customerId)
                .addObject("currtype",currtype.getModel());

    }

    /**
     * 更新百科信息
     * @param customerEncyclopedia
     * @return
     */
    @RequestMapping(value = "/doModify",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "doUpdate")
    @ResponseBody
    public ResultPojo update(@RequestBody @Valid CustomerEncyclopedia customerEncyclopedia,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("请求参数错误",bindingResult);
        }
        customerEncyclopedia.setLastmodifyUserId(LoginUtils.getLoginId());
        customerEncyclopedia.setLastmodifyUserName(LoginUtils.getLoginName());
        customerEncyclopedia.setModifyTime(DateUtil.getDateTimeFormat());
        Result result = new Result();
        try{
            String id =customerEncyclopedia.getEncyId();
            result = customerEncyclopediaService.updateCustomerEncyclopediaById(id,customerEncyclopedia);
            return result.getResultPojo();
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id更新客户信息错误",e);
        }
        return null;
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-customerEncyclopedia",methods = "GET-BY-ID")
    @ResponseBody
    public ResultPojo getById(String encyId){
        Result<CustomerEncyclopedia> result = new Result<CustomerEncyclopedia>();
        try{
            result = customerEncyclopediaService.getCustomerEncyclopediaById(encyId);
            return result.getResultPojo();
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据ID获取客户百科信息错误",e);
        }
        return null;
    }





}
