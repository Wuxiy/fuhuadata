package com.fuhuadata.web.springmvc.supplier;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.domain.supplier.ProduceFactoryProduct;
import com.fuhuadata.service.mybatis.supplier.ProduceFactoryProductService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/27/2017
 */
@RequestMapping("/supplier/factories")
@Controller
public class FactoryProductAction extends BaseController<ProduceFactoryProduct, Integer> {

    @Resource
    private ProduceFactoryProductService productService;

    /**
     * 获取加工厂产品列表
     * @param factoryId
     * @return
     */
    @RequestMapping(value = "/{factoryId}/products", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listFactoryProducts(@PathVariable Integer factoryId) {
        Result<List<ProduceFactoryProduct>> result = Result.newResult(false);

        List<ProduceFactoryProduct> products = productService.listProducts(factoryId);
        result.addDefaultModel(products);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 新增加工厂产品
     * @param factoryId
     * @param product
     * @return
     */
    @RequestMapping(value = "/{factoryId}/products", method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo saveProducts(@PathVariable Integer factoryId, @RequestBody ProduceFactoryProduct product) {
        Result<ProduceFactoryProduct> result = Result.newResult(false);

        product.setFactoryId(factoryId);

        product = productService.saveProduct(product);
        result.addDefaultModel(product);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 更新加工厂产品
     * @param factoryId
     * @param product
     * @return
     */
    @RequestMapping(value = "/{factoryId}/products/{productId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResultPojo updateProducts(@PathVariable Integer factoryId,
                                     @PathVariable Integer productId,
                                     @RequestBody ProduceFactoryProduct product) {
        Result<ProduceFactoryProduct> result = Result.newResult(false);

        product.setFactoryId(factoryId);
        product.setId(productId);

        product = productService.updateProduct(product);
        result.addDefaultModel(product);
        result.setSuccess(true);

        return result.getResultPojo();
    }

    /**
     * 批量删除产品
     * @param factoryId
     * @param productIds
     * @return
     */
    @RequestMapping(value = "/{factoryId}/products", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultPojo deleteProducts(@PathVariable Integer factoryId, @RequestBody List<Integer> productIds) {
        Result<Boolean> result = Result.newResult(false);

        productService.deleteProducts(factoryId, productIds);
        result.addDefaultModel(true);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
