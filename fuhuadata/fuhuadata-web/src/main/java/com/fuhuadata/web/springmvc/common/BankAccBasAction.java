package com.fuhuadata.web.springmvc.common;

import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.service.mybatis.common.BankAccBasService;
import com.fuhuadata.web.springmvc.mybatis.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * <p>User: wangjie
 * <p>Date: 5/25/2017
 */
@RequestMapping("/common/bankaccs")
public class BankAccBasAction extends BaseController<BankAccBas, Integer> {

    private BankAccBasService bankAccBasService;

    @Resource
    public void setBankAccBasService(BankAccBasService bankAccBasService) {
        this.bankAccBasService = bankAccBasService;
    }

}
