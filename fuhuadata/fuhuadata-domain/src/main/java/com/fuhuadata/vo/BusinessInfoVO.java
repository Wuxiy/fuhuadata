package com.fuhuadata.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fuhuadata.domain.BusinessInfo;
import com.fuhuadata.domain.BusinessRecord;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 商机list
 * Created by intanswer on 2017/3/28.
 */
public class BusinessInfoVO {
    private List<BusinessRecord> businessRecords;

    private BusinessInfo businessInfo;


    public List<BusinessRecord> getBusinessRecords() {
        return businessRecords;
    }

    public void setBusinessRecords(List<BusinessRecord> businessRecords) {
        this.businessRecords = businessRecords;
    }

    public BusinessInfo getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(BusinessInfo businessInfo) {
        this.businessInfo = businessInfo;
    }
}
