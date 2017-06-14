package com.fuhuadata.domain.business;

import com.fuhuadata.domain.query.PageBase;

/**
 * <p>User: wangjie
 * <p>Date: 6/13/2017
 */
public class BusinessBuyContractQuery extends PageBase {

    private String ctname;// 合同名称
    private String vbillcode;// 合同编号
    private String cvendorid;// 供应商ncId

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    public String getVbillcode() {
        return vbillcode;
    }

    public void setVbillcode(String vbillcode) {
        this.vbillcode = vbillcode;
    }

    public String getCvendorid() {
        return cvendorid;
    }

    public void setCvendorid(String cvendorid) {
        this.cvendorid = cvendorid;
    }
}
