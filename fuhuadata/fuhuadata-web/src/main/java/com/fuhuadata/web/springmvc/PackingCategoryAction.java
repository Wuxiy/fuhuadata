package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.PackingCategory;
import com.fuhuadata.domain.ProductCategory;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.PackingArchivesService;
import com.fuhuadata.service.PackingCategoryService;
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
 * 包材树action
 * Created by intanswer on 2017/2/23.
 */
@Controller
@RequestMapping("/packingCategory/*")
public class PackingCategoryAction {
    private static final Log log= LogFactory.getLog(PackingCategoryAction.class);
    @Resource
    private PackingCategoryService packingCategoryService;

    /**
     * 获取包材目录树原数据
     * @return
     */
    @RequestMapping(value="/packingCategoryAll")
    @SystemLogAnnotation(module = "knowledgeBase-PackingCategory",methods = "all")
    @ResponseBody
    public ResultPojo packingCategoryAll(){
        Result<List<PackingCategory>> result = new Result<List<PackingCategory>>();
        try{
            result=packingCategoryService.getAll();
        }catch(Exception e){
            log.error("获取包材树原目录错误",e);
        }
        return result.getResultPojo();
    }

    /**
     * add
     * @return
     */
    @RequestMapping(value="/add",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-PackingCategory",methods = "add")
    public ModelAndView addPackingCategory(){
        return new ModelAndView("knowledgeBase/packingCategoryAdd");
    }
    @RequestMapping(value = "/doAdd",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-PackingCategory",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddPackingCategory(@RequestBody PackingCategory packingCategory){
        try{
            Result<PackingCategory> result = packingCategoryService.addPackingCategory(packingCategory);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("添加包材目录树节点错误",e);
        }
        return null;
    }

    /**
     * delete
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-PackingCategory",methods ="delete" )
    @ResponseBody
    public ResultPojo deletePackingCategory(int id){
        try{
            Result result =packingCategoryService.deltePackingCategoryById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id删除包材目录节点错误",e);
        }
        return null;
    }

    /**
     * update
     * @param id
     * @return
     */
    @RequestMapping(value = "/modify",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-PackingCategory",methods="update")
    public ModelAndView modifyPackingCategory(int id){
        try{
            Result<PackingCategory> result = new Result<PackingCategory>();
        }catch (Exception e){
            log.error("当前不能更新",e);
        }
        return new ModelAndView("knowledgeBase/packingCategoryUpdate");
    }

    @RequestMapping(value = "/doModify",method =RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-PackingCategory",methods = "doUpdate")
    @ResponseBody
    public ResultPojo doModifyPackingCategory(@RequestBody PackingCategory packingCategory){
        try{
            int id = packingCategory.getCategoryId();
            Result<PackingCategory> result = packingCategoryService.updatePackingCategoryById(id,packingCategory);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("修改包材树节点错误",e);
        }
        return null;
    }
}
