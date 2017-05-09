package com.fuhuadata.web.springmvc.mybatis;

import com.fasterxml.jackson.annotation.JsonView;
import com.fuhuadata.domain.json.Views;
import com.fuhuadata.domain.mybatis.CustomerBaseInfo;
import com.fuhuadata.domain.mybatis.CustomerPurchaseProduct;
import com.fuhuadata.domain.query.CustomerPurchaseProductInfo;
import com.fuhuadata.domain.query.QueryCustomerPurchaseProduct;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.CustomerBaseInfoService;
import com.fuhuadata.service.mybatis.CustomerPurchaseProductService;
import com.fuhuadata.web.util.SystemLogAnnotation;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>User: wangjie
 * <p>Date: 5/4/2017
 */
@RequestMapping("/customer/market")
@Controller
public class CustomerMarketController extends BaseController<CustomerPurchaseProduct, Integer> {

    private CustomerPurchaseProductService purchaseProductService;

    private CustomerBaseInfoService baseInfoService;

    @Autowired
    public void setPurchaseProductService(CustomerPurchaseProductService purchaseProductService) {
        this.purchaseProductService = purchaseProductService;
    }

    @Autowired
    public void setBaseInfoService(CustomerBaseInfoService baseInfoService) {
        this.baseInfoService = baseInfoService;
    }

    /**
     * 获取分页采购产品
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "/purchase/products", method = RequestMethod.GET)
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market", methods = "listPurchaseProduct")
    public ResultPojo listPurchaseProduct(QueryCustomerPurchaseProduct query) {

        Result<PageInfo<CustomerPurchaseProduct>> result = Result.newResult(false);

        query.setIndex(query.getIndex() + 1);
        PageInfo<CustomerPurchaseProduct> products = purchaseProductService.listProducts(query);
        result.addDefaultModel(products);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 获取采购产品信息，包括供应商信息
     *
     * @param productId
     * @return
     */
    @RequestMapping("/purchase/products/{id}")
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market", methods = "getProductInfoById")
    public ResultPojo getProductAndSuppliersById(@PathVariable("id") Integer productId) {

        Result<CustomerPurchaseProduct> result = Result.newResult(false);

        CustomerPurchaseProduct product = purchaseProductService.getProductAndSupplierByProductId(productId);
        result.addDefaultModel(product);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 保存采购产品和供应商
     *
     * @param productInfo
     * @return
     */
    @RequestMapping(value = "/purchase/products", method = RequestMethod.POST)
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market-purchase", methods = "saveOrUpdateProducts")
    public ResultPojo saveOrUpdatePurchaseProducts(@RequestBody CustomerPurchaseProductInfo productInfo) {

        Result<Boolean> result = Result.newResult(false);

        purchaseProductService.saveOrUpdatePurchaseProductAndSuppliers(productInfo.getPurchaseProduct(),
                productInfo.getDeletedSupplierIds());
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 采购产品删除
     *
     * @param productIds
     * @return
     */
    @RequestMapping(value = "/purchase/products/delete", method = RequestMethod.POST)
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market-purchase", methods = "deleteProducts")
    public ResultPojo deletePurchaseProducts(@RequestParam("ids[]") Integer[] productIds) {

        Result<Boolean> result = Result.newResult(false);

        purchaseProductService.deleteProducts(Arrays.asList(productIds));
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 合作情况信息获取
     *
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/coop/{customerId}")
    @JsonView(Views.Viewable.class)
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market-coop", methods = "getCoopInfo")
    public ResultPojo getCoopInfo(@PathVariable("customerId") Integer customerId) {

        Result<CustomerBaseInfo> baseInfoResult = Result.newResult(false);
        baseInfoResult.addDefaultModel(baseInfoService.getCoopCustomer(customerId));
        baseInfoResult.setSuccess(true);

        return baseInfoResult.getResultPojo();
    }

    /**
     * 合作情况更新
     *
     * @param customerId
     * @param customerBaseInfo
     * @return
     */
    @RequestMapping(value = "/coop/{customerId}", method = RequestMethod.POST)
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market-coop", methods = "updateCoopInfo")
    public ResultPojo updateCoopInfo(@PathVariable("customerId") Integer customerId,
                                     CustomerBaseInfo customerBaseInfo) {

        Result<Integer> result = Result.newResult(false);

        customerBaseInfo.setCustomerId(customerId);
        int i = baseInfoService.updateSelective(customerBaseInfo);
        result.addDefaultModel(i);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
