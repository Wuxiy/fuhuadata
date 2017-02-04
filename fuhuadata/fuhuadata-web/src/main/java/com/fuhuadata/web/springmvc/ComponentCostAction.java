package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.ComponentCost;
import com.fuhuadata.domain.query.ComponentCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.ComponentCostService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import com.sun.javafx.sg.prism.NGShape;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
