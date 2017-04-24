package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.query.QueryBusinessOrder;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.*;
import com.fuhuadata.service.util.LoginUtils;
import com.fuhuadata.vo.*;
import com.fuhuadata.vo.DataArchive.Currtype;
import com.fuhuadata.vo.DataArchive.Income;
import com.fuhuadata.vo.DataArchive.Incoterm;
import com.fuhuadata.web.util.DateUtil;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

    @Autowired
    private BCodeService bCodeService;

    @Autowired
    private BusinessInfoService businessInfoService;

    @Autowired
    private BusinessOrderProductService businessOrderProductService;

    @Autowired
    private DataArchivesService dataArchivesService;


    @RequiresPermissions({"sale:flow:offer:view"})
    @RequestMapping("/intoBusinessOffer")
    @SystemLogAnnotation(module = "salesStatistics-businessOrder",methods = "intoOffer")
    public ModelAndView intoBusinessOffer(){
        return new ModelAndView("salesStatistics/offer");
    }

    @RequiresPermissions({"sale:flow:order:view"})
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
        //queryBusinessOrder.setSalesManId(LoginUtils.getLoginId()+"");
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
     *  进入商机转化
     * @param businessId
     */
    @RequestMapping("/intoBusinessConverse")
    @SystemLogAnnotation(module = "salesStatistics",methods = "intoBusinessConverse")
    public ModelAndView intoBusinessConverse(String businessId){
        String orderId = bCodeService.genNextOrderCode();
        Result<BusinessInfoVO> result = businessInfoService.getBusinessInfoByBusinessId(businessId);
        //收款协议
        Result<List<Income>> rincome = dataArchivesService.getIncome();
        //贸易术语
        Result<List<Incoterm>> rincoterm = dataArchivesService.getIncoterm();
        //币种
        Result<List<Currtype>> rcurrtype = dataArchivesService.getCurrtype();
        return new ModelAndView("salesStatistics/offerInfo").addObject("orderId",orderId).addObject("businessId",businessId).addObject("businessInfo",result.getModel())
                .addObject("income",rincome.getModel()).addObject("incoterm",rincoterm.getModel()).addObject("currtype",rcurrtype.getModel());
    }

    /**
     *  进入报价转化
     * @param orderId
     */
    @RequestMapping("/intoBusinessOfferConverse")
    @SystemLogAnnotation(module = "salesStatistics",methods = "intoBusinessOfferConverse")
    public ModelAndView intoBusinessOfferConverse(String orderId){
        Result<BusinessOrderProductVO> result = businessOrderProductService.getBusinessOrderProducts(orderId);
        //收款协议
        Result<List<Income>> rincome = dataArchivesService.getIncome();
        //贸易术语
        Result<List<Incoterm>> rincoterm = dataArchivesService.getIncoterm();
        //币种
        Result<List<Currtype>> rcurrtype = dataArchivesService.getCurrtype();
        return new ModelAndView("salesStatistics/orderConversion").addObject("orderId",orderId).addObject("businessOrderProduct",result.getModel())
                .addObject("income",rincome.getModel()).addObject("incoterm",rincoterm.getModel()).addObject("currtype",rcurrtype.getModel());
    }

    /**
     *  报价转化订单
     * @param
     */
    @RequestMapping(value = "/updateOrderProducts",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics",methods = "updateOrderProducts")
    @ResponseBody
    public ResultPojo updateOrderProducts(@RequestBody BusinessOrderDO businessOrderDO){
        Result result = new Result();
       businessOrderDO.getBusinessOrder().setLastmodifyUserId(LoginUtils.getLoginId());
       businessOrderDO.getBusinessOrder().setLastmodifyUserName(LoginUtils.getLoginName());
       businessOrderDO.getBusinessOrder().setModifyTime(DateUtil.getDateTime());
       if(businessOrderDO.getBusinessOrderProducts()!=null&&businessOrderDO.getBusinessOrderProducts().length>0){
           for(int i = 0;i<businessOrderDO.getBusinessOrderProducts().length;i++){
               businessOrderDO.getBusinessOrderProducts()[i].setModifyTime(DateUtil.getDateTimeFormat());
               businessOrderDO.getBusinessOrderProducts()[i].setLastmodifyUserId(LoginUtils.getLoginId());
               businessOrderDO.getBusinessOrderProducts()[i].setLastmodifyUserName(LoginUtils.getLoginName());
           }
       }
        try{
            result = businessOrderService.updateBusinessOrderAndProduct(businessOrderDO);
        }catch (Exception e){
            result.setSuccess(false);
        }
        result.setMessage("报价转化订单成功！");
        return result.getResultPojo();
    }


    /**
             *  doAdd
             * @param businessOrder
             * @return
             */
            @RequestMapping(value = "/doAddBusinessOrder",method = RequestMethod.POST)
            @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "addBusinessOrder")
            @ResponseBody
            public ResultPojo addBusinessOrder(@RequestBody BusinessOrder businessOrder){
                Result<BusinessOrder> result = new Result<BusinessOrder>();
                try{
                    businessOrder.setStatus(0);//新增报价,从商机转化而来，为报价中的状态

                    /**设置创建人和修改人**/
                    businessOrder.setCreateUserId(LoginUtils.getLoginId());
                    businessOrder.setCreateUserName(LoginUtils.getLoginName());
                    businessOrder.setLastmodifyUserId(LoginUtils.getLoginId());
                    businessOrder.setLastmodifyUserName(LoginUtils.getLoginName());
                    businessOrder.setCreateTime(DateUtil.getDateTime());
                    businessOrder.setModifyTime(DateUtil.getDateTime());

            result = businessOrderService.addBusinessOrder(businessOrder);
        }catch(Exception e){
            result.setSuccess(false);
        }
        result.getModel().setOrderId(businessOrder.getOrderId());
        return result.getResultPojo();
    }


    /**
     *
     *  update 报价单 表头和订单产品信息
     * @param businessOrder
     * @return
     */
    @RequestMapping(value = "/updateBusinessOrderByOrderId",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics-businessInfo",methods = "updateBusinessOrderByOrderId")
    @ResponseBody
    public ResultPojo updateBusinessOrderByOrderId(@RequestBody BusinessOrder businessOrder){
        businessOrder.setLastmodifyUserId(LoginUtils.getLoginId());
        businessOrder.setLastmodifyUserName(LoginUtils.getLoginName());
        businessOrder.setModifyTime(DateUtil.getDateTime());
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
        businessOrder.setLastmodifyUserId(LoginUtils.getLoginId());
        businessOrder.setLastmodifyUserName(LoginUtils.getLoginName());
        businessOrder.setModifyTime(DateUtil.getDateTime());
        try{
            businessOrder.setStatus(-2);
            result = businessOrderService.updateOfferStatus(businessOrder);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     *  进入报价详情
     * @param orderId
     * @return
     */
    @RequestMapping("/intoOfferorOrder")
    @SystemLogAnnotation(module = "salesStatistics",methods = "intoOfferorOrder")
    public ModelAndView intoOfferorOrder(String orderId,String businessId) {
        //收款协议
        Result<List<Income>> rincome = dataArchivesService.getIncome();
        //贸易术语
        Result<List<Incoterm>> rincoterm = dataArchivesService.getIncoterm();
        //币种
        Result<List<Currtype>> rcurrtype = dataArchivesService.getCurrtype();
        return new ModelAndView("salesStatistics/offerInfo").addObject("orderId", orderId).addObject("businessId", businessId)
                .addObject("income",rincome.getModel()).addObject("incoterm",rincoterm.getModel()).addObject("currtype",rcurrtype.getModel());
    }

    /**
     *  进入订单详情
     * @param orderId
     * @return
     */
    @RequestMapping("/intoOrder")
    @SystemLogAnnotation(module = "salesStatistics",methods = "intoOrder")
    public ModelAndView intoOrder(String orderId){
        return new ModelAndView("salesStatistics/orderInfo").addObject("orderId",orderId);
    }

    /**
     *  获取报价订单详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/getBusinessOrderByOrderId",method = RequestMethod.GET)
    @SystemLogAnnotation(module = "salesStatistics-businessOrder",methods = "getBusinessOrderByOrderId")
    @ResponseBody
    public ResultPojo getBusinessOrderByOrderId(String orderId){
        Result<BusinessOrderVO> result = new Result<BusinessOrderVO>();
        try{
            result = businessOrderService.getBusinessOrderByOrderId(orderId);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }



    /**
     * 进入费用与利润
     * @return
     */
    @RequiresPermissions({"sale:fee:view"})
    @RequestMapping("/intoCostAndProfitStatistics")
    @SystemLogAnnotation(module = "salesStatistics",methods = "intoCostAndProfitStatistics")
    public ModelAndView intoCostAndProfitStatistics(String salesManId){
        return new ModelAndView("salesStatistics/costProfit").addObject("salesManId",salesManId);
    }

    /**
     * 进入利润与统计
     * @return
     */
    @RequiresPermissions({"sale:profit:view"})
    @RequestMapping("/intoProfitStatistics")
    @SystemLogAnnotation(module = "salesStatistics",methods = "intoProfitStatistics")
    public ModelAndView intoProfitStatistics(){
        return new ModelAndView("salesStatistics/profitStatistics");
    }

    /**
     * 进入历史订单
     * @return
     */
    @RequiresPermissions({"sale:profit:view"})
    @RequestMapping("/intoHistoryOrder")
    @SystemLogAnnotation(module = "salesStatistics",methods = "intoHistoryOrder")
    public ModelAndView intoHistoryOrder(String salesManId){
        return new ModelAndView("salesStatistics/historyOrder").addObject("salesManId",salesManId);
    }


    /**
     * 费用与利润统计
     * @param costAndProfitStatistics
     * @return
     */
    @RequestMapping(value = "/getCostAndProfitStatisticsByPage",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics",methods = "getBusinessOrderByOrderId")
    @ResponseBody
    public ResultPojo getCostAndProfitStatisticsByPage(@RequestBody  CostAndProfitStatistics costAndProfitStatistics){
        Result<List<CostAndProfitStatistics>> result = new Result<List<CostAndProfitStatistics>>();
        try{
            result = businessOrderService.getCostAndProfitStatisticsByPage(costAndProfitStatistics);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 费用与利润表 条目统计
     * @param costAndProfitStatistics
     * @return
     */
    @RequestMapping(value = "/countCostAndProfitStatistics",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics",methods = "countCostAndProfitStatistics")
    @ResponseBody
    public ResultPojo countCostAndProfitStatistics(@RequestBody  CostAndProfitStatistics costAndProfitStatistics){
        Result<Integer> result = new Result<Integer>();
            try{
            result = businessOrderService.countCostAndProfit(costAndProfitStatistics);
            }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }



    /**
     * 利润统计
     * @param costAndProfitStatistics
     * @return
     */
    @RequestMapping(value = "/getProfitStatisticsByPage",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics",methods = "getProfitStatisticsByPage")
    @ResponseBody
    public ResultPojo getProfitStatisticsByPage(@RequestBody CostAndProfitStatistics costAndProfitStatistics){
        Result<List<CostAndProfitStatistics>>  result = new Result<List<CostAndProfitStatistics>>();
        try{
            result = businessOrderService.getProfitStatisticsByPage(costAndProfitStatistics);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }

    /**
     * 利润 条目统计
     * @param costAndProfitStatistics
     * @return
     */
    @RequestMapping(value = "/countProfitStatistics",method = RequestMethod.POST)
    @SystemLogAnnotation(module = "salesStatistics",methods = "countProfitStatistics")
    @ResponseBody
    public ResultPojo countProfitStatistics(@RequestBody CostAndProfitStatistics costAndProfitStatistics){
        Result<Integer>  result = new Result<Integer>();
        try{
            result = businessOrderService.countProfitStatistics(costAndProfitStatistics);
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result.getResultPojo();
    }


}
