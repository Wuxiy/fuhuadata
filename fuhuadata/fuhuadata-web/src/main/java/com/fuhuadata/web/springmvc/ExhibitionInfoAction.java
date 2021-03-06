package com.fuhuadata.web.springmvc;


import com.fuhuadata.domain.ExhibitionInfo;
import com.fuhuadata.domain.query.ExhibitionInfoQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.ExhibitionInfoService;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.web.util.DateUtil;
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
 * 展会动态action
 * Created by wuxi on 2017/1/13.
 */

@Controller
@RequestMapping("/exhibitionInfo/*")
public class    ExhibitionInfoAction {
    private final static Log log = LogFactory.getLog(ExhibitionInfoAction.class);
    @Resource
    private ExhibitionInfoService exhibitionInfoService;
    private Integer pageSize=20;
    private String page="1";

    /**
     * init
     * @return
     */
    @RequiresPermissions({"wiki:state:view"})
    @RequestMapping(value="/exhibitionInfoList")
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "into")
    public ModelAndView exhibitionInfo(){
        return new ModelAndView("knowledgeBase/exhibitionInfoList");
    }



    @RequestMapping(value = "/queryExhibitionInfoList",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "list")
    @ResponseBody
    public ResultPojo exhibitionInfoList(@RequestBody ExhibitionInfoQuery exhibitionInfoQuery){
        Result<List<ExhibitionInfo>> result = new Result<List<ExhibitionInfo>>();
        try{
            //加入权限代码，设置查询条件
            result=exhibitionInfoService.getExhibitionInfosByQuery(exhibitionInfoQuery);
        }catch (Exception e){
            log.error("获取展会动态列表错误",e);
        }
        return result.getResultPojo();
    }

    @RequestMapping(value = "/count",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "count")
    @ResponseBody
    public ResultPojo count(@RequestBody ExhibitionInfoQuery exhibitionInfoQuery){
        Result<Integer> result = new Result<Integer>();
        try{
            //加入权限代码，设置查询条件
            result=exhibitionInfoService.count(exhibitionInfoQuery);
        }catch (Exception e){
            log.error("获取展会动态列表总数错误",e);
        }
        return result.getResultPojo();
    }



    @RequestMapping(value="/addExhibitionInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "add")
    public ModelAndView addExhibitionInfo(){
        return new ModelAndView("knowledgeBase/exhibitionInfoAdd");
    }


    @RequestMapping(value = "/doAddExhibitionInfo",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddExhibitionInfo(@RequestBody ExhibitionInfo exhibitionInfo){
        try{
            exhibitionInfo.setCreatorId(LoginUtils.getLoginId());
            exhibitionInfo.setCreator(LoginUtils.getLoginName());
            exhibitionInfo.setCreateTime(DateUtil.getDateTimeFormat());
            exhibitionInfo.setLastmodifyUserId(LoginUtils.getLoginId());
            exhibitionInfo.setLastmodifyUserName(LoginUtils.getLoginName());
            exhibitionInfo.setModifyTime(DateUtil.getDateTimeFormat());
            Result<ExhibitionInfo> result = exhibitionInfoService.addExhibitionInfo(exhibitionInfo);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("添加展会动态记录失败",e);
        }
        return null;
    }

    @RequestMapping(value = "/deleteExhibitionInfo",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods ="delete" )
    @ResponseBody
    public ResultPojo deleteExhibitionInfo(int id){
        try{
            Result result =exhibitionInfoService.deleteExhibitionInfoById(id);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("根据id删除展会信息错误");
        }
        return null;
    }
    @RequestMapping(value = "/modifyExhibitionInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods="update")
    public ModelAndView modifyExhibitonInfo(int id){
        Result<ExhibitionInfo> result = new Result<ExhibitionInfo>();
        try{
            result = exhibitionInfoService.getExhibitionInfoById(id);
        }catch (Exception e){
            result.setSuccess(false);
            log.error("根据id获取展会详情错误");
        }

        return new ModelAndView("knowledgeBase/exhibitionInfo").addObject("exhibition",result.getModel()).addObject("id",id);
    }

    @RequestMapping(value = "/doModifyExhibitionInfo",method =RequestMethod.POST)
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "doUpdate")
    @ResponseBody
    public ResultPojo doModifyExhibitionInfo(@RequestBody ExhibitionInfo exhibitionInfo){
        try{
            exhibitionInfo.setLastmodifyUserId(LoginUtils.getLoginId());
            exhibitionInfo.setLastmodifyUserName(LoginUtils.getLoginName());
            exhibitionInfo.setModifyTime(DateUtil.getDateTimeFormat());
            int id = exhibitionInfo.getExhibitionId();
            Result<ExhibitionInfo> result = exhibitionInfoService.updateExhibitionInfoById(id,exhibitionInfo);
            return result.getResultPojo();
        }catch(Exception e){
            log.error("修改展会动态错误",e);
        }
        return null;
    }

    @RequestMapping(value = "/getExhibitionInfoById")
    @SystemLogAnnotation(module = "knowledgeBase-ExhibitionInfo",methods = "GET-BY-ID")
    @ResponseBody
    public ExhibitionInfo getExhibitionInfoById(int id){
        try{
            Result<ExhibitionInfo> result = exhibitionInfoService.getExhibitionInfoById(id);
            return result.getModel();
         }catch(Exception e){
            log.error("获取展会信息错误",e);
        }
        return null;
    }
}
