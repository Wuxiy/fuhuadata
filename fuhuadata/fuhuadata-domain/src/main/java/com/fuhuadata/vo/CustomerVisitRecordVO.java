package com.fuhuadata.vo;

import com.fuhuadata.domain.CustomerVisitRecord;
import com.fuhuadata.domain.RecordLinkman;


/**
 * 客户沟通记录新增
 * Created by intanswer on 2017/3/22.
 */
public class CustomerVisitRecordVO {
    private CustomerVisitRecord customerVisitRecord;

    private RecordLinkman[] recordLinkmen;

    public RecordLinkman[] getRecordLinkmen() {
        return recordLinkmen;
    }

    public void setRecordLinkmen(RecordLinkman[] recordLinkmen) {
        this.recordLinkmen = recordLinkmen;
    }

    public CustomerVisitRecord getCustomerVisitRecord() {
        return customerVisitRecord;
    }

    public void setCustomerVisitRecord(CustomerVisitRecord customerVisitRecord) {
        this.customerVisitRecord = customerVisitRecord;
    }
}
