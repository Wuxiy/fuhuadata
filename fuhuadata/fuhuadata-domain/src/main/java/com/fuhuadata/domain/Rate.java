package com.fuhuadata.domain;

import com.fuhuadata.domain.query.PageBase;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 费率
 * Created by young on 2017/2/8.
 */
public class Rate {

    private Integer rateId;

    private Integer type;//币种、毛利率、其他费率类型

    private String currency;//币种

    private String kind;//产品种类

    private String other;//其他费率

    private BigDecimal rate;//费率

    private BigDecimal grossMargin;//毛利

    private BigDecimal rateValue;//费率值

    private Date termofValidity;//有效期

    private String remarks;//备注

    public Integer getRateId(){
        return rateId;
    }

    public void setRateId(Integer rateId){
        this.rateId = rateId;
    }

    public Integer getType(){
        return type;
    }

    public void setType(Integer type){
        this.type = type;
    }

    public String getCurrency(){
        return currency;
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }

    public String getKind(){
        return kind;
    }

    public void setKind(String kind){
        this.kind = kind;
    }

    public String getOther(){
        return other;
    }

    public void setOther(String other){
        this.other = other;
    }

    public BigDecimal getRate(){
        return rate;
    }

    public void setRate(BigDecimal rate){
        this.rate = rate;
    }

    public BigDecimal getGrossMargin(){
        return grossMargin;
    }

    public void setGrossMargin(BigDecimal grossMargin){
        this.grossMargin = grossMargin; 
    }

    public BigDecimal getRateValue(){
        return rateValue;
    }

    public void setRateValue(BigDecimal rateValue){
        this.rateValue = rateValue;
    }

    public Date getTermofvalidity(){
        return termofValidity;
    }

    public void setTermofvalidity(Date termofValidity){
        this.termofValidity = termofValidity;
    }

    public String getRemarks(){
        return remarks;
    }

    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

}
