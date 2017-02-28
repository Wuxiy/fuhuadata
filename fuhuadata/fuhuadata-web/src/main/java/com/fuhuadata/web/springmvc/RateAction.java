package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.Rate;
import com.fuhuadata.domain.query.RateQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.RateService;
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
 * 费率action
 * Created by young on 2017/2/22.
 */
@Controller
@RequestMapping("/Rate/*")
public class RateAction {
    private final static Log log = LogFactory.getLog(Rate.class);
    @Resource
    private  RateService rateService;
    private Integer pageSize = 5;
    private  String page="1";

    /**
     * init
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value="/RateList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledge-Rate",methods = "into")
    public ModelAndView rate(){
        return new ModelAndView("knowledgeBase/processCostList");
    }

    /**
     * list
     * @return
     */
    @RequestMapping(value = "/queryRateList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledge-rate",methods = "list")
    @ResponseBody
    public ResultPojo rateList(){
        Result<List<Rate>> result = new Result<List<Rate>>();
        RateQuery query = new RateQuery();
        try{
            result = rateService.getRatesByPage(query);
        }catch(Exception e){
            log.error("获取费率列表错误",e);
        }
        return result.getResultPojo();
    }

    @RequestMapping(value = "/addRate",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-rate",methods = "add")
    public ModelAndView addPreparationProcessCost(){
        return new ModelAndView("knowledgeBase/addRate");
    }
    @RequestMapping(value = "/doAddRate",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-rate",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddPreparationProcessCost(@RequestBody Rate rate){
        try{
            Result<Rate> result = rateService.addRate(rate);
            return result.getResultPojo();
        }catch(Exception e){

            log.error("添加费率失败",e);
        }
        return null;
    }

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @RequestMapping(value="/getRateById")
    @SystemLogAnnotation(module = "knowledgeBase-rate",methods = "GET-BY-ID")
    @ResponseBody
    public ResultPojo getRateById(int id){
        try{
            Result<Rate> result = rateService.getRateById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id获取费率信息错误",e);
        }
        return null;
    }


}
