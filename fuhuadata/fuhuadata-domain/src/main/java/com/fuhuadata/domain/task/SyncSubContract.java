package com.fuhuadata.domain.task;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hexingfu on 2017/4/20.
 */
public class SyncSubContract implements Serializable {

    private Integer id;
    //合同明细类型 1：出口合同 2：转口合同
    private Integer type;
    //表体产品（物料）编码
    private String productCode;
    //NC表体主键
    private String pkContractB;
    //合同PK
    private String pkContract;
    //产品总金额
    private BigDecimal amount;
    //销售数量
    private BigDecimal num;
    //毛利润
    private BigDecimal grossProfit;
    //毛利率
    private BigDecimal grossRate;

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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPkContractB() {
        return pkContractB;
    }

    public void setPkContractB(String pkContractB) {
        this.pkContractB = pkContractB;
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

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    public BigDecimal getGrossRate() {
        return grossRate;
    }

    public void setGrossRate(BigDecimal grossRate) {
        this.grossRate = grossRate;
    }
}
