package com.fuhuadata.web.springmvc;


import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.ExhibitionInfoService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
        return model;
    }

    @RequestMapping(value = "/queryExhibitionInfoList",method = RequestMethod.GET)
    @ResponseBody
    @SystemLogAnnotation(module = "知识库-展会动态",methods = "展会列表")
    public ModelAndView queryExhibitionInfoList(@RequestBody ExhibitionInfoQuery exhibitionInfoQuery){
        Result<List<ExhibitionInfo>> result = new Result<List<ExhibitionInfo>>();
        try{
            exhibitionInfoQuery.setPageSize(pageSize);
            try {
                exhibitionInfoQuery.setIndex(Integer.valueOf(page));
            }catch (Exception e){
                exhibitionInfoQuery.setIndex(1);
            }
            result=exhibitionInfoService.getExhibitionInfosByPage(exhibitionInfoQuery);
        }catch (Exception e){
            log.error("查询获取展会信息失败",e);
        }
        ModelAndView model = new ModelAndView("knowledgeBase/exhibitionInfoList","exhibitionInfos",result.getModel());
        model.addObject("message","展会动态列表");
        return model;
    }

    @RequestMapping(value="/addExhibitionInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-展会动态",methods = "新增展会动态")
    public ModelAndView addExhibitionInfo(){
        return new ModelAndView("knowledgeBase/addExhibitionInfo");
    }

    @RequestMapping(value = "/doAddExhibitionInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "知识库-展会动态",methods = "新增展会动态记录")
    @ResponseBody
    public ResultPojo doAddExhibitionInfo(@RequestBody ExhibitionInfo exhibitionInfo){
        try{
            Result<ExhibitionInfo> result = exhibitionInfoService.addExhibitionInfo(exhibitionInfo);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("添加展会动态记录失败",e);
        }
        return null;
    }




}
