package com.fuhuadata.web.springmvc.supplier;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.domain.supplier.FactoryEvaTotal;
import com.fuhuadata.service.mybatis.supplier.FactoryEvaItemService;
import com.fuhuadata.service.mybatis.supplier.FactoryEvaTotalService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>User: wangjie
 * <p>Date: 6/5/2017
 */
@RequestMapping("/factory/eva")
@Controller
public class FactoryEvaluateAction extends BaseController<FactoryEvaTotal, Integer> {

    @Resource
    private FactoryEvaTotalService evaTotalService;

    @Resource
    private FactoryEvaItemService evaItemService;

    @RequestMapping(value = "/{orderId}/vm", method = RequestMethod.GET)
    public String index(@PathVariable Integer orderId, Model model) {

        model.addAttribute("orderId", orderId);
        model.addAttribute("evaItems", evaItemService.listItemAndScoreByOrderId(orderId));

        return "";
    }

    /**
     * 获取订单评价详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo getOrderEva(@PathVariable Integer orderId) {

        Result<FactoryEvaTotal> result = Result.newResult(false);

        FactoryEvaTotal evaTotal = evaTotalService.getTotalAndItemsByOrderId(orderId);
        result.addDefaultModel(evaTotal);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 更新订单评价
     * @param orderId
     * @param evaTotal
     * @return
     */
    @RequestMapping(value = "/{orderId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResultPojo saveOrUpdateEva(@PathVariable Integer orderId, @RequestBody FactoryEvaTotal evaTotal) {
        Result<FactoryEvaTotal> result = Result.newResult(false);

        if (null != evaTotal) {
            evaTotal.setOrderId(orderId);
        }

        FactoryEvaTotal factoryEvaTotal = evaTotalService.saveOrUpdate(evaTotal);
        result.addDefaultModel(factoryEvaTotal);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
