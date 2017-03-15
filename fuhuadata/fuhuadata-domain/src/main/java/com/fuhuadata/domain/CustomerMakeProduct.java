package com.fuhuadata.domain;

/**
 * 客户产品产能
 * Created by intanswer on 2017/3/14.
 */
public class CustomerMakeProduct {

    private Integer id;//编号

    private String customerId;//客户ID

    private String productName;//客户生产产品名

    private String production;//产能

    public CustomerMakeProduct() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
