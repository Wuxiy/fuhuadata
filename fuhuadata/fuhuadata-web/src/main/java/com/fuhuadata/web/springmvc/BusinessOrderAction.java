package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.BusinessOrderService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Think on 2017/3/29.
 */
@Controller
@RequestMapping("/businessOrder/*")
public class BusinessOrderAction {

    @Autowired
    private BusinessOrderService businessOrderService;


    @RequestMapping("/intoBusinessOffer")
    @SystemLogAnnotation(module = "salesStatistics-businessOrder",methods = "intoOffer")
    public ModelAndView intoBusinessOffer(){
        return new ModelAndView("salesStatistics/offer");
    }

    @RequestMapping("/intoBusinessOrder")
    @SystemLogAnnotation(module = "salesStatistics-businessOrder",methods = "intoOffer")
    public ModelAndView intoBusinessOrder(){
        return new ModelAndView("salesStatistics/order");
    }

    /**
     * 报价列表
     * @param queryBusinessOrder
     * @return
     */
    @RequestMapping(value = "/getOfferListPageByQuery",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "getOfferListPageByQuery")
    @ResponseBody
    public ResultPojo getOfferListPageByQuery(@RequestBody QueryBusinessOrder queryBusinessOrder){
        Result<List<QueryBusinessOrder>> result = new Result<List<QueryBusinessOrder>>();
        try{
            result = businessOrderService.getOfferListPageByQuery(queryBusinessOrder);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 订单列表
     * @param queryBusinessOrder
     * @return
     */
    @RequestMapping(value = "/getOrderListPageByQuery",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "getOrderListPageByQuery")
    @ResponseBody
    public ResultPojo getOrderListPageByQuery(@RequestBody QueryBusinessOrder queryBusinessOrder){
        Result<List<QueryBusinessOrder>> result = new Result<List<QueryBusinessOrder>>();
        try{
            result = businessOrderService.getOrderListPageByQuery(queryBusinessOrder);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * count offer
     * @param queryBusinessOrder
     * @return
     */
    @RequestMapping(value = "/countOffer",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "countOffer")
    @ResponseBody
    public ResultPojo countOffer(@RequestBody QueryBusinessOrder queryBusinessOrder){
        Result<Integer> result = new Result<Integer>();
        try{
            result = businessOrderService.countOffer(queryBusinessOrder);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * count order
     * @param queryBusinessOrder
     * @return
     */
    @RequestMapping(value = "/countOrder",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "countOrder")
    @ResponseBody
    public ResultPojo countOrder(@RequestBody QueryBusinessOrder queryBusinessOrder){
        Result<Integer> result = new Result<Integer>();
        try{
            result = businessOrderService.countOrder(queryBusinessOrder);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }


    /**
     *  add
     * @param businessOrder
     * @return
     */
    @RequestMapping(value = "/addBusinessOrder",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "addBusinessOrder")
    @ResponseBody
    public ResultPojo addBusinessOrder(@RequestBody BusinessOrder businessOrder){
        Result<BusinessOrder> result = new Result<BusinessOrder>();
        try{
            result = businessOrderService.addBusinessOrder(businessOrder);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }


    /**
     *  update
     * @param businessOrder
     * @return
     */
    @RequestMapping(value = "/updateBusinessOrderByOrderId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "updateBusinessOrderByOrderId")
    @ResponseBody
    public ResultPojo updateBusinessOrderByOrderId(@RequestBody BusinessOrder businessOrder){
        Result<BusinessOrder> result = new Result<BusinessOrder>();
        try{
            result = businessOrderService.updateBusinessOrderByOrderId(businessOrder);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }


    /**
     *  update 报价单状态
     * @param businessOrder
     * @return
     */
    @RequestMapping(value = "/updateOfferStatus",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "updateOfferStatus")
    @ResponseBody
    public ResultPojo updateOfferStatus(@RequestBody BusinessOrder businessOrder){
        Result<BusinessOrder> result = new Result<BusinessOrder>();
        try{
            result = businessOrderService.updateOfferStatus(businessOrder);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }


    /**
     *  获取订单详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/getBusinessOrderByOrderId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "getBusinessOrderByOrderId")
    @ResponseBody
    public ResultPojo getBusinessOrderByOrderId(String orderId){
        Result<BusinessOrder> result = new Result<BusinessOrder>();
        try{
            result = businessOrderService.getBusinessOrderByOrderId(orderId);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }



}
