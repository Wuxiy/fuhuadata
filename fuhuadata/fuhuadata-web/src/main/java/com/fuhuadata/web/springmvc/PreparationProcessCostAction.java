package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.PreparationProcessCost;
import com.fuhuadata.domain.query.PreparationProcessCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.CustomerEncyclopediaService;
import com.fuhuadata.service.PreparationProcessCostService;
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
    @SystemLogAnnotation(module = "知识库-加工成本参考",methods = "加工成本查询")
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
            log.error("获取加工成本列表错误",e);
        }

        ModelAndView model= new ModelAndView("knowledgeBase/preparationProcessCostList","preparationProcessCostList",result.getModel());
        model.addObject("message","加工成本列表");
        return model;
    }


}
