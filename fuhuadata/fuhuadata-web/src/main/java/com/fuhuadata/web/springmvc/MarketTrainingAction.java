package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.MarketTraining;
import com.fuhuadata.domain.query.MarketTrainingQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.MarketTrainingService;

import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * knowledgeBase-marketTraining
 * Created by intanswer on 2017/1/12.
 */
@Controller
@RequestMapping("/marketTraining/*")
public class MarketTrainingAction {

    private final static Log log= LogFactory.getLog(MarketTrainingAction.class);
    @Resource
    private MarketTrainingService marketTrainingService;
    private Integer pageSize=10;
    private String page="1";

    /**
     * 营销培训列表
     * @return
     */
    @RequiresPermissions({"wiki:train:view"})
    @RequestMapping(value="/marketTrainingList")
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "into")
    public ModelAndView marketTrainingList(){
        return new ModelAndView("knowledgeBase/marketTrainingList");
    }
    @RequestMapping(value = "/queryMarketTrainingList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "list")
    @ResponseBody
    public ResultPojo querymarketTrainingList(){
        MarketTrainingQuery marketTrainingQuery = new MarketTrainingQuery();
        Result<List<MarketTraining>> result = new Result<List<MarketTraining>>();
        try{
            result=marketTrainingService.getMarketTrainingsByQuery(marketTrainingQuery);
        }catch (Exception e){
            log.error("获取营销培训列表失败",e);
        }
        return result.getResultPojo();

    }

    /**
     * add
     * @return
     */
    @RequestMapping(value="/addMarketTraining")
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "add")
    public ModelAndView addMarketTrainingList(){
        return new ModelAndView("knowledgeBase/marketTrainingAdd");
    }
    @RequestMapping(value = "/doAddMarketTraining",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddMarketTraining(@RequestBody MarketTraining marketTraining){
        try{
            Result<MarketTraining> result = marketTrainingService.addMarketTraining(marketTraining);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("添加营销培训信息出错");
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "delete")
    @ResponseBody
    public ResultPojo delete(int id){
        try{
            Result result = marketTrainingService.deleteMarketTrainingById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id删除营销培训信息错误",e);
        }
        return null;
    }


    /**
     * update
     * @param marketTraining
     * @return
     */
    @RequestMapping(value = "/doModify",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "doUpdate")
    @ResponseBody
    public ResultPojo doModifyMarketTraining(@RequestBody MarketTraining marketTraining){
        try{
            int id=marketTraining.getTranId();
            Result<MarketTraining> result = marketTrainingService.updateMarketTrainingById(id,marketTraining);
        }catch(Exception e){
            log.error("更新市场营销培训信息失败",e);
        }
        return null;
    }



}
