package com.fuhuadata.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 客户订单汇总购买信息实体主要用作统计查询
 * Created by hexingfu on 2017/3/11.
 */
public class CountCustomersOrderProduct implements Serializable{

    private String customerId;//客户id
    private String productId;//产品id
    private String productName;//产品名称
    private String categoryName;//种类名称
    private String totalSaleNum;//总销量
    private BigDecimal totalSaleMoney;//总销售额
    private BigDecimal totalMinPrice;//总最低销售限价
    private BigDecimal totalProfit;//总利润
    private String measurement;//主计量单位

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTotalSaleNum() {
        return totalSaleNum;
    }

    public void setTotalSaleNum(String totalSaleNum) {
        this.totalSaleNum = totalSaleNum;
    }

    public BigDecimal getTotalSaleMoney() {
        return totalSaleMoney;
    }

    public void setTotalSaleMoney(BigDecimal totalSaleMoney) {
        this.totalSaleMoney = totalSaleMoney;
    }

    public BigDecimal getTotalMinPrice() {
        return totalMinPrice;
    }

    public void setTotalMinPrice(BigDecimal totalMinPrice) {
        this.totalMinPrice = totalMinPrice;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }
}
