package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.ProductInfo;
import com.fuhuadata.domain.query.QueryProductInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.ProductInfoService;
import com.fuhuadata.vo.ProductInfoVO;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * add
     * @return
     */
    @RequestMapping(value="/add",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-productInfo",methods = "add")
    public ModelAndView addProductInfo(){return new ModelAndView("knowledgeBase/productInfoAdd");}

    @RequestMapping(value="/doAdd",method=RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-productInfo",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddProductInfo(@RequestBody ProductInfo productInfo){
        try{
            Result<ProductInfo> result = productInfoService.addProductInfo(productInfo);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("添加标准产品档案失败",e);
        }
        return null;
    }

    /**
     * delete
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-ProductInfo",methods ="delete" )
    @ResponseBody
    public ResultPojo deleteProductInfo(int id){
        try{
            Result result=productInfoService.deleteProductInfoById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id删除产品档案失败",e);
        }
        return null;
    }

    /**
     * update
     * @param id
     * @return
     */
    @RequestMapping(value = "/modify",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-ProductInfo",methods = "update")
    public ModelAndView modifyProductInfo(int id){
        try{
            Result<ProductInfo> result = new Result<ProductInfo>();

        }catch(Exception e){
            log.error("获取产品档案信息失败",e);
        }
        return new ModelAndView("knowledgeBase/productInfoUpdate");
    }
    @RequestMapping(value = "/doModify",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-ProductInfo",methods = "doUpdate")
    @ResponseBody
    public ResultPojo doModifyProductInfo(@RequestBody ProductInfo productInfo) {
        try {
            int id = productInfo.getProductId();
            Result<ProductInfo> result = productInfoService.updateProductInfoById(id, productInfo);
            return result.getResultPojo();
        } catch (Exception e) {
            log.error("修改产品档案失败", e);
        }
        return null;
    }

    /**
     * get by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/getProductInfoById",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-ProductInfo",methods = "GET-BY-ID")
    @ResponseBody
    public ResultPojo getProductInfoById(Integer id){
        try{
            Result<ProductInfoVO> result = productInfoService.getProductInfoById(id.intValue());
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id获取产品档案失败",e);
        }
        return null;
    }

    /**
     * get by PID
     * @param id
     * @return
     */
    @RequestMapping(value = "/getProductInfoByPId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-ProductInfo",methods = "GET-BY-PID")
    @ResponseBody
    public ResultPojo getProductInfoByPId(Integer id){
        try{
            System.out.println(id);
            Result<List<ProductInfo>> result = productInfoService.getProductInfoByPId(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据产品分类获取产品档案失败",e);
        }
        return null;
    }


 }
