package com.fuhuadata.web.springmvc;

import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.domain.CustomerPurchaseProduct;
import com.fuhuadata.domain.CustomerSaleProduct;
import com.fuhuadata.domain.query.QueryCustomerPurchaseProduct;
import com.fuhuadata.domain.query.QueryCustomerSaleProduct;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.CustomerBaseInfoService;
import com.fuhuadata.service.CustomerPurchaseProductService;
import com.fuhuadata.service.CustomerSaleProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hexingfu on 2017/3/14.
 */
@Controller
@RequestMapping("/customerMarketInfo/*")
public class MarketInfoAction {

    private final static Logger log = Logger.getLogger(MarketInfoAction.class);

    @Autowired
    private CustomerPurchaseProductService customerPurchaseProductService;
    @Autowired
    private CustomerSaleProductService customerSaleProductService;
    @Autowired
    private CustomerBaseInfoService customerBaseInfoService;
    /**
     * 客户信息-市场信息入口方法
     * @param customerId
     * @return
     */
    @RequestMapping("/entrance")
    public ModelAndView entrance(String customerId,String customerType,String fullName){
        return  new ModelAndView("/customerInfo/customerMarketingInfo").addObject("customerId",customerId)
                .addObject("customerType",customerType)
                .addObject("fullName",fullName);
    }
    /**
     * 客户信息-市场信息入口方法
     * @param customerId
     * @return
     */
    @ResponseBody
    @RequestMapping("/init")
    public ResultPojo init(String customerId){
        //盛装返回数据集
        Map<String,Object> rmap = new HashMap<String,Object>();
        //默认查询今年的数据
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String yearStr = sdf.format(new Date());
        //查询采购产品
        QueryCustomerPurchaseProduct qcpp = new QueryCustomerPurchaseProduct();
        qcpp.setYear(yearStr);
        qcpp.setCustomerId(customerId);
        Result<List<CustomerPurchaseProduct>> cpps_rs = this.customerPurchaseProductService
                .getCustomerPurchaseProductsByQuery(qcpp);
        if(cpps_rs!=null){
            rmap.put("cpps",cpps_rs.getModel());
        }
        //查询销售产品
        QueryCustomerSaleProduct qscp = new QueryCustomerSaleProduct();
        qscp.setYear(yearStr);
        qscp.setCustomerId(customerId);
        Result<List<CustomerSaleProduct>> qscp_rs = this.customerSaleProductService
                .getCustomerSaleProductsByQuery(qscp);
        if(qscp_rs!=null){
            rmap.put("csps",qscp_rs.getModel());
        }
        //查询合作情况
        rmap.put("cooperation",this.customerBaseInfoService.queryCooperationByCid(customerId));
        ResultPojo pojo = new ResultPojo();
        pojo.setData(rmap);
        return pojo;
    }

    /**
     * 根据年份和客户id获取采购产品列表
     * @param query
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCPPListByCidAndYear")
    public ResultPojo getCPPListByCidAndYear(QueryCustomerPurchaseProduct query){
        return this.customerPurchaseProductService.getCustomerPurchaseProductsByQuery(query).getResultPojo();
    }
    /**
     * 根据年份和客户id获取销售产品列表
     * @param query
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSaleProductListByCidAndYear")
    public ResultPojo getSaleProductListByCidAndYear(QueryCustomerSaleProduct query){
        return this.customerSaleProductService.getCustomerSaleProductsByQuery(query).getResultPojo();
    }

    /**
     * 批量插入客户采购产品
     * @param cpps
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCPPList")
    public ResultPojo addCPPList(@RequestBody CustomerPurchaseProduct[] cpps){
        ResultPojo pojo = new ResultPojo();
        List<CustomerPurchaseProduct> list = new ArrayList<CustomerPurchaseProduct>();
        for(CustomerPurchaseProduct cpp:cpps){
            list.add(cpp);
        }
        pojo.setData(this.customerPurchaseProductService.batchInsert(list));
        return pojo;
    }
    /**
     * 批量插入客户销售产品
     * @param csps
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCSPList")
    public ResultPojo addCSPList(@RequestBody  CustomerSaleProduct[] csps){
        ResultPojo pojo = new ResultPojo();
        List<CustomerSaleProduct> list = new ArrayList<CustomerSaleProduct>();
        for(CustomerSaleProduct csp:csps){
            list.add(csp);
        }
        pojo.setData(this.customerSaleProductService.batchInsert(list));
        return pojo;
    }

    /**
     * 修改客户合作情况信息
     * @param customerBaseInfo
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateCooperationInfo")
    public ResultPojo updateCooperationInfo(CustomerBaseInfo customerBaseInfo){
        Result rs =  customerBaseInfoService.updateCustomerBaseInfoById(customerBaseInfo.getCustomerId(),customerBaseInfo);
        ResultPojo pojo = new ResultPojo();
        pojo.setData(rs.getSuccess());
        return pojo;
    }
}
