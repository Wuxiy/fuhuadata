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
     * init
     * @return
     */
    @RequestMapping(value = "/componentCostInfoList")
    @SystemLogAnnotation(module = "knowledgeBase-componentCostInfo",methods = "into")
    public ModelAndView componentCostInfo(){
        return new ModelAndView("knowledgeBase/componentCostInfoList");
    }

    /**
     * list
     * @return
     */
    @RequestMapping(value = "/queryComponentCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-componentCostList",methods = "list")
    @ResponseBody
    public ResultPojo componentCostList(){
        ComponentCostQuery query=new ComponentCostQuery();
        Result<List<ComponentCost>> result = new Result<List<ComponentCost>>();
        try {
            result=componentCostService.getComponentCostByQuery(query);
        } catch (Exception e) {
            log.error("获取知识库成分价格列表失败",e);
        }
        return result.getResultPojo();
    }
    @RequestMapping(value = "/addComponentCost",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-成分价格",methods = "add")
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
    @SystemLogAnnotation(module = "知识库-成分价格",methods = "doAdd")
    public ResultPojo doAddComponentCost(@RequestBody ComponentCost componentCost){
        try{
            Result<ComponentCost> result = componentCostService.addComponentCost(componentCost);
            return result.getResultPojo();//结果码,-1需要登录，0消息错误，1正确
        }catch(Exception e){
            log.error("添加成分价格错误");
        }
        return null;
    }


}
