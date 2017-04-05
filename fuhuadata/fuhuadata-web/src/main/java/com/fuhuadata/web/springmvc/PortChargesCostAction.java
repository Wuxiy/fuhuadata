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

    @RequestMapping(value = "/portChargesCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-portChargesCost",methods = "into")
    public ModelAndView portChargesCost(){
      return new ModelAndView("knowledgeBase/portChargesCostList");
    }
    /**
     * list
     * @return
     */
    @RequestMapping(value = "/queryPortChargesCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-portChargesCost",methods = "list")
    @ResponseBody
    public ResultPojo portChargesCostList(){
        Result<List<PortChargesCost>> result = new Result<List<PortChargesCost>>();
        try{
            PortChargesCostQuery query = new PortChargesCostQuery();
            result=portChargesCostService.getPortChargesCostsByQuery(query);
        }catch(Exception e){
            log.error("获取港杂费成本列表错误",e);

        }
      return result.getResultPojo();
    }

    /**
     * add
     * @return
     */
    @RequestMapping(value = "/addPortChargesCost",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-portChargesCost",methods = "add")
    public ModelAndView addPortChargesCost(){return new ModelAndView("knowledgeBase/addPortChargesCost");}

    @RequestMapping(value = "/doAddPortChargesCost",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-portChargesCost",methods = "doAdd")
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

    /**
     * 根据id获取json返回值
     * @param id
     * @return
     */
    @RequestMapping(value = "/getPortChargesCostById")
    @ResponseBody
    @SystemLogAnnotation(module = "knowledgeBase-portChargesCost",methods = "GET-BY-ID")
    public ResultPojo getPortChargesCostById(int id){
        try{
            Result<PortChargesCost> result = portChargesCostService.getPortChargesCostById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id获取港杂费信息错误",e);
        }
        return null;
    }

    /**
     * update
     * @param id
     * @return
     */
    @RequestMapping(value="/ModifyPortChargesCost")
    @SystemLogAnnotation(module = "knowledgeBase-portChargesCost",methods="add")
    public ModelAndView ModifyPortChargesCost(int id){
        try{
            Result<PortChargesCost> result=portChargesCostService.getPortChargesCostById(id);
        }catch(Exception e){
            log.error("获取港杂费信息错误",e);
        }
        return new ModelAndView("knowledgeBase/modifyPortChargesCost");
    }

    /**
     * do modify
     * @param portChargesCost
     * @return
     */
    @RequestMapping(value="/doModifyPortChargesCost",method=RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-portChargesCost",methods = "doAdd")
    @ResponseBody
    public ResultPojo doModifyPortChargesCost(@RequestBody PortChargesCost[] portChargesCosts){
        try{
            Result<PortChargesCost> result = portChargesCostService.updatePortChargesCostById(portChargesCosts);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("修改港杂费信息错误",e);
        }
        return null;
    }
    /**
     * delete
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value="/deletePortChargesCost",method=RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-portChargesCost",methods="delete")
    @ResponseBody
    public ResultPojo deletePortChargesCost(int id){
        try{
            Result result = portChargesCostService.deletePortChargesCostById(id);
            return result.getResultPojo();
        }catch(Exception e){
            //打印日志
            log.error("根据id删除港杂费信息错误",e);
        }
        return null;
    }


}
