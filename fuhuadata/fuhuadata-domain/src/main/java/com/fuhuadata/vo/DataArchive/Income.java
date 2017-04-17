package com.fuhuadata.vo.DataArchive;

import java.util.Date;

/**
 * 收款协议
 * Created by intanswer on 2017/4/17.
 */
public class Income {

    private String pkIncome;

    /**账期天数**/
    private String name;

    /**协议名称**/
    private Integer paymentday;

    /**code**/
    private String code;

    /**协议生效日期**/
    private Date effectdate;

    /**协议失效日期**/
    private Date diseffectdate;

    /**备注**/
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
