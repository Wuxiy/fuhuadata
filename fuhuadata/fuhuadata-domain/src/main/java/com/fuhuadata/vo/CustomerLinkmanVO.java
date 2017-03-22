package com.fuhuadata.vo;

import com.fuhuadata.domain.CustomerLinkman;

import java.util.ArrayList;
import java.util.List;

/**
 * 联系人详情VO
 * Created by intanswer on 2017/3/20.
 */
public class CustomerLinkmanVO {
    private CustomerLinkman customerLinkman;

    private List<VisitRecordVO> visitRecordVOS;

    public CustomerLinkman getCustomerLinkman() {
        return customerLinkman;
    }

    public void setCustomerLinkman(CustomerLinkman customerLinkman) {
        this.customerLinkman = customerLinkman;
    }


    public void addlinkmanVisitRecordVO(VisitRecordVO visitRecordVO){
        if(this.visitRecordVOS ==null){
            this.visitRecordVOS =new ArrayList<VisitRecordVO>();
        }
        this.visitRecordVOS.add(visitRecordVO);
    }


    public List<VisitRecordVO> getVisitRecordVOS() {
        return visitRecordVOS;
    }

    public void setVisitRecordVOS(List<VisitRecordVO> visitRecordVOS) {
        this.visitRecordVOS = visitRecordVOS;
    }
}
