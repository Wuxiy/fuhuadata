package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.FreightCost;
import com.fuhuadata.domain.query.FreightCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.FreightCostService;
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
 * 运费成本action
 * Created by wuxi on 2017/1/16.
 */
@Controller
@RequestMapping("/freightCost/*")
public class FreightCostAction {
    private final static Log log= LogFactory.getLog(FreightCostAction.class);
    @Resource
    private FreightCostService freightCostService;
    private Integer pageSize = 10;
    private String page="1";
    @SuppressWarnings("unused")
    @RequestMapping(value = "/freightCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-运费",methods = "运费查看")
    public ModelAndView freightCostList(){
        Result<List<FreightCost>> result = new Result<List<FreightCost>>();
        try{
            FreightCostQuery freightCostQuery = new FreightCostQuery();
            freightCostQuery.setPageSize(pageSize);
            try{
                freightCostQuery.setIndex(Integer.valueOf(page.trim()));
            }catch(Exception e){
                freightCostQuery.setIndex(1);
            }
            result=freightCostService.getFreightCostsByPage(freightCostQuery);
        }catch(Exception e){
            log.error("获取运费列表错误");
        }
        ModelAndView model= new ModelAndView("knowledgeBase/freightCostList","freightCostList",result.getModel());
        model.addObject("message","运费列表");
        return model;
    }
    @RequestMapping(value = "/addFreightCost",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-运费",methods = "新增运费")
    public ModelAndView addFreightCost(){
        return new ModelAndView("knowledgeBase/addFreightCost");
    }

    @RequestMapping(value = "/doAddFreightCost",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-运费",methods = "执行新增")
    @ResponseBody
    public ResultPojo doAddFreightCost(@RequestBody FreightCost freightCost){
        try{
            Result<FreightCost> result = freightCostService.addFreightCost(freightCost);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("添加运费失败",e);
        }
        return null;
    }

    public ModelAndView queryFreightCostList(@RequestBody FreightCostQuery freightCostQuery){
        return null;
    }

}
