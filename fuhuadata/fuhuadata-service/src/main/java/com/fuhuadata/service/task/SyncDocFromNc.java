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

    public void autoTest() {
        System.out.println("Spring Task Test.");
    }

    /**
     * 国家地区同步
     */
    public void syncCountryZone() {
        countryzoneService.ncToCrm();
    }

    public void syncIncoterm() {
        incotermService.ncToCrm();
    }

    public void syncPortdoc() {
        portdocService.ncToCrm();
    }

    public void syncCurrtype() {
        currtypeService.ncToCrm();
    }

    public void syncCustclass() {
        custclassService.ncToCrm();
    }

    public void syncFormatDoc() {
        formatdocService.ncToCrm();
    }

    public void syncIncome() {
        incotermService.ncToCrm();
    }

    public void syncTimezone() {
        timezoneService.ncToCrm();
    }
}
