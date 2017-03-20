package com.fuhuadata.vo;

import com.fuhuadata.domain.CustomerLinkman;
import com.fuhuadata.domain.CustomerVisitRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * 联系人详情VO
 * Created by intanswer on 2017/3/20.
 */
public class CustomerLinkmanVO {
    private CustomerLinkman customerLinkman;

    private List<CustomerVisitRecord> customerVisitRecords;

    public CustomerLinkman getCustomerLinkman() {
        return customerLinkman;
    }

    public void setCustomerLinkman(CustomerLinkman customerLinkman) {
        this.customerLinkman = customerLinkman;
    }

    public List<CustomerVisitRecord> getCustomerVisitRecords() {
        return customerVisitRecords;
    }

    public void addCustomerVisitRecord(CustomerVisitRecord customerVisitRecord){
        if(this.customerVisitRecords==null){
            this.customerVisitRecords=new ArrayList<CustomerVisitRecord>();
        }
        this.customerVisitRecords.add(customerVisitRecord);
    }

    public void setCustomerVisitRecords(List<CustomerVisitRecord> customerVisitRecords) {
        this.customerVisitRecords = customerVisitRecords;
    }
}
