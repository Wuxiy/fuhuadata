package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.KProductComponent;
import com.fuhuadata.domain.query.ComponentCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.ComponentCostService;
import com.fuhuadata.vo.ComponentCostDO;
import com.fuhuadata.vo.ComponentCostVO;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
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
    @RequiresPermissions({"wiki:ele:view"})
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

    /**
     * add
     * @return
     */
    @RequestMapping(value = "/addComponentCost",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-componentCostInfo",methods = "add")
    public ModelAndView addComponentCost(){
        return new ModelAndView("knowledgeBase/addComponentCost");

    }
    @RequestMapping(value="/doAddComponentCost",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-componentCostInfo",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddComponentCost(@RequestBody ComponentCostVO componentCostVO){
        ComponentCost componentCost = componentCostVO.getComponentCost();
        System.out.println(componentCostVO.getkProductComponents()+"123"+componentCostVO.getComponentCost());
        KProductComponent[] KProductComponents = componentCostVO.getkProductComponents();
        Result result = new Result();
        List<KProductComponent> list  = new ArrayList<KProductComponent>();
        try{
            if(KProductComponents !=null&& KProductComponents.length>0) {
                list= Arrays.asList(KProductComponents);
            }
            result = componentCostService.addComponentCost(componentCost, list);
        }catch(Exception e){
            log.error("添加成分价格错误");
        }
        return result.getResultPojo();//结果码,-1需要登录，0消息错误，1正确
    }

    /**
     * update
     * @param componentCostVO
     * @return
     */
    @RequestMapping(value="/doModify",method = RequestMethod.POST)
    @ResponseBody
    @SystemLogAnnotation(module = "knowledgeBase-componentCostInfo",methods = "doUpdate")
    public ResultPojo delete(@RequestBody ComponentCostVO componentCostVO){
        ComponentCost componentCost = componentCostVO.getComponentCost();
        KProductComponent[] KProductComponents = componentCostVO.getkProductComponents();
        Result result = new Result();
        List<KProductComponent> list  = new ArrayList<KProductComponent>();
        try{
            if(KProductComponents !=null&& KProductComponents.length>0) {
                list= Arrays.asList(KProductComponents);
            }
            result = componentCostService.updateComponentCostById(componentCost, list);

        }catch(Exception e){
            log.error("更新成分价格错误",e);
        }
        return result.getResultPojo();//结果码,-1需要登录，0消息错误，1正确
    }

    @RequestMapping(value="/delete",method = RequestMethod.GET)
    @ResponseBody
    @SystemLogAnnotation(module = "knowledgeBase-componentCostInfo",methods = "delete")
    public ResultPojo doAddComponentCost(int id ){
        try{
            Result result = componentCostService.deleteComponentCostById(id);
            return result.getResultPojo();//结果码,-1需要登录，0消息错误，1正确
        }catch(Exception e){
            log.error("根据id删除成分价格错误");
        }
        return null;
    }
    /**
     * 根据id获取成分价格
     * @param id
     * @return
     */
    @RequestMapping(value="/getComponentCostById",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-componentCostInfo",methods = "GET-BY-ID")
    @ResponseBody
    public ResultPojo getComponentCostById(int id){
        try{
            Result<ComponentCostDO> result=componentCostService.getComponentCostById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id获取成分价格错误",e);
        }
        return null;
    }


}
