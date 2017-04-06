package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.PreparationProcessCost;
import com.fuhuadata.domain.query.PreparationProcessCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.PreparationProcessCostService;
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
 * 制剂成本action
 * Created by intanswer on 2017/1/19.
 */
@Controller
@RequestMapping("/preparationProcessCost/*")
public class PreparationProcessCostAction {
    private final static Log log = LogFactory.getLog(PreparationProcessCostAction.class);
    @Resource
    private PreparationProcessCostService preparationProcessCostService;
    private Integer pageSize=5;
    private String page="1";

    /**
     * init
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/preparationProcessCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-preparationProcessCost",methods = "into")
    public ModelAndView preparationProcessCost(){
        return new ModelAndView("knowledgeBase/preparationProcessCostList");
    }

    /**
     * list
     * @return
     */
    @RequestMapping(value = "/queryPreparationProcessCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-preparationProcessCost",methods = "list")
    @ResponseBody
    public ResultPojo preparationProcessCostList(){
        Result<List<PreparationProcessCost>> result = new Result<List<PreparationProcessCost>>();
        PreparationProcessCostQuery query = new PreparationProcessCostQuery();
        try{
            result= preparationProcessCostService.getPreparationProcessCostByQuery(query);
        }catch(Exception e){
            log.error("获取制剂加工费列表错误",e);
        }
        return result.getResultPojo();
    }

    @RequestMapping(value = "/addPreparationProcessCost",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-preparationProcessCost",methods = "add")
    public ModelAndView addPreparationProcessCost(){
        return new ModelAndView("knowledgeBase/addPreparationProcessCost");
    }
    @RequestMapping(value = "/doAddPreparationProcessCost",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-preparationProcessCost",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddPreparationProcessCost(@RequestBody PreparationProcessCost preparationProcessCost){
        try{
            Result<PreparationProcessCost> result = preparationProcessCostService.addPreparationProcessCost(preparationProcessCost);
            return result.getResultPojo();
        }catch(Exception e){

            log.error("添加制剂加工费失败",e);
        }
        return null;
    }


    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @RequestMapping(value="/getPreparationProcessCostById",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-preparationProcessCost",methods = "GET-BY-ID")
    @ResponseBody
    public ResultPojo getPreparationProcessCostById(int id){
        try{
            Result<PreparationProcessCost> result = preparationProcessCostService.getPreparationProcessCostById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id获取制剂加工成本错误",e);
        }
        return null;
    }
    /**
     * 条件查询
     * @param preparationProcessCostQuery
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/queryPreparationProcessCostListTest",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-preparationProcessCost",methods = "query")
    public ModelAndView queryPreparationProcessCostList(@RequestBody PreparationProcessCostQuery preparationProcessCostQuery){
        Result<List<PreparationProcessCost>> result = new Result<List<PreparationProcessCost>>();
        try{
            preparationProcessCostQuery.setPageSize(pageSize);
            if(preparationProcessCostQuery.getIndex()==0){
                preparationProcessCostQuery.setIndex(Integer.valueOf(page.trim()));
            }
            result=preparationProcessCostService.getPreparationProcessCostsByPage(preparationProcessCostQuery);
        }catch(Exception e){
            log.error("制剂加工费查询失败",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/preparationProcessCostList","preparationProcessCostList",result.getModel());
        model.addObject("message","制剂加工成本");
        return model;
    }

    /**
     * update
     * @param preparationProcessCost
     * @return
     */
    @RequestMapping(value = "/doModify",method=RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-preparationProcessCost",methods="doUpdate")
    @ResponseBody
    public ResultPojo doModifyPreparationProcessCost(int id,@RequestBody PreparationProcessCost preparationProcessCost){
        try{
            Result<PreparationProcessCost> result = preparationProcessCostService.updatePreparationProcessCost(id,preparationProcessCost);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("修改制剂加工成本错误",e);
        }
        return null;
    }

}
