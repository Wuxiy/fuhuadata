package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.FreightCost;
import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.PreparationProcessCost;
import com.fuhuadata.domain.query.*;
import com.fuhuadata.service.ComponentCostService;
import com.fuhuadata.service.FreightCostService;
import com.fuhuadata.service.PortChargesCostService;
import com.fuhuadata.service.PreparationProcessCostService;
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
 * 加工成本
 * Created by intanswer on 2017/2/8.
 */
@Controller
@RequestMapping(value = "/processCostList/*")
public class ProcessCostListAction {

    private final static Log log = LogFactory.getLog(ProcessCostListAction.class);
    @Resource
    private PreparationProcessCostService preparationProcessCostService;
    @Resource
    private PortChargesCostService portChargesCostService;
    @Resource
    private ComponentCostService componentCostService;
    @Resource
    private FreightCostService freightCostService;
    private Integer pageSize=5;
    private String page="1";

    /**
     * 制剂加工成本list
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/preparationProcessCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-制剂加工费",methods = "制剂加工费列表")
    public ModelAndView preparationProcessCostList(){
        Result<List<PreparationProcessCost>> result = new Result<List<PreparationProcessCost>>();
        try{
            PreparationProcessCostQuery query = new PreparationProcessCostQuery();
            query.setPageSize(pageSize);
            try{
                query.setIndex(Integer.valueOf(page));
            }catch(Exception e){
                query.setIndex(1);
            }
            result= preparationProcessCostService.getPreparationProcessCostsByPage(query);
        }catch(Exception e){
            log.error("获取制剂加工费列表错误",e);
        }
        ModelAndView model= new ModelAndView("knowledgeBase/preparationProcessCostList","preparationProcessCosts",result.getModel());
        model.addObject("message","制剂加工费列表");
        return model;
    }

    @RequestMapping(value = "/addPreparationProcessCost",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-制剂加工费",methods = "新增制剂加工费")
    public ModelAndView addPreparationProcessCost(){
        return new ModelAndView("knowledgeBase/addPreparationProcessCost");
    }

    /**
     * 制剂加工add
     * @param preparationProcessCost
     * @return
     */
    @RequestMapping(value = "/doAddPreparationProcessCost",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-制剂加工费",methods = "执行新增")
    @ResponseBody
    public ResultPojo doAddPreparationProcessCost(@RequestBody PreparationProcessCost preparationProcessCost){
        try{
            Result<PreparationProcessCost> result = preparationProcessCostService.addPreparationProcessCost(preparationProcessCost);
            return result.getResultPojo();
        }catch(Exception e){

            log.error("添加制剂加工费失败",e);
        }
        return null;
    }

    /**
     * 制剂加工成本条件查询
     * @param preparationProcessCostQuery
     * @return
     */
    @RequestMapping(value = "/queryPreparationProcessCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-制剂加工费",methods = "条件查询")
    public ModelAndView queryPreparationProcessCostList(@RequestBody PreparationProcessCostQuery preparationProcessCostQuery){
        Result<List<PreparationProcessCost>> result = new Result<List<PreparationProcessCost>>();
        try{
            preparationProcessCostQuery.setPageSize(pageSize);
            if(preparationProcessCostQuery.getIndex()==0){
                preparationProcessCostQuery.setIndex(Integer.valueOf(page.trim()));
            }
            result=preparationProcessCostService.getPreparationProcessCostsByPage(preparationProcessCostQuery);
        }catch(Exception e){
            log.error("制剂加工费查询失败",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/preparationProcessCostList","preparationProcessCostList",result.getModel());
        model.addObject("message","制剂加工成本");
        return model;
    }

    /**
     * 港杂费成本list
     * @return
     */
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
        ModelAndView model= new ModelAndView("knowledgeBase/portChargesCostList","portChargesCostList",result.getModel());
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

    /**
     * 条件查询港杂费
     * @param portChargesCostQuery
     * @return
     */
    @RequestMapping(value = "/queryPortChargesCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-港杂费",methods = "条件查询")
    public ModelAndView queryPortChargesCostList(@RequestBody PortChargesCostQuery portChargesCostQuery){
        Result<List<PortChargesCost>> result = new Result<List<PortChargesCost>>();
        try{
            portChargesCostQuery.setPageSize(pageSize);
            if(portChargesCostQuery.getIndex()==0){
                portChargesCostQuery.setIndex(Integer.valueOf(page.trim()));
            }
            result=portChargesCostService.getPortChargesCostsByPage(portChargesCostQuery);
        }catch(Exception e){
            log.error("港杂费查询失败",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/portChargesCostList","portChargesCostList",result.getModel());
        model.addObject("message","港杂费列表");
        return model;
    }

    /**
     * 成分价格列表
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

    /**
     * 运费列表
     * @return
     */
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

    /**
     * 运费新增
     * @return
     */
    @RequestMapping(value = "/addFreightCost",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-运费",methods = "新增运费")
    public ModelAndView addFreightCost(){
        return new ModelAndView("knowledgeBase/addFreightCost");
    }

    /**
     * 运费执行新增
     * @param freightCost
     * @return
     */
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

    /**
     * 运费条件查询
     * @param freightCostQuery
     * @return
     */
    @RequestMapping(value = "/queryFreightCostList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-运费",methods = "条件查询")
    public ModelAndView queryFreightCostList(@RequestBody FreightCostQuery freightCostQuery){
        Result<List<FreightCost>> result = new Result<List<FreightCost>>();
        try{
            freightCostQuery.setPageSize(pageSize);

            if(freightCostQuery.getIndex()==0){
                freightCostQuery.setIndex(Integer.valueOf(page.trim()));
            }
            result=freightCostService.getFreightCostsByPage(freightCostQuery);
        }catch(Exception e){
            log.error("条件查询运费失败",e);
        }
        ModelAndView model=new ModelAndView("knowledgeBase/freightCostList","freightCostList",result.getModel());
        model.addObject("message","运费列表");
        return model;
    }

}
