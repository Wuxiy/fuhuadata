package com.fuhuadata.domain;

import java.util.Date;

/**
 * 收款协议
 */
public class Income {
    private String pkIncome;

    private String name;

    private Integer paymentday;

    private String code;

    private Date effectdate;

    private Date diseffectdate;

    private String meno;

    public String getPkIncome() {
        return pkIncome;
    }

    public void setPkIncome(String pkIncome) {
        this.pkIncome = pkIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPaymentday() {
        return paymentday;
    }

    public void setPaymentday(Integer paymentday) {
        this.paymentday = paymentday;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getEffectdate() {
        return effectdate;
    }

    public void setEffectdate(Date effectdate) {
        this.effectdate = effectdate;
    }

    public Date getDiseffectdate() {
        return diseffectdate;
    }

    public void setDiseffectdate(Date diseffectdate) {
        this.diseffectdate = diseffectdate;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }
}