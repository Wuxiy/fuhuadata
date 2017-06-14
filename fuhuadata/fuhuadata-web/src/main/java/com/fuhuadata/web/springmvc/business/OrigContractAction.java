package com.fuhuadata.web.springmvc.business;

import com.fuhuadata.domain.business.BusinessOrgiContract;
import com.fuhuadata.domain.business.BusinessOrgiContractQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.business.BusinessOrgiContractService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/14/2017
 */
@RequestMapping("/biz/orgi/contracts")
@Controller
public class OrigContractAction extends BaseController<BusinessOrgiContract, Integer> {

    @Resource
    private BusinessOrgiContractService orgiContractService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listOrgiContracts(BusinessOrgiContractQuery query) {
        Result<List<BusinessOrgiContract>> result = Result.newResult(false);

        List<BusinessOrgiContract> contracts = orgiContractService.listContracts(query);
        result.addDefaultModel(contracts);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
