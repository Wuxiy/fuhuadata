package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.IndustryData;
import com.fuhuadata.domain.query.IndustryDataQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.IndustryDataService;
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


    /**
     * init
     * @return
     */
    @RequestMapping(value = "/industryDataList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-industryData",methods = "into")
    public ModelAndView IndustryData(){
        return new ModelAndView("knowledgeBase/industryDataList");
    }

    @RequestMapping(value = "/queryIndustryDataList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-industryData",methods = "list")
    @ResponseBody
    public ResultPojo IndustryDataList(){
        Result<List<IndustryData>> result = new Result<List<IndustryData>>();
        IndustryDataQuery industryDataQuery = new IndustryDataQuery();
        try{
            result=industryDataService.getIndustryDataByQuery(industryDataQuery);
        }catch(Exception e){
            log.error("获取行业数据列表错误");
        }
        return result.getResultPojo();
    }

    @RequestMapping(value = "/addIndustryData",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-industryData",methods = "add")
    public ModelAndView addIndustryData(){
        return new ModelAndView("knowledgeBase/addIndustryData");
    }

    @RequestMapping(value = "/addIndustryData",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-industryData",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddIndustryData(@RequestBody IndustryData industryData){
        try{
            Result<IndustryData> result = industryDataService.addIndustryData(industryData);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("添加行业数据失败",e);
        }
        return null;
    }



    @SuppressWarnings("unused")
    @RequestMapping(value = "/queryIndustryDataListTest",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-industryData",methods = "query")
    public ModelAndView queryIndustryDataList(@RequestBody IndustryDataQuery industryDataQuery){
        Result<List<IndustryData>> result = new Result<List<IndustryData>>();
        try{
            industryDataQuery.setPageSize(pageSize);
            if(industryDataQuery.getIndex()==0){
                industryDataQuery.setIndex(Integer.valueOf(page.trim()));
            }
            result=industryDataService.getIndustryDatasByPage(industryDataQuery);
        }catch(Exception e){
            log.error("条件查询行业数据失败",e);
        }
        ModelAndView model=new ModelAndView("knowledgeBase/industryDataList","industryDataList",result.getModel());
        model.addObject("message","行业数据列表");
        return  model;
    }


}
