package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.IndustryData;
import com.fuhuadata.domain.query.IndustryDataQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.service.IndustryDataService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 行业数据action
 * Created by intanswer on 2017/1/24.
 */
@Controller
@RequestMapping("/industryData/*")
public class IndustryDataAction {
    private final static Log log= LogFactory.getLog(IndustryDataAction.class);
    @Resource
    private IndustryDataService industryDataService;
    private Integer pageSize = 10;
    private String page="1";
    @SuppressWarnings("unused")
    @RequestMapping(value = "/industryDataList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-行业数据",methods = "查看列表")
    public ModelAndView IndustryDataList(){
        Result<List<IndustryData>> result = new Result<List<IndustryData>>();
        try{
            IndustryDataQuery industryDataQuery = new IndustryDataQuery();
            industryDataQuery.setPageSize(pageSize);
            try{
                industryDataQuery.setIndex(Integer.valueOf(page.trim()));
            }catch(Exception e){
                industryDataQuery.setIndex(1);
            }
            result=industryDataService.getIndustryDatasByPage(industryDataQuery);
        }catch(Exception e){
            log.error("获取行业数据列表错误");
        }
        ModelAndView model= new ModelAndView("knowledgeBase/industryDataList","industryDataList",result.getModel());
        model.addObject("message","行业数据列表");
        return model;
    }

}
