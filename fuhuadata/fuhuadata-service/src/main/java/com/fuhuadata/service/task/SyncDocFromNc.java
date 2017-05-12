package com.fuhuadata.service.task;

import com.fuhuadata.service.oracle.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>User: wangjie
 * <p>Date: 4/19/2017
 */
@Service("syncDocFromNc")
public class SyncDocFromNc {

    Logger logger = LoggerFactory.getLogger(SyncDocFromNc.class);

    @Autowired
    CountryZoneService countryzoneService;

    @Autowired
    IncoTermService incotermService;

    @Autowired
    PortDocService portdocService;

    @Autowired
    CurrTypeService currtypeService;

    @Autowired
    CustClassService custclassService;

    @Autowired
    FormatDocService formatdocService;

    @Autowired
    InComeService incomeService;

    @Autowired
    TimeZoneService timezoneService;

    @Autowired
    ReCeiptService reCeiptService;

    public void autoTest() {
        System.out.println("Spring Task Test.");
    }

    /**
     * 国家地区同步
     */
    public void syncCountryZone() {
        countryzoneService.ncToCrm();
    }

    /**
     * 贸易术语档案同步
     */
    public void syncIncoterm() {
        incotermService.ncToCrm();
    }

    /**
     * 港口档案同步
     */
    public void syncPortdoc() {
        portdocService.ncToCrm();
    }

    /**
     * 币种档案同步
     */
    public void syncCurrtype() {
        currtypeService.ncToCrm();
    }

    /**
     * 客户基本分类档案同步
     */
    public void syncCustclass() {
        custclassService.ncToCrm();
    }

    /**
     * 数据格式
     */
    public void syncFormatDoc() {
        formatdocService.ncToCrm();
    }

    /**
     * 收款协议同步
     */
    public void syncIncome() {
        incotermService.ncToCrm();
    }

    /**
     * 时区同步
     */
    public void syncTimezone() {
        timezoneService.ncToCrm();
    }

    /**
     * 订单收款记录同步
     */
    public void syncReceipt() {
        reCeiptService.ncToCrm();
    }
}
