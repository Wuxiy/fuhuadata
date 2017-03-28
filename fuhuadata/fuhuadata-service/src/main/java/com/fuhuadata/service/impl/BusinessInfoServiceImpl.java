package com.fuhuadata.service.impl;

import com.fuhuadata.domain.BusinessInfo;
import com.fuhuadata.domain.query.QueryBusinessInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.BusinessInfoManager;
import com.fuhuadata.service.BusinessInfoService;
import com.fuhuadata.vo.BusinessInfoVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 商机信息
 * Created by intanswer on 2017/3/25.
 */
public class BusinessInfoServiceImpl implements BusinessInfoService {
    private static final Log log = LogFactory.getLog(BusinessInfoServiceImpl.class);

    @Autowired
    private BusinessInfoManager businessInfoManager;
    @Override
    public Result<BusinessInfo> addBusinessInfo(BusinessInfo businessInfo) {
        Result<BusinessInfo> result = new Result<BusinessInfo>();
        try{
            result.addDefaultModel("BusinessInfo",businessInfoManager.addBusinessInfo(businessInfo));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("新增商机信息出错",e);
        }
        return result;
    }

    @Override
    public Result updateBusinessInfoByBusinessId(BusinessInfo businessInfo) {
        Result result = new Result();
        try{
            result.setSuccess(businessInfoManager.updateBusinessInfoByBusinessId(businessInfo));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("更新商机信息出错",e);
        }
        return result;
    }

    @Override
    public Result deleteBusinessInfoByBusinessId(String businessId) {
        Result result = new Result();
        try{
            result.setSuccess(businessInfoManager.deleteBusinessInfoByBusinessId(businessId));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id删除商机信息出错",e);
        }
        return result;
    }

    @Override
    public Result<BusinessInfo> getBusinessInfoByBusinessId(String businessId) {
        Result<BusinessInfo> result = new Result<BusinessInfo>();
        try{
            BusinessInfo businessInfo = businessInfoManager.getBusinessInfoByBusinessId(businessId);
            if(businessId==null){
                result.setSimpleErrorMsg(0,"当前数据不存在，请重试");
            }else {
                result.addDefaultModel("BusinessInfo", businessInfo);
            }
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据商机ID获取商机信息出错",e);
        }
        return result;
    }

    @Override
    public Result<List<BusinessInfo>> getBusinessInfoByCustomerId(String customerId) {
        Result<List<BusinessInfo>> result = new Result<List<BusinessInfo>>();
        try{
            result.addDefaultModel("BusinessInfos",businessInfoManager.getBusinessInfoByCustomerId(customerId));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据客户ID获取商机列表出错",e);
        }
        return result;
    }

    @Override
    public Result<List<BusinessInfo>> getBusinessInfoByQuery(QueryBusinessInfo queryBusinessInfo) {
        Result<List<BusinessInfo>> result = new Result<List<BusinessInfo>>();
        try{
            result.addDefaultModel("BusinessInfos",businessInfoManager.getBusinessInfoByQuery(queryBusinessInfo));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("条件查询商机列表出错",e);
        }
        return result;
    }

    @Override
    public Result<List<BusinessInfoVO>> getBusinessInfoByPage(BusinessInfoVO businessInfoVO) {
        Result<List<BusinessInfoVO>> result = new Result<List<BusinessInfoVO>>();
        try{
            result.addDefaultModel("BusinessInfos",businessInfoManager.getBusinessInfoByPage(businessInfoVO));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("分页条件查询商机列表出错",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(QueryBusinessInfo queryBusinessInfo) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(businessInfoManager.count(queryBusinessInfo));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("条件查询商机数量出错",e);
        }
        return result;
    }
}
