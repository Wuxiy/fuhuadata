package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.supplier.WarehouseInfoService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/** 仓库
 * Created by wuxiy on 2017/5/23.
 */
@Controller
@RequestMapping("/supplier/warehouse/*")
public class WarehouseInfoController extends BaseController<WarehouseInfo,Integer>{

    private final static Log log  = LogFactory.getLog(WarehouseInfoController.class);


    @Autowired
    private WarehouseInfoService warehouseInfoService;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "init")
    public String intoForwarding() {
        return "supplier/warehouseInfoList";
    }

    /**
     * 仓库列表
     * @param startRow
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/warehouseList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "warehouseList")
    @ResponseBody
    public ResultPojo warehouseList(@RequestParam("startRow") Integer startRow,
                                     @RequestParam("pageSize") Integer pageSize ){
        Result<List<WarehouseInfo>> result = new Result<>();
        try{

            result.addDefaultModel("warehouseList",warehouseInfoService.list());
        }catch(Exception e){
            log.error("分页获取仓库列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 仓库详情
     * @return
     */
    @RequestMapping(value = "/warehouseInfo", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "warehouseInfo")
    @ResponseBody
    public ResultPojo warehouseList(@RequestParam("id") Integer id){
        Result<WarehouseInfo> result = new Result<>();
        try{
            result.addDefaultModel("warehouseInfo",warehouseInfoService.get(id));
        }catch(Exception e){
            log.error("根据仓库id获取仓库详情",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }



}
