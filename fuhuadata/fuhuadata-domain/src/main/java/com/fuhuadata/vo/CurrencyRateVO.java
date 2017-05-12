package com.fuhuadata.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>User: wangjie
 * <p>Date: 5/10/2017
 */
public class CurrencyRateVO {

    // 币种 id
    private String id;

    // 币种 code
    private String code;

    // 币种名称
    private String name;

    // 对美元汇率 id
    private Integer usdRateId;

    // 对美元汇率
    private BigDecimal usdRate;

    // 对美元汇率上次修改时间
    private Date usdUpdateTime;

    // 对人民币汇率 id
    private Integer cnyRateId;

    // 对人民币汇率
    private BigDecimal cnyRate;

    // 对人民币汇率上次修改时间
    private Date cnyUpdateTime;

    // 备注
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUsdRateId() {
        return usdRateId;
    }

    public void setUsdRateId(Integer usdRateId) {
        this.usdRateId = usdRateId;
    }

    public BigDecimal getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(BigDecimal usdRate) {
        this.usdRate = usdRate;
    }

    public Date getUsdUpdateTime() {
        return usdUpdateTime;
    }

    public void setUsdUpdateTime(Date usdUpdateTime) {
        this.usdUpdateTime = usdUpdateTime;
    }

    public Integer getCnyRateId() {
        return cnyRateId;
    }

    public void setCnyRateId(Integer cnyRateId) {
        this.cnyRateId = cnyRateId;
    }

    public BigDecimal getCnyRate() {
        return cnyRate;
    }

    public void setCnyRate(BigDecimal cnyRate) {
        this.cnyRate = cnyRate;
    }

    public Date getCnyUpdateTime() {
        return cnyUpdateTime;
    }

    public void setCnyUpdateTime(Date cnyUpdateTime) {
        this.cnyUpdateTime = cnyUpdateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
