package com.fuhuadata.web.springmvc;

/**
 * 产品问题action
 * Created by wuxi on 2017/1/16.
 */

import com.fuhuadata.domain.ProductProblem;
import com.fuhuadata.domain.query.ProductProblemQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.ProductProblemService;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.web.util.DateUtil;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/productProblem/*")
public class ProductProblemAction {
    private final static Log log = LogFactory.getLog(ProductProblemAction.class);
    @Resource
    private ProductProblemService productProblemService;
    private Integer pageSize = 10 ;
    private String page = "1";

    /**
     * init
     * @return
     */
    @RequiresPermissions({"wiki:ques:view"})
    @RequestMapping(value = "/productProblemList")
    @SystemLogAnnotation(module = "knowledgeBase-productProblem",methods = "into")
    public ModelAndView productProblem(){
      return new ModelAndView("knowledgeBase/productProblemList");
    }
    /**
     * 产品问题列表
     * @return
     */
    @RequestMapping(value = "/queryProductProblemList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-productProblem",methods = "list")
    @ResponseBody
    public ResultPojo productProblemList(){
        Result<List<ProductProblem>> result = new Result<List<ProductProblem>>();
        ProductProblemQuery query = new ProductProblemQuery();
        try{
             result=productProblemService.getProductProblemsByPage(query);
        }catch(Exception e){
            log.error("获取产品问题列表问题错误",e);
        }

        return result.getResultPojo();
    }

    @RequestMapping(value = "/addProductProblem",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-productProblem",methods = "add")
    public ModelAndView addProductProblem(){return new ModelAndView("knowledgeBase/addProductProblem");}

    @RequestMapping(value = "/doAddProductProblem",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-productProblem",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddProductProblem(@RequestBody ProductProblem productProblem){
        try{
            productProblem.setCreateUserId(LoginUtils.getLoginId());
            productProblem.setCreateUserName(LoginUtils.getLoginName());
            productProblem.setCreateTime(DateUtil.getDateTimeFormat());
            Result<ProductProblem> result = productProblemService.addProductProblem(productProblem);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("新增产品问题失败",e);
        }
        return null;
    }

    @SuppressWarnings("unused")
    @RequestMapping(value = "/queryProductProblemListTest",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-productProblem",methods = "query")
    public ModelAndView queryProductProblemList(@RequestBody ProductProblemQuery productProblemQuery){

        Result<List<ProductProblem>> result = new Result<List<ProductProblem>>();
        try{
            productProblemQuery.setPageSize(pageSize);
            if(productProblemQuery.getIndex()==0){
                productProblemQuery.setIndex(Integer.valueOf(page.trim()));
            }
            result=productProblemService.getProductProblemsByPage(productProblemQuery);
        }catch(Exception e){
            log.error("条件查询错误",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/productProblemList","productProblemList",result.getModel());
        model.addObject("message","产品问题");
        return model;
    }

    /**
     * update
     * @param productProblem
     * @return
     */
    @RequestMapping(value = "/doModify",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-productProblem",methods = "doUpdate")
    @ResponseBody
    public ResultPojo doModifyProductProblem(@RequestBody ProductProblem productProblem){
        try{
            int id = productProblem.getProductId();
            Result<ProductProblem> result = productProblemService.updateProductProblemById(id,productProblem);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("修改产品问题信息错误",e);
        }
        return null;
    }

}
