package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.BusinessInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.BCodeService;
import com.fuhuadata.service.BusinessInfoService;
import com.fuhuadata.vo.BusinessInfoVO;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
    @RequestMapping(value="/intoBusinessInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "into")
    public ModelAndView intoBusinessInfo(){
        return new ModelAndView("/salesStatistics/businessOpportunity");
    }

    /**
     * list
     * @param businessInfoVO
     * @return
     */
    @RequestMapping(value = "/queryBusinessInfoPageList",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "queryBusinessInfoPageList")
    @ResponseBody
    public ResultPojo queryBusinessInfoPageList(@RequestBody BusinessInfoVO businessInfoVO){
        if(businessInfoVO.getCustomerName()==null||"".equals(businessInfoVO.getCustomerName())){
            businessInfoVO.setCustomerName(null);
        }
        try{
            Result<List<BusinessInfoVO>> result = businessInfoService.getBusinessInfoByPage(businessInfoVO);
            return result.getResultPojo();
        }catch (Exception e){
            log.error("分页条件查询商机列表数据失败",e);
        }
        return null;
    }

    /**
     * count
     * @param businessInfoVO
     * @return
     */
    @RequestMapping(value = "/countBusinessList",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "countBusinessList")
    @ResponseBody
    public ResultPojo countBusinessList(@RequestBody BusinessInfoVO businessInfoVO){
        try{
            Result<Integer> result = businessInfoService.count(businessInfoVO);
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
        String businessId = bCodeService.getNextBusinessCode();
        return new ModelAndView("/businessInfoAdd").addObject("businessId",businessId);
    }


    /**
     * do add
     * @param businessInfo
     * @return
     */
    @RequestMapping(value="/doAddBusinessInfo",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "doAdd")
    @ResponseBody
    public ResultPojo doAddBusinessInfo(@RequestBody BusinessInfo businessInfo){
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
    @RequestMapping(value = "/intoBusinessOpportunityInfo",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "intoinfo")
    @ResponseBody
    public ModelAndView intoBusinessOpportunityInfo(){
        return new ModelAndView("/salesStatistics/businessOpportunityInfo");
    }
    /**
     * get by id
     * @param businessId
     * @return
     */
    @RequestMapping(value="/getBusinessInfoById",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "getById")
    @ResponseBody
    public ResultPojo getBusinessInfoById(String  businessId){
        Result<BusinessInfo> result = new Result<BusinessInfo>();
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
    public ResultPojo updateBusinessInfoById(@RequestBody BusinessInfo  businessInfo){
        Result<BusinessInfo> result = new Result<BusinessInfo>();
        try{
            result = businessInfoService.updateBusinessInfoByBusinessId(businessInfo);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

}
