package com.fuhuadata.web.springmvc.doc;

import com.fuhuadata.domain.doc.BankDoc;
import com.fuhuadata.domain.doc.BankDocQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import com.fuhuadata.service.mybatis.doc.BankDocService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/25/2017
 */
@RequestMapping("/bank/docs")
@Controller
public class BankDocAction extends BaseController<BankDoc, Integer> {

    private BankDocService bankDocService;

    @Resource
    public void setBankDocService(BankDocService bankDocService) {
        this.bankDocService = bankDocService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResultPojo listBankDocks(BankDocQuery query) {

        Result<List<BankDoc>> result = Result.newResult(false);

        List<BankDoc> bankDocs = bankDocService.listDocs(query);
        result.addDefaultModel(bankDocs);
        result.setSuccess(true);

        return result.getResultPojo();
    }
}
