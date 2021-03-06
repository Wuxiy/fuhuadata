package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.BusinessInfo;
import com.fuhuadata.domain.query.QueryBusinessInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.BCodeService;
import com.fuhuadata.service.BusinessInfoService;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.vo.BusinessInfoVO;
import com.fuhuadata.web.exception.InvalidRequestException;
import com.fuhuadata.web.util.DateUtil;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * 商机信息
 * Created by intanswer on 2017/3/25.
 */
@Controller
@RequestMapping("/businessInfo/*")
public class BusinessInfoAction {
    private final static org.apache.commons.logging.Log log = LogFactory.getLog(BusinessInfoAction.class);
    @Autowired
    private BusinessInfoService businessInfoService;

    @Autowired
    private BCodeService bCodeService;

    /**
     * into
     * @return
     */
    @RequiresPermissions({"sale:flow:view"})
    @RequestMapping(value="/intoBusinessInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "into")
    public ModelAndView intoBusinessInfo(){
        return new ModelAndView("/salesStatistics/businessOpportunity");
    }

    /**
     * list
     * @param queryBusinessInfo
     * @return
     */
    @RequestMapping(value = "/queryBusinessInfoPageList",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "queryBusinessInfoPageList")
    @ResponseBody
    public ResultPojo queryBusinessInfoPageList(@RequestBody QueryBusinessInfo queryBusinessInfo){
        if(queryBusinessInfo.getCustomerName()==null||"".equals(queryBusinessInfo.getCustomerName())){
            queryBusinessInfo.setCustomerName(null);
        }
        try{
            Result<List<QueryBusinessInfo>> result = businessInfoService.getBusinessInfoByPage(queryBusinessInfo);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("分页条件查询商机列表数据失败",e);
        }
        return null;
    }

    /**
     * count
     * @param queryBusinessInfo
     * @return
     */
    @RequestMapping(value = "/countBusinessList",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "countBusinessList")
    @ResponseBody
    public ResultPojo countBusinessList(@RequestBody QueryBusinessInfo queryBusinessInfo){
        if(queryBusinessInfo.getCustomerName()==null||"".equals(queryBusinessInfo.getCustomerName())){
            queryBusinessInfo.setCustomerName(null);
        }
        try{
            Result<Integer> result = businessInfoService.count(queryBusinessInfo);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("查询商机列表数量错误",e);
        }
        return null;
    }

    /**
     * add
     * @return
     */
    @RequestMapping(value="/AddBusinessInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "intoAdd")
    public ModelAndView intoAddBusinessInfo(){
        String businessId = bCodeService.genNextBusinessCode();
        return new ModelAndView("/salesStatistics/businessOpportunityAdd").addObject("businessId",businessId);
    }


    /**
     * do add
     * @param businessInfo
     * @return
     */
    @RequestMapping(value="/doAddBusinessInfo",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddBusinessInfo(@RequestBody @Valid BusinessInfo businessInfo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("请求参数错误",bindingResult);
        }
        businessInfo.setCreateUserId(LoginUtils.getLoginId());
        businessInfo.setCreateUserName(LoginUtils.getLoginName());
        businessInfo.setCreateTime(DateUtil.getDateTimeFormat());
        businessInfo.setLastmodifyUserId(LoginUtils.getLoginId());
        businessInfo.setLastmodifyUserName(LoginUtils.getLoginName());
        businessInfo.setModifyTime(DateUtil.getDateTimeFormat());
        Result<BusinessInfo> result = new Result<BusinessInfo>();
        try{
            result = businessInfoService.addBusinessInfo(businessInfo);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }


    /**
     * into info
     * @param
     * @return
     */
    @RequiresPermissions({"sale:flow:oppo:view"})
    @RequestMapping(value = "/intoBusinessOpportunityInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "intoinfo")
    @ResponseBody
    public ModelAndView intoBusinessOpportunityInfo(String businessId){
        return new ModelAndView("/salesStatistics/businessOpportunityInfo").addObject("businessId",businessId);
    }
    /**
     *  商机客户信息
     * get by id
     * @param businessId
     * @return
     */
    @RequestMapping(value="/getBusinessInfoById",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "getById")
    @ResponseBody
    public ResultPojo getBusinessInfoById(String  businessId){
        Result<BusinessInfoVO> result = new Result<BusinessInfoVO>();
        try{
            result = businessInfoService.getBusinessInfoByBusinessId(businessId);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * update
     * @param businessInfo
     * @return
     */
    @RequestMapping(value="/updateBusinessInfoById",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "update")
    @ResponseBody
    public ResultPojo updateBusinessInfoById(@RequestBody @Valid BusinessInfo  businessInfo,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("请求参数错误",bindingResult);
        }
        businessInfo.setLastmodifyUserId(LoginUtils.getLoginId());
        businessInfo.setLastmodifyUserName(LoginUtils.getLoginName());
        businessInfo.setModifyTime(DateUtil.getDateTimeFormat());
        Result<BusinessInfo> result = new Result<BusinessInfo>();
        try{
            result = businessInfoService.updateBusinessInfoByBusinessId(businessInfo);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

}
