package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.query.PortChargesCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.PortChargesCostService;
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
 * 港杂费action
 * Created by intanswer on 2017/1/19.
 */
@Controller
@RequestMapping("/portChargesCost/*")
public class PortChargesCostAction {
    private final static Log log= LogFactory.getLog(PortChargesCostAction.class);
    @Resource
    private PortChargesCostService portChargesCostService;
    private Integer pageSize = 10;
    private String page="1";
    @SuppressWarnings("unused")
    @RequestMapping(value = "/portChargesCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-港杂费",methods = "查看")
    public ModelAndView portChargesCostList(){
        Result<List<PortChargesCost>> result = new Result<List<PortChargesCost>>();
        try{
            PortChargesCostQuery query = new PortChargesCostQuery();
            query.setPageSize(pageSize);
            try{
                query.setIndex(Integer.valueOf(page.trim()));
            }catch (Exception e){
                query.setIndex(1);
            }
            result=portChargesCostService.getPortChargesCostsByPage(query);
        }catch(Exception e){
            log.error("获取港杂费成本列表错误",e);

        }
        ModelAndView model= new ModelAndView("knowledgeBase/portChargesCostList","portChargesCosts",result.getModel());
        model.addObject("message","港杂费列表");
        return model;
    }
    @RequestMapping(value = "/addPortChargesCost",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-港杂费",methods = "新增港杂费")
    public ModelAndView addPortChargesCost(){return new ModelAndView("knowledgeBase/addPortChargesCost");}

    @RequestMapping(value = "/doAddPortChargesCost",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-港杂费",methods = "执行新增")
    @ResponseBody
    public ResultPojo doAddPortChargesCost(@RequestBody PortChargesCost portChargesCost){
        try{
            Result<PortChargesCost> result = portChargesCostService.addPortChargesCost(portChargesCost);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("添加港杂费失败",e);
        }
        return null;
    }
}
