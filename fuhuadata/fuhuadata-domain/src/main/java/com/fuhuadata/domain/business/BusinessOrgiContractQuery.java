package com.fuhuadata.domain.business;

import com.fuhuadata.domain.query.PageBase;

/**
 * <p>User: wangjie
 * <p>Date: 6/14/2017
 */
public class BusinessOrgiContractQuery extends PageBase {

    private String contractCode;//合同编号
    private String cvendorid;// 供应商id

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getCvendorid() {
        return cvendorid;
    }

    public void setCvendorid(String cvendorid) {
        this.cvendorid = cvendorid;
    }
}
