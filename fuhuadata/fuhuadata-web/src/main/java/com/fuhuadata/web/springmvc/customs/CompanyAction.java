package com.fuhuadata.web.springmvc.customs;

import com.fuhuadata.domain.customs.CustomsCompany;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.customs.CustomsCompanyService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import com.fuhuadata.web.util.SystemLogAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 7/5/2017
 */
@RequestMapping("/customs/companies")
@Controller
public class CompanyAction extends BaseController<CustomsCompany, Integer> {

    @Resource
    private CustomsCompanyService companyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @SystemLogAnnotation(module = "customs-company", methods = "listTopCompanies")
    public ResultPojo listCompanies() {

        Result<List<CustomsCompany>> result = Result.newResult(false);

        List<CustomsCompany> topCompanies = companyService.listTopCompanies();
        result.addDefaultModel(topCompanies);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
