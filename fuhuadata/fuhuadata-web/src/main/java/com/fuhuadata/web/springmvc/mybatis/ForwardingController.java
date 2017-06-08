package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.supplier.*;
import com.fuhuadata.domain.query.*;
import com.fuhuadata.service.mybatis.supplier.*;
import com.fuhuadata.web.util.SystemLogAnnotation;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 *    货代物流
 * Created by wuxiy on 2017/5/23.
 */
@Controller
@RequestMapping("/supplier/forwarding/*")
public class ForwardingController extends BaseController<FreightForwarding,Integer> {
    private final static Log log  = LogFactory.getLog(ForwardingController.class);

    @Autowired
    private FreightForwardingService freightForwardingService;

    @Autowired
    private WarehouseInfoService warehouseInfoService;

    @Autowired
    private ForwardingBidRecordService forwardingBidRecordService;

    @Autowired
    private ForwardingOrderRecordService forwardingOrderRecordService;

    @Autowired
    private ForwardingComplaintsRecordService forwardingComplaintsRecordService;


    @RequestMapping(value = "init", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "init")
    public String intoForwarding() {
        return "supplier/forwardingList";
    }

    /**
     * 货代列表
     * @return
     */
    @RequestMapping(value = "/forwardingList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingList")
    @ResponseBody
    public ResultPojo forwardingList(QueryFreightforwarding query){
        Result<PageInfo<FreightForwarding>> result = new Result<>();
        try{
            PageInfo<FreightForwarding> forwardings  = freightForwardingService.getForwardingList(query);
            result.addDefaultModel("forwardingList",forwardings);
        }catch(Exception e){
            log.error("分页获取货代列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    @RequestMapping(value = "intoForwardingInfo", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "init")
    public String intoForwardingInfo() {
        return "/supplier/forwardingBasic";
    }

    /**
     * 货代详情
     * @return
     */
    @RequestMapping(value = "forwardingInfo", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingInfo")
    @ResponseBody
    public ResultPojo forwardingList(@RequestParam("id") Integer id){
        Result<FreightForwarding> result = new Result<>();
        try{
            result.addDefaultModel("forwardingInfo",freightForwardingService.getFreightForwardingInfo(id));
        }catch(Exception e){
            log.error("根据id获取货代详情出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 更新货代
     * @return
     */
    @RequestMapping(value = "updateForwardingInfo", method = RequestMethod.POST)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "updateForwardingInfo")
    @ResponseBody
    public ResultPojo updateForwardingInfo(@RequestBody FreightForwarding freightForwarding){
        Result<Integer> result = new Result<>();
        try{
            result.addDefaultModel("forwardingInfo",freightForwardingService.updateSelective(freightForwarding));
        }catch(Exception e){
            log.error("更新货代详情出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }


    /**
     * 关联仓库列表
     * @return
     **/
    @RequestMapping(value = "/warehouseList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingList")
    @ResponseBody
    public ResultPojo forwardingList(QueryWarehouseInfo query){
        Result<PageInfo<WarehouseInfo>> result = new Result<>();
        try{
            PageInfo<WarehouseInfo> warehouseInfoList  = warehouseInfoService.getListByForwardingId(query);
            result.addDefaultModel("forwardingList",warehouseInfoList);
        }catch(Exception e){
            log.error("获取关联仓库列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 竞标记录list
     */
    @RequestMapping(value = "/forwardingBidRecordList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingBidRecordList")
    @ResponseBody
    public ResultPojo forwardingBidRecordList(QueryForwardBidRecord query){
        Result<PageInfo<ForwardingBidRecord>> result = new Result<>();
        try{
            PageInfo<ForwardingBidRecord> list = forwardingBidRecordService.getForwardingBidRecordList(query);
            result.addDefaultModel(list);
        }catch(Exception e){
            log.error("获取竞标记录列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 订单记录list
     */
    @RequestMapping(value = "/forwardingOrderRecordList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingOrderRecordList")
    @ResponseBody
    public ResultPojo forwardingOrderRecordList(QueryForwardingOrderRecord query){
        Result<PageInfo<ForwardingOrderRecord>> result = new Result<>();
        try{
            PageInfo<ForwardingOrderRecord> list = forwardingOrderRecordService.getForwardingOrderRecordList(query);
            result.addDefaultModel(list);
        }catch(Exception e){
            log.error("获取订单记录列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 投诉记录list
     */
    @RequestMapping(value = "/forwardingComplaintsRecordList", method = RequestMethod.GET)
    @SystemLogAnnotation(module = "supplier-forwarding",methods = "forwardingComplaintsRecordList")
    @ResponseBody
    public ResultPojo forwardingComplaintsRecordList(QueryForwardingComplaintsRecord query){
        Result<PageInfo<ForwardingComplaintsRecord>> result = new Result<>();
        try{
            PageInfo<ForwardingComplaintsRecord> list = forwardingComplaintsRecordService.getForwardingComplaintsRecordList(query);
            result.addDefaultModel(list);
        }catch(Exception e){
            log.error("获取投诉记录列表出错",e);
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }








}

