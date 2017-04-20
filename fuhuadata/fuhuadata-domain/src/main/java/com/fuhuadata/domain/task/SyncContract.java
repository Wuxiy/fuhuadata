package com.fuhuadata.domain.task;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * NC合同同步实体
 * Created by hexingfu on 2017/4/19.
 */
public class SyncContract implements Serializable {

    private Integer id;
    //1:出口合同 2：转口合同
    private Integer type;
    //长期协议pk
    private String pkLongpro;
    //nc合同pk
    private String pkContract;
    //总金额
    private BigDecimal amount;
    //毛利润
    private BigDecimal grossProfit;
    //同步时间
    private String syncTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPkLongpro() {
        return pkLongpro;
    }

    public void setPkLongpro(String pkLongpro) {
        this.pkLongpro = pkLongpro;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }
}
