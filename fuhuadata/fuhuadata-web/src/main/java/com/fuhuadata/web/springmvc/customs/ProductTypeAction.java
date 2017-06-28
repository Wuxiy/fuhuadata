package com.fuhuadata.web.springmvc.customs;

import com.fuhuadata.domain.customs.CustomsProductType;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.customs.CustomsProductTypeService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 海关数据产品类型
 * <p>User: wangjie
 * <p>Date: 6/28/2017
 */
@RequestMapping("/customs/product/types")
@Controller
public class ProductTypeAction extends BaseController<CustomsProductType, Integer> {

    @Resource
    private CustomsProductTypeService productTypeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listProductTypes() {
        Result<List<CustomsProductType>> result = Result.newResult(false);

        List<CustomsProductType> productTypes = productTypeService.list();
        result.addDefaultModel(productTypes);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
