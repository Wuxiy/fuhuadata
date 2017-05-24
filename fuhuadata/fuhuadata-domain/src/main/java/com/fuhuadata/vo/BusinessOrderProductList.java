package com.fuhuadata.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户订单产品列表
 * Created by intanswer on 2017/4/17.
 */
public class BusinessOrderProductList {

    private String orderId;//订单id
    private String customerProductName;//客户商品名
    private String categorySerialNumber;//品类序列号
    private Integer productCode;//产品序列号
    private String categoryName;//品类
    private String productName;//产品名称
    private String brand;//品牌

    private Integer transformState;//转化状态

    private BigDecimal contractPrice;//合同单价

    private Integer businessProductId ;//订单产品id
    private Integer productRequireId;//产品要求id

    private String specification;//规格

    private String packingSpecification;//包装规格

    private String model;//型号

    private BigDecimal mainProductAmount=null;//主产品数量

    private Integer cupboardPerNumber= null;//整柜数量

    private BigDecimal cupboardNumber=null;//柜数

    private Integer cupboardType = null;//柜子规格

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deliveryTime;//交货时间

    private BigDecimal minPrice;//最低销售价


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerProductName() {
        return customerProductName;
    }

    public void setCustomerProductName(String customerProductName) {
        this.customerProductName = customerProductName;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getMainProductAmount() {
        return mainProductAmount;
    }

    public void setMainProductAmount(BigDecimal mainProductAmount) {
        this.mainProductAmount = mainProductAmount;
    }

    public Integer getCupboardPerNumber() {
        return cupboardPerNumber;
    }

    public void setCupboardPerNumber(Integer cupboardPerNumber) {
        this.cupboardPerNumber = cupboardPerNumber;
    }

    public BigDecimal getCupboardNumber() {
        return cupboardNumber;
    }

    public void setCupboardNumber(BigDecimal cupboardNumber) {
        this.cupboardNumber = cupboardNumber;
    }

    public Integer getCupboardType() {
        return cupboardType;
    }

    public void setCupboardType(Integer cupboardType) {
        this.cupboardType = cupboardType;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }


    public String getPackingSpecification() {
        return packingSpecification;
    }

    public void setPackingSpecification(String packingSpecification) {
        this.packingSpecification = packingSpecification;
    }

    public Integer getProductRequireId() {
        return productRequireId;
    }

    public void setProductRequireId(Integer productRequireId) {
        this.productRequireId = productRequireId;
    }

    public Integer getBusinessProductId() {
        return businessProductId;
    }

    public void setBusinessProductId(Integer businessProductId) {
        this.businessProductId = businessProductId;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public Integer getTransformState() {
        return transformState;
    }

    public void setTransformState(Integer transformState) {
        this.transformState = transformState;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }
}
