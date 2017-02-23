package com.fuhuadata.service.impl;

import com.fuhuadata.domain.PortChargesCost;
import com.fuhuadata.domain.query.PortChargesCostQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PortChargesCostManager;
import com.fuhuadata.service.PortChargesCostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sound.sampled.Port;
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
    public Result updatePortChargesCostById(int id, PortChargesCost portChargesCost) {
        Result result= new Result();
        try{
            result.setSuccess(portChargesCostManager.updatePortChargesCostById(id,portChargesCost));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("修改港杂费信息错误",e);
        }
        return result;
    }

    @Override
    public Result deletePortChargesCostById(int id) {
        Result result= new Result();
        try{
            result.setSuccess(portChargesCostManager.deletePortChargesCostById(id));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id删除港杂费信息错误",e);
        }
        return result;
    }

    @Override
    public Result<PortChargesCost> getPortChargesCostById(int id) {
        Result<PortChargesCost> result = new Result<PortChargesCost>();
        try{
            PortChargesCost portChargesCost = portChargesCostManager.getPortChargesCostById(id);
            if(portChargesCost == null){
                result.setSimpleErrorMsg(0,"当前港杂费数据不存在，请重试");
            }else{
                result.addDefaultModel("PortChargesCost",portChargesCost);
            }
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据id获取港杂费数据错误",e);
        }
        return result;
    }

    @Override
    public List<PortChargesCost> getAllPortChargesCosts() {
        return portChargesCostManager.getAllPortChargesCosts();
    }

    @Override
    public Result<List<PortChargesCost>> getPortChargesCostsByQuery(PortChargesCostQuery portChargesCostQuery) {
        Result<List<PortChargesCost>> result = new Result<List<PortChargesCost>>();
        try{
            result.addDefaultModel("PortChargesCosts",portChargesCostManager.getPortChargesCostByQuery(portChargesCostQuery));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("查询港杂费信息错误",e);
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
