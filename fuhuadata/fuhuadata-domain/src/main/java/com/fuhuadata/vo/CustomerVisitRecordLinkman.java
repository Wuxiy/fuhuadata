package com.fuhuadata.vo;

import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.RecordLinkman;

import java.util.List;

/**
 * 客户沟通记录详情
 * Created by intanswer on 2017/5/3.
 */
public class CustomerVisitRecordLinkman {
    private CustomerVisitRecord customerVisitRecord;
    private  List<RecordLinkman> recordLinkmanList;


    public CustomerVisitRecord getCustomerVisitRecord() {
        return customerVisitRecord;
    }

    public void setCustomerVisitRecord(CustomerVisitRecord customerVisitRecord) {
        this.customerVisitRecord = customerVisitRecord;
    }

    public List<RecordLinkman> getRecordLinkmanList() {
        return recordLinkmanList;
    }

    public void setRecordLinkmanList(List<RecordLinkman> recordLinkmanList) {
        this.recordLinkmanList = recordLinkmanList;
    }
}
