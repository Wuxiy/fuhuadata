package com.fuhuadata.web.springmvc.doc;

import com.fuhuadata.domain.doc.BankType;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.doc.BankTypeService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/25/2017
 */
@RequestMapping("/bank/type")
@Controller
public class BankTypeAction extends BaseController<BankType, Integer> {

    private BankTypeService bankTypeService;

    @Autowired
    public void setBankTypeService(BankTypeService bankTypeService) {
        this.bankTypeService = bankTypeService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listAllBankTypes(BankType bankType) {

        Result<List<BankType>> result = Result.newResult(false);

        List<BankType> bankTypes = bankTypeService.listBankTypes(bankType);
        result.addDefaultModel(bankTypes);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
