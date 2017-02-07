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

    @SuppressWarnings("unused")
    @RequestMapping(value = "/preparationProcessCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-制剂加工费",methods = "制剂加工费列表")
    public ModelAndView preparationProcessCostList(){
        Result<List<PreparationProcessCost>> result = new Result<List<PreparationProcessCost>>();
        try{
            PreparationProcessCostQuery query = new PreparationProcessCostQuery();
            query.setPageSize(pageSize);
            try{
                query.setIndex(Integer.valueOf(page));
            }catch(Exception e){
                query.setIndex(1);
            }
            result= preparationProcessCostService.getPreparationProcessCostsByPage(query);
        }catch(Exception e){
            log.error("获取制剂加工费列表错误",e);
        }
        ModelAndView model= new ModelAndView("knowledgeBase/preparationProcessCostList","preparationProcessCosts",result.getModel());
        model.addObject("message","制剂加工费列表");
        return model;
    }

    @RequestMapping(value = "/addPreparationProcessCost",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-制剂加工费",methods = "新增制剂加工费")
    public ModelAndView addPreparationProcessCost(){
        return new ModelAndView("knowledgeBase/addPreparationProcessCost");
    }
    @RequestMapping(value = "/doAddPreparationProcessCost",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-制剂加工费",methods = "执行新增")
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
     * 条件查询
     * @param preparationProcessCostQuery
     * @return
     */
    @RequestMapping(value = "/queryPreparationProcessCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-制剂加工费",methods = "条件查询")
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

}
