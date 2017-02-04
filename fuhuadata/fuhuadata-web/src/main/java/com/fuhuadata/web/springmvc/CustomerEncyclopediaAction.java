package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerEncyclopedia;
import com.fuhuadata.domain.query.CustomerEncyclopediaQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.CustomerEncyclopediaService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

        ModelAndView model= new ModelAndView("knowledgeBase/customerEncyclopediaList","customerEncyclopediaList",result.getModel());
        model.addObject("message","企业百科列表");
        return model;
    }
    

}
