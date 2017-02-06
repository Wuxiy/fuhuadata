package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ComponentCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.ComponentCostService;
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
 *
 * 成分价格action
 * Created by wuxi on 2017/1/16.
 */
@Controller
@RequestMapping("/componentCost/*")
public class ComponentCostAction {
    private final static Log log = LogFactory.getLog(ComponentCostAction.class);
    @Resource
    private ComponentCostService componentCostService;
    private Integer pageSize=5;
    private String page="1";

    /**
     * 初始化页面
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/componentCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-成分价格",methods = "查看")
    public ModelAndView componentCostList(){
        Result<List<ComponentCost>> result = new Result<List<ComponentCost>>();

        try {
            ComponentCostQuery query=new ComponentCostQuery();
            query.setPageSize(pageSize);
            try{
                query.setIndex(Integer.valueOf(page.trim()));

            }catch(Exception e){
                query.setIndex(1);
            }
            result=componentCostService.getComponentCostsByPage(query);
        } catch (Exception e) {
            log.error("获取知识库成分价格列表失败",e);
        }
        ModelAndView model= new ModelAndView("knowledgeBase/componentCostList","componentCostList",result.getModel());
        model.addObject("message","知识库成分列表");
        return model;
    }
    @RequestMapping(value = "/addComponentCost",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-成分价格",methods = "新增成分价格")
    public ModelAndView addComponentCost(){
        return new ModelAndView("knowledgeBase/addComponentCost");

    }

    /**
     * 新增component
     * @param componentCost
     * @return
     */
    @RequestMapping(value="/doAddComponentCost",method = RequestMethod.POST)
    @ResponseBody
    @SystemLogAnnotation(module = "知识库-成分价格",methods = "执行新增")
    public ResultPojo doAddComponentCost(@RequestBody ComponentCost componentCost){
        try{
            Result<ComponentCost> result = componentCostService.addComponentCost(componentCost);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("添加成分价格错误");
        }
        return null;
    }

    /**
     * 条件查询component
     * @param componentCostQuery
     * @return
     */
    @RequestMapping(value = "/queryComponentCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-成分价格",methods = "条件查询")
    public ModelAndView queryComponentCostList(@RequestBody ComponentCostQuery componentCostQuery){
        Result<List<ComponentCost>> result = new Result<List<ComponentCost>>();
        try{
            componentCostQuery.setPageSize(pageSize);
            if(componentCostQuery.getIndex()==0){
                componentCostQuery.setIndex(Integer.valueOf(page.trim()));
            }
            result=componentCostService.getComponentCostsByPage(componentCostQuery);
        }catch(Exception e){
            log.error("条件查询失败",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/componentCostList","componentCostList",result.getModel());
        model.addObject("message","成分价格列表");
        return model;
    }

}
