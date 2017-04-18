package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.FreightCost;
import com.fuhuadata.domain.query.FreightCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.FreightCostService;
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

    /**
     * init
     * @return
     */
    @RequiresPermissions({"wiki:frei:view"})
    @RequestMapping(value = "/freightCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-freightCost",methods = "into")
    public ModelAndView freightCost(){
        return new ModelAndView("knowledgeBase/freightCostList");
    }

    @RequestMapping(value = "/queryFreightCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-freightCost",methods = "list")
    @ResponseBody
    public ResultPojo freightCostList(){
        Result<List<FreightCost>> result = new Result<List<FreightCost>>();
        try{
            FreightCostQuery freightCostQuery = new FreightCostQuery();
            result=freightCostService.getFreightCostsByPage(freightCostQuery);
        }catch(Exception e){
            log.error("获取运费列表错误");
        }
       return result.getResultPojo();
    }

    /**
     * add
     * @return
     */
    @RequestMapping(value = "/addFreightCost",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-freightCost",methods = "add")
    public ModelAndView addFreightCost(){
        return new ModelAndView("knowledgeBase/addFreightCost");
    }
    @RequestMapping(value = "/doAddFreightCost",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-freightCost",methods = "doAdd")
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

    /**
     * delete
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-freightCost",methods = "delete")
    @ResponseBody
    public ResultPojo delete(int id){
        try{
            Result<FreightCost> result = freightCostService.deleteFreightCostById(id);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("根据id删除运费成本错误",e);
        }
        return null;
    }

    /**
     * update
     * @param freightCost
     * @return
     */
    @RequestMapping(value = "/doModify",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-freightCost",methods = "doUpdate")
    @ResponseBody
    public ResultPojo  doModify(int id,@RequestBody FreightCost freightCost){
        try{
            Result<FreightCost> result = freightCostService.updateFreightCostById(id,freightCost);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("更新运费成本错误",e);
        }
        return null;
    }

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @RequestMapping(value="/getFreightCostById",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-FreightCost",methods = "GET-BY-ID")
    @ResponseBody
    public ResultPojo getFreightCostById(int id){
        try{
            Result<FreightCost> result = freightCostService.getFreightCostById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id获取运费成本错误",e);
        }
        return null;
    }


}
