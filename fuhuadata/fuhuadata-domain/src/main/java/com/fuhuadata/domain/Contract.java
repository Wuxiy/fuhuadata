package com.fuhuadata.domain;

import java.math.BigDecimal;

/**
 * NC 合同
 * Created by wuxi on 2017/4/13.
 */
public class Contract {

    /**NC合同号**/
    private String ncOrderId;

    /**合同产品号**/
    private String ncOrderProductId;

    /**nc客户编码**/
    private String ncCustomerId;


    /**销售额**/
    private BigDecimal salesAmount;

    /**毛利润**/
    private BigDecimal grossProfit;


    /**毛利率**/
    private BigDecimal grossMargin;

    /**销售量**/
    private BigDecimal salesVolume;

    public String getNcOrderId() {
        return ncOrderId;
    }

    public void setNcOrderId(String ncOrderId) {
        this.ncOrderId = ncOrderId;
    }

    public String getNcCustomerId() {
        return ncCustomerId;
    }

    public void setNcCustomerId(String ncCustomerId) {
        this.ncCustomerId = ncCustomerId;
    }

    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    public BigDecimal getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(BigDecimal grossMargin) {
        this.grossMargin = grossMargin;
    }

    public BigDecimal getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(BigDecimal salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getNcOrderProductId() {
        return ncOrderProductId;
    }

    public void setNcOrderProductId(String ncOrderProductId) {
        this.ncOrderProductId = ncOrderProductId;
    }
}
