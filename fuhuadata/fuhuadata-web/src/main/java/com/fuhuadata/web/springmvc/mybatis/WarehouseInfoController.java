package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.supplier.FreightForwarding;
import com.fuhuadata.domain.mybatis.supplier.WarehouseInfo;
import com.fuhuadata.domain.query.QueryFreightforwarding;
import com.fuhuadata.domain.query.QueryWarehouseInfo;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.supplier.FreightForwardingService;
import com.fuhuadata.service.mybatis.supplier.WarehouseInfoService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/** 仓库
 * Created by wuxiy on 2017/5/23.
 */
@Controller
@RequestMapping("/supplier/warehouse/*")
public class WarehouseInfoController extends BaseController<WarehouseInfo,Integer>{

    private final static Log log  = LogFactory.getLog(WarehouseInfoController.class);


    @Autowired
    private WarehouseInfoService warehouseInfoService;

    @Autowired
    private FreightForwardingService freightForwardingService;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "init")
    public String intoForwarding() {
        return "supplier/warehouseInfoList";
    }

    /**
     * 仓库列表
     * @return
     */
    @RequestMapping(value = "/warehouseList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "warehouseList")
    @ResponseBody
    public ResultPojo warehouseList(QueryWarehouseInfo query){
        Result<PageInfo<WarehouseInfo>> result = new Result<>();
        try{
            PageInfo<WarehouseInfo> warehouses  = warehouseInfoService.listWarehouses(query);
            result.addDefaultModel("warehouseList",warehouses);
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

    /**
     * 仓库关联货代
     * @return
     */
    @RequestMapping(value = "/forwardingList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-warehouse",methods = "warehouseInfo")
    @ResponseBody
    public ResultPojo forwardingList(QueryFreightforwarding query){
        Result<PageInfo<FreightForwarding>> result = new Result<>();
        try{
            result.addDefaultModel("warehouseInfo",freightForwardingService.getForwardingListByWarehouseId(query));
        }catch(Exception e){
            log.error("获取关联货代列表错误",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    


}

