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

    private List<LinkmanVisitRecordVO> linkmanVisitRecordVOS;

    public CustomerLinkman getCustomerLinkman() {
        return customerLinkman;
    }

    public void setCustomerLinkman(CustomerLinkman customerLinkman) {
        this.customerLinkman = customerLinkman;
    }


    public void addlinkmanVisitRecordVO(LinkmanVisitRecordVO linkmanVisitRecordVO){
        if(this.linkmanVisitRecordVOS==null){
            this.linkmanVisitRecordVOS=new ArrayList<LinkmanVisitRecordVO>();
        }
        this.linkmanVisitRecordVOS.add(linkmanVisitRecordVO);
    }


    public List<LinkmanVisitRecordVO> getLinkmanVisitRecordVOS() {
        return linkmanVisitRecordVOS;
    }

    public void setLinkmanVisitRecordVOS(List<LinkmanVisitRecordVO> linkmanVisitRecordVOS) {
        this.linkmanVisitRecordVOS = linkmanVisitRecordVOS;
    }
}
