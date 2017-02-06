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

@Controller
@RequestMapping("/productProblem/*")
public class ProductProblemAction {
    private final static Log log = LogFactory.getLog(ProductProblemAction.class);
    @Resource
    private ProductProblemService productProblemService;
    private Integer pageSize = 10 ;
    private String page = "1";
    /**
     * 产品问题列表
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/productProblemList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-产品问题",methods = "列表查询")
    public ModelAndView productProblemList(){
        Result<List<ProductProblem>> result = new Result<List<ProductProblem>>();
        try{
            ProductProblemQuery query = new ProductProblemQuery();
            query.setPageSize(pageSize);
            try{
                query.setIndex(Integer.valueOf(page));
            }catch(Exception e){
                query.setIndex(1);
            }
            result=productProblemService.getProductProblemsByPage(query);
        }catch(Exception e){
            log.error("获取产品问题列表问题错误",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/productProblemList","productProblems",result.getModel());
        model.addObject("message","产品问题列表");
        return model;
    }

    @RequestMapping(value = "/addProductProblem",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-产品问题",methods = "新增产品问题")
    public ModelAndView addProductProblem(){return new ModelAndView("knowledgeBase/addProductProblem");}

    @RequestMapping(value = "/doAddProductProblem",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-产品问题",methods = "执行新增")
    @ResponseBody
    public ResultPojo doAddProductProblem(@RequestBody ProductProblem productProblem){
        try{
            Result<ProductProblem> result = productProblemService.addProductProblem(productProblem);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("新增产品问题失败",e);
        }
        return null;
    }

}
