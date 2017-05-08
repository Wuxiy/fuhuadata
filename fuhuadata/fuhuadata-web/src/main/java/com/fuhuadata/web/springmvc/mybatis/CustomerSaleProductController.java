package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.CustomerSaleProduct;
import com.fuhuadata.domain.query.CustomerSaleProductInfo;
import com.fuhuadata.domain.query.QueryCustomerSaleProduct;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.CustomerSaleProductService;
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
@RequestMapping("/customer/market/sale/products")
@Controller
public class CustomerSaleProductController extends BaseController<CustomerSaleProduct, Integer> {

    private CustomerSaleProductService saleProductService;

    @Autowired
    public void setSaleProductService(CustomerSaleProductService saleProductService) {
        this.saleProductService = saleProductService;
    }

    /**
     * 获取分页销售产品
     * @param query
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market-sale", methods = "listSaleProduct")
    public ResultPojo listPurchaseProduct(QueryCustomerSaleProduct query) {

        Result<PageInfo<CustomerSaleProduct>> result = Result.newResult(false);

        query.setIndex(query.getIndex() + 1);
        PageInfo<CustomerSaleProduct> products = saleProductService.listProducts(query);
        result.addDefaultModel(products);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 获取销售产品信息，包括目的国信息
     * @param productId
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market-sale", methods = "getProductInfoById")
    public ResultPojo getProductAndSuppliersById(@PathVariable("id") Integer productId) {

        Result<CustomerSaleProduct> result = Result.newResult(false);

        CustomerSaleProduct product = saleProductService.getProductAndCountriesByProductId(productId);
        result.addDefaultModel(product);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 保存销售产品和目的国
     * @param productInfo
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market-sale", methods = "saveOrUpdateProducts")
    public ResultPojo saveOrUpdateSaleProducts(@RequestBody CustomerSaleProductInfo productInfo) {

        Result<Boolean> result = Result.newResult(false);

        saleProductService.saveOrUpdateProductsAndCountries(productInfo.getSaleProduct(),
                productInfo.getDeleteCountryIds());
        result.setSuccess(true);

        return result.getResultPojo();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @SystemLogAnnotation(module = "customer-market-sale", methods = "deleteProducts")
    public ResultPojo deleteSaleProducts(@RequestParam("ids[]") Integer[] productIds) {

        Result<Boolean> result = Result.newResult(false);

        saleProductService.deleteProducts(Arrays.asList(productIds));
        result.setSuccess(true);

        return result.getResultPojo();
    }

}
