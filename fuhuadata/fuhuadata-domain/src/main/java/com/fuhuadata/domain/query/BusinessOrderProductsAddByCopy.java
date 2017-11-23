package com.fuhuadata.domain.query;

import java.math.BigDecimal;

/**
 * Created by zhangxiang on 2017/11/21.
 */
public class BusinessOrderProductsAddByCopy {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String orderId;
    private String originalBusinessProductId;
    private BigDecimal mainProductAmount;
    private String deliveryTime;
    private Integer businessProductId;

    public Integer getBusinessProductId() {
        return businessProductId;
    }

    public void setBusinessProductId(Integer businessProductId) {
        this.businessProductId = businessProductId;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOriginalBusinessProductId() {
        return originalBusinessProductId;
    }

    public void setOriginalBusinessProductId(String originalBusinessProductId) {
        this.originalBusinessProductId = originalBusinessProductId;
    }

    public BigDecimal getMainProductAmount() {
        return mainProductAmount;
    }

    public void setMainProductAmount(BigDecimal mainProductAmount) {
        this.mainProductAmount = mainProductAmount;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
