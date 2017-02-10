package com.fuhuadata.web.springmvc;


import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.SystemLog;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.ExhibitionInfoService;
import com.fuhuadata.web.util.DateUtil;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.text.ParseException;
import java.util.List;

/**
 * 展会动态action
 * Created by wuxi on 2017/1/13.
 */

@Controller
@RequestMapping("/exhibitionInfo/*")
public class    ExhibitionInfoAction {
    private final static Log log = LogFactory.getLog(ExhibitionInfoAction.class);
    @Resource
    private ExhibitionInfoService exhibitionInfoService;
    private Integer pageSize=5;
    private String page="1";


    @SuppressWarnings("unused")
    @RequestMapping(value = "/exhibitionInfoList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-展会动态",methods = "展会列表")
    public ModelAndView exhibitionInfoList(){
        Result<List<ExhibitionInfo>> result = new Result<List<ExhibitionInfo>>();
        try{
            ExhibitionInfoQuery exhibitionInfoQuery = new ExhibitionInfoQuery();
            exhibitionInfoQuery.setPageSize(pageSize);
            try {
                exhibitionInfoQuery.setIndex(Integer.valueOf(page));
            }catch (Exception e){
                exhibitionInfoQuery.setIndex(1);
            }
            result=exhibitionInfoService.getExhibitionInfosByPage(exhibitionInfoQuery);
        }catch (Exception e){
            log.error("获取展会列表失败",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/exhibitionInfoList","exhibitionInfoList",result.getModel());
        model.addObject("message","展会动态列表");
        model.addObject("queryCondition",null);
        return model;
    }

    @RequestMapping(value = "/queryExhibitionInfoList",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-展会动态",methods = "条件查询")
    public ModelAndView queryExhibitionInfoList(@RequestBody ExhibitionInfoQuery exhibitionInfoQuery){
        Result<List<ExhibitionInfo>> result = new Result<List<ExhibitionInfo>>();
        try{
            exhibitionInfoQuery.setPageSize(pageSize);
            if(exhibitionInfoQuery.getIndex()==0){
                exhibitionInfoQuery.setIndex(Integer.valueOf(page.trim()));
            }
            result=exhibitionInfoService.getExhibitionInfosByPage(exhibitionInfoQuery);
        }catch (Exception e){
            log.error("查询获取展会信息失败",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/exhibitionInfoList","exhibitionInfoList",result.getModel());
        model.addObject("totalItem",result.getTotalItem());
        model.addObject("message","展会动态列表");
        return model;
    }

    @RequestMapping(value = "/queryExhibitionInfo",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-展会动态",methods = "条件查询")
    public ModelAndView queryExhibitionInfo(String index,String exhibitionName){
        ExhibitionInfoQuery exhibitionInfoQuery = new ExhibitionInfoQuery();
        Result<List<ExhibitionInfo>> result = new Result<List<ExhibitionInfo>>();
        try{
            exhibitionInfoQuery.setPageSize(pageSize);
            //out
            System.out.println(index);
            System.out.println(exhibitionName);
            if(index==null){
                exhibitionInfoQuery.setIndex(Integer.valueOf(page.trim()));
            }else{
            exhibitionInfoQuery.setIndex(Integer.valueOf(index.trim()));
            }
            exhibitionInfoQuery.setExhibitionName(exhibitionName);
            result=exhibitionInfoService.getExhibitionInfosByPage(exhibitionInfoQuery);
        }catch (Exception e){
            log.error("条件查询获取展会信息失败",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/exhibitionInfoList","exhibitionInfoList",result.getModel());
        model.addObject("totalItem",result.getTotalItem());
        if(exhibitionName!=null){
        model.addObject("queryCondition",exhibitionInfoQuery);}
        model.addObject("message","展会动态列表");
        return model;
    }

    @RequestMapping(value="/addExhibitionInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-展会动态",methods = "新增展会动态")
    public ModelAndView addExhibitionInfo(){
        return new ModelAndView("knowledgeBase/exhibitionInfoAdd");
    }


    @RequestMapping(value = "/doAddExhibitionInfo",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "知识库-展会动态",methods = "执行新增")
    @ResponseBody
    public ResultPojo doAddExhibitionInfo(@RequestBody ExhibitionInfo exhibitionInfo){
        System.out.println("执行新增");
        try{
            Result<ExhibitionInfo> result = exhibitionInfoService.addExhibitionInfo(exhibitionInfo);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("添加展会动态记录失败",e);
        }
        return null;
    }

}
