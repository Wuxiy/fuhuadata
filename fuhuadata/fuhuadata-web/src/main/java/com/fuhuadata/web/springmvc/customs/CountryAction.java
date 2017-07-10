package com.fuhuadata.web.springmvc.customs;

import com.fuhuadata.domain.customs.CustomsCountry;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.customs.CustomsCountryService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/28/2017
 */
@RequestMapping("/customs/countries")
@Controller
public class CountryAction extends BaseController<CustomsCountry, Integer> {

    @Resource
    private CustomsCountryService countryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listCountries() {

        Result<List<CustomsCountry>> result = Result.newResult(false);

        List<CustomsCountry> countries = countryService.listCountries();
        result.addDefaultModel(countries);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
