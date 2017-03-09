package com.fuhuadata.vo;

/**
 * 客户产品包装档案
 * Created by intanswer on 2017/3/7.
 */
public class CustomerProductPackagingArchives {
    private String customerId;
//    private String customer;//客户名称
    private String customerProductId;//客户商品id
    private String customerProductName;//客户商品名
    private String categorySerialNumber;//品类序列号
    private String categoryName;//品类
    private String productName;//产品名称
    private String brand;//品牌
    private String specification;//规格
    private String model;//型号
    private String mainUnit;//主单位
    private Integer factoryId;//加工产id
    private String factoryName;//加工厂名称

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMainUnit() {
        return mainUnit;
    }

    public void setMainUnit(String mainUnit) {
        this.mainUnit = mainUnit;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerProductId() {
        return customerProductId;
    }

    public void setCustomerProductId(String customerProductId) {
        this.customerProductId = customerProductId;
    }


    public String getCategorySerialNumber() {
        return categorySerialNumber;
    }

    public void setCategorySerialNumber(String categorySerialNumber) {
        this.categorySerialNumber = categorySerialNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getCustomerProductName() {
        return customerProductName;
    }

    public void setCustomerProductName(String customerProductName) {
        this.customerProductName = customerProductName;
    }
}
