package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.domain.query.QueryProductInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.ProductInfoService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标准产品档案
 * Created by intanswer on 2017/2/22.
 */
@Controller
@RequestMapping("/productInfo")
public class ProductInfoAction {
    private final static Log log= LogFactory.getLog(ProductInfoAction.class);
    @Resource
    private ProductInfoService productInfoService;

    @RequestMapping(value="/show")
    @SystemLogAnnotation(module = "knowledgeBase-productInfo",methods = "into")
    public ModelAndView ProductInfo(){
        return new ModelAndView("knowledgeBase/productInfo");
    }

    @RequestMapping(value="/list")
    @SystemLogAnnotation(module = "knowledgeBase-productInfo",methods = "list")
    @ResponseBody
    public ResultPojo ProductInfoList(){
        Result<List<ProductInfo>> result =new Result<List<ProductInfo>>();
        QueryProductInfo queryProductInfo = new QueryProductInfo();
        try{
            result=productInfoService.getProductInfosByQuery(queryProductInfo);
        }catch(Exception e){
            log.error("获取标准产品档案错误");
        }
        return result.getResultPojo();
    }
}
