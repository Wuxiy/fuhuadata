package com.fuhuadata.web.springmvc;


import com.fuhuadata.domain.ProductCategory;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.ProductCategoryService;
import com.fuhuadata.vo.CategoryTree;
import com.fuhuadata.vo.ProductCategoryVO;
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
 * 产品目录树
 * Created by intanswer on 2017/2/23.
 */
@Controller
@RequestMapping("/productCategory/*")
public class ProductCategoryAction {
    private final static Log log= LogFactory.getLog(ProductCategoryAction.class);
    @Resource
    private ProductCategoryService productCategoryService;

    /**
     * 获取产品目录树原数据
     * @return
     */
    @RequestMapping(value="/productCategoryAll")
    @SystemLogAnnotation(module = "knowledgeBase-ProductCategory",methods = "all")
    @ResponseBody
    public ResultPojo productCategoryAll(){
        Result<List<ProductCategory>> result = new Result<List<ProductCategory>>();
        try{
           result=productCategoryService.getAll();
        }catch(Exception e){
            log.error("获取产品树原目录错误",e);
        }
        return result.getResultPojo();
    }

    /**
     * json目录树
     * @return
     */
    @RequestMapping(value="/CategoryTree")
    @SystemLogAnnotation(module = "knowledgeBase-ProductCategory",methods = "level")
    @ResponseBody
    public ResultPojo productCategoryLevel(){
        Result<List<CategoryTree>> result = new Result<List<CategoryTree>>();
        try{
            result=productCategoryService.getProductCategoryByLevel();
        }catch(Exception e){
            log.error("获取产品树json数据错误",e);
        }
        return result.getResultPojo();
    }

    /**
     * json目录树
     * @return
     */
    @RequestMapping(value="/CategoryTreeThree")
    @SystemLogAnnotation(module = "knowledgeBase-ProductCategory",methods = "CategoryTree")
    @ResponseBody
    public ResultPojo productCategoryCategory(){
        Result<List<CategoryTree>> result = new Result<List<CategoryTree>>();
        try{
            result=productCategoryService.getProductCategoryByCategory();
        }catch(Exception e){
            log.error("获取产品树json数据错误",e);
        }
        return result.getResultPojo();
    }

//    /**
//     * json目录树
//     * @return
//     */
//    @RequestMapping(value="/CategoryTree")
//    @SystemLogAnnotation(module = "knowledgeBase-ProductCategory",methods = "level")
//    @ResponseBody
//    public ResultPojo productCategoryTree(){
//        Result<List<CategoryTree>> result = new Result<List<CategoryTree>>();
//        try{
//            //result=productCategoryService.getProductCategoryByLevel();
//            result=productCategoryService.getAllByTree();
//        }catch(Exception e){
//            log.error("获取产品树json数据错误",e);
//        }
//        return result.getResultPojo();
//    }

    /**
     * add
     * @return
     */
    @RequestMapping(value="/addProductCategory",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-ProductCategory",methods = "add")
    public ModelAndView addProductCategory(){
        return new ModelAndView("knowledgeBase/productCategoryAdd");
    }
    @RequestMapping(value = "/doAddProductCategory",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-ProductCategory",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddExhibitionInfo(@RequestBody ProductCategory productCategory){
        try{
            Result<ProductCategory> result = productCategoryService.addProductCategory(productCategory);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("添加产品目录树节点错误",e);
        }
        return null;
    }

    /**
     * delete
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteProductCategory",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-ProductCategory",methods ="delete" )
    @ResponseBody
    public ResultPojo deleteExhibitionInfo(int id){
        try{
            Result result =productCategoryService.deleteProductCategoryById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id删除目录树错误",e);
        }
        return null;
    }

    /**
     * update
     * @param id
     * @return
     */
    @RequestMapping(value = "/modify",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-ProductCategory",methods="update")
    public ModelAndView modifyProductCategory(int id){
        try{
            Result<ProductCategory> result = new Result<ProductCategory>();
        }catch (Exception e){
            log.error("当前不能更新",e);
        }
        return new ModelAndView("knowledgeBase/exhibitionInfoUpdate");
    }

    @RequestMapping(value = "/doModify",method =RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-ProductCategory",methods = "doUpdate")
    @ResponseBody
    public ResultPojo doModifyProductCategory(@RequestBody ProductCategory productCategory){
        try{
            int id = productCategory.getId();
            Result<ProductCategory> result = productCategoryService.updateProductCategoryById(id,productCategory);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("修改产品树节点错误",e);
        }
        return null;
    }

}
