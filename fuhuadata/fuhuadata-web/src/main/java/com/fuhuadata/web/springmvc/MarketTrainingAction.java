package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.MarketTraining;
import com.fuhuadata.domain.query.MarketTrainingQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.MarketTrainingService;

import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
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
    @SuppressWarnings("unused")
    @RequestMapping(value = "/marketTrainingList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-营销培训",methods = "营销培训列表")
    public ModelAndView marketTrainingList(){
        Result<List<MarketTraining>> result = new Result<List<MarketTraining>>();
        try{
            MarketTrainingQuery query = new MarketTrainingQuery();
            query.setPageSize(pageSize);
            try {
                query.setIndex(Integer.valueOf(page.trim()));
            } catch (Exception e) {
                query.setIndex(1);
            }
            result=marketTrainingService.getMarketTrainingsByPage(query);
        }catch (Exception e){
            log.error("获取营销培训列表失败",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/marketTrainingList","marketTrainingList",result.getModel());
        model.addObject("message","营销培训列表");
        return model;

    }

    @SuppressWarnings("unused")
    @RequestMapping(value = "/queryMarketTraining",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-营销培训",methods = "查询培训资料")
    @ResponseBody
    public ModelAndView QuerymarketTraining(@RequestBody MarketTrainingQuery marketTrainingQuery){
        Result<List<MarketTraining>> result = new Result<List<MarketTraining>>();
        try{
            marketTrainingQuery.setPageSize(pageSize);
            try {
                marketTrainingQuery.setIndex(Integer.valueOf(page.trim()));
            } catch (Exception e) {
                marketTrainingQuery.setIndex(1);
            }
            result=marketTrainingService.getMarketTrainingsByPage(marketTrainingQuery);
        }catch (Exception e){
            log.error("查询获取营销培训列表失败",e);
        }
        ModelAndView model = new ModelAndView("marketTraining/marketTrainingList","marketTrainings",result.getModel());
        model.addObject("message","营销培训列表");
        return model;

    }

    @RequestMapping(value = "/doAddMarketTraining",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-营销培训",methods = "新增营销培训记录")
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

}
