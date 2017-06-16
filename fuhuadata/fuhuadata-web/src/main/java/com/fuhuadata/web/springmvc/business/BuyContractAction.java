package com.fuhuadata.web.springmvc.business;

import com.fuhuadata.domain.business.BusinessBuyContract;
import com.fuhuadata.domain.business.BusinessBuyContractProduct;
import com.fuhuadata.domain.business.BusinessBuyContractQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.business.BusinessBuyContractProductService;
import com.fuhuadata.service.mybatis.business.BusinessBuyContractService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/13/2017
 */
@RequestMapping("/biz/buy/contracts")
@Controller
public class BuyContractAction extends BaseController<BusinessBuyContract, Integer> {

    @Resource
    private BusinessBuyContractService buyContractService;

    @Resource
    private BusinessBuyContractProductService contractProductService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listContracts(BusinessBuyContractQuery query) {

        Result<PageInfo<BusinessBuyContract>> result = Result.newResult(false);

        List<BusinessBuyContract> contracts = buyContractService.listContrats(query);
        result.addDefaultModel(new PageInfo<>(contracts));
        result.setSuccess(true);

        return result.getResultPojo();
    }

    @RequestMapping(value = "/{pkContract}/products", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listContractProducts(@PathVariable String pkContract) {
        Result<List<BusinessBuyContractProduct>> result = Result.newResult(false);

        List<BusinessBuyContractProduct> products = contractProductService.listProducts(pkContract);
        result.addDefaultModel(products);
        result.setSuccess(true);


       return result.getResultPojo();
    }
}
