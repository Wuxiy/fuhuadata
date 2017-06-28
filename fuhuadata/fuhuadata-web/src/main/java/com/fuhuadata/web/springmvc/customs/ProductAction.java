package com.fuhuadata.web.springmvc.customs;

import com.fuhuadata.domain.customs.CustomsProduct;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.customs.CustomsProductService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 海关数据产品
 * <p>User: wangjie
 * <p>Date: 6/28/2017
 */
@RequestMapping("/customs/products")
@Controller
public class ProductAction extends BaseController<CustomsProduct, Integer> {

    @Resource
    private CustomsProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listProducts() {
        Result<List<CustomsProduct>> result = Result.newResult(false);

        List<CustomsProduct> products = productService.list();
        result.addDefaultModel(products);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
