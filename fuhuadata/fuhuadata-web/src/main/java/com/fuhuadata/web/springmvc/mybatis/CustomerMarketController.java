package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.CustomerPurchaseProduct;
import com.fuhuadata.domain.query.CustomerPurchaseProductInfo;
import com.fuhuadata.domain.query.QueryCustomerPurchaseProduct;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
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

    @Autowired
    public void setPurchaseProductService(CustomerPurchaseProductService purchaseProductService) {
        this.purchaseProductService = purchaseProductService;
    }

    /**
     * 获取分页采购产品
     * @param query
     * @return
     */
    @RequestMapping(value = "/purchase/products", method = RequestMethod.GET)
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market", methods = "listPurchaseProduct")
    public ResultPojo listPurchaseProduct(QueryCustomerPurchaseProduct query) {

        Result<PageInfo<CustomerPurchaseProduct>> result = Result.newResult(false);

        PageInfo<CustomerPurchaseProduct> products = purchaseProductService.listProducts(query);
        result.addDefaultModel(products);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 获取采购产品信息，包括供应商信息
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

    @RequestMapping(value = "/coop/{customerId}")
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market-coop", methods = "getCoopInfo")
    public ResultPojo getCoopInfo(@PathVariable("customerId") Integer customerId) {

        // TODO: 5/5/2017 获取合作客户信息
        return null;
    }
}
