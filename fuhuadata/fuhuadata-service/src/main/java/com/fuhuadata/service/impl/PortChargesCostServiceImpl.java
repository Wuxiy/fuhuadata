package com.fuhuadata.service.impl;

import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.query.PortChargesCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PortChargesCostManager;
import com.fuhuadata.service.PortChargesCostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * 港杂费service
 * Created by intanswer on 2017/1/18.
 */
public class PortChargesCostServiceImpl implements PortChargesCostService {
    private static final Log log= LogFactory.getLog(PortChargesCostServiceImpl.class);
    private PortChargesCostManager portChargesCostManager;
    @Override
    public Result<PortChargesCost> addPortChargesCost(PortChargesCost portChargesCost) {
        Result<PortChargesCost> result = new Result<PortChargesCost>();
        try{
            result.addDefaultModel(portChargesCostManager.addPortChargesCost(portChargesCost));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("添加港杂费信息错误",e);
        }
        return result;
    }

    @Override
    public Result<List<PortChargesCost>> getPortChargesCostsByPage(PortChargesCostQuery portChargesCostQuery) {
        Result<List<PortChargesCost>> result = new Result<List<PortChargesCost>>();
        try{
            result = portChargesCostManager.getPortChargesCostsByPage(portChargesCostQuery);
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("分页获取港杂费信息错误",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(PortChargesCostQuery portChargesCostQuery) {
        Result<Integer> result = new Result<Integer>();
        try{
            result.addDefaultModel(portChargesCostManager.count(portChargesCostQuery));
        }catch (Exception e){
            result.setSuccess(false);
            //打印日志
            log.error("查询港杂费数量错误",e);
        }
        return result;
    }

    public void setPortChargesCostManager(PortChargesCostManager portChargesCostManager) {
        this.portChargesCostManager = portChargesCostManager;
    }
    public PortChargesCostManager getPortChargesCostManager(){
        return this.portChargesCostManager;
    }
}
