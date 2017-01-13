package com.fuhuadata.domain;

import java.util.Date;
import java.math.BigDecimal;
/**
 * @author wangbo
 * @date 2017-01-12 13:51:34
 */
public class CustomerPurchaseProduct{

    /**主键id**/
	private Integer id;
	
    /**客户id**/
	private String customerId;
	
    /**年**/
	private String year;
	
    /**标准产品id（外键）**/
	private Integer productId;
	
    /**产品名称**/
	private String productName;
	
    /**年需求量**/
	private String annualDemands;
	
    /**平均单价，美元计**/
	private BigDecimal averagePrice;
	
    /**供应商1**/
	private String supplier1;
	
    /**年采购量1**/
	private String purchaseAmount1;
	
    /**平均单价1**/
	private BigDecimal averagePrice1;
	
    /**供应商2**/
	private String supplier2;
	
    /**年采购量2**/
	private String purchaseAmount2;
	
    /**平均单价2**/
	private BigDecimal averagePrice2;
	
    /**供应商3**/
	private String supplier3;
	
    /**年采购量3**/
	private String purchaseAmount3;
	
    /**平均单价3**/
	private BigDecimal averagePrice3;
	
    /**创建者id**/
	private Integer createUserId;
	
    /**创建者姓名**/
	private String createUserName;
	
    /**上一次修改者id**/
	private Integer lastmodifyUserId;
	
    /**上一次修改者姓名**/
	private String lastmodifyUserName;
	
    /**创建时间**/
	private Date createTime;
	
    /**修改时间**/
	private Date modifyTime;
	
	
	public CustomerPurchaseProduct() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getAnnualDemands() {
		return annualDemands;
	}
	
	public void setAnnualDemands(String annualDemands) {
		this.annualDemands = annualDemands;
	}
	
	public BigDecimal getAveragePrice() {
		return averagePrice;
	}
	
	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
	}
	
	public String getSupplier1() {
		return supplier1;
	}
	
	public void setSupplier1(String supplier1) {
		this.supplier1 = supplier1;
	}
	
	public String getPurchaseAmount1() {
		return purchaseAmount1;
	}
	
	public void setPurchaseAmount1(String purchaseAmount1) {
		this.purchaseAmount1 = purchaseAmount1;
	}
	
	public BigDecimal getAveragePrice1() {
		return averagePrice1;
	}
	
	public void setAveragePrice1(BigDecimal averagePrice1) {
		this.averagePrice1 = averagePrice1;
	}
	
	public String getSupplier2() {
		return supplier2;
	}
	
	public void setSupplier2(String supplier2) {
		this.supplier2 = supplier2;
	}
	
	public String getPurchaseAmount2() {
		return purchaseAmount2;
	}
	
	public void setPurchaseAmount2(String purchaseAmount2) {
		this.purchaseAmount2 = purchaseAmount2;
	}
	
	public BigDecimal getAveragePrice2() {
		return averagePrice2;
	}
	
	public void setAveragePrice2(BigDecimal averagePrice2) {
		this.averagePrice2 = averagePrice2;
	}
	
	public String getSupplier3() {
		return supplier3;
	}
	
	public void setSupplier3(String supplier3) {
		this.supplier3 = supplier3;
	}
	
	public String getPurchaseAmount3() {
		return purchaseAmount3;
	}
	
	public void setPurchaseAmount3(String purchaseAmount3) {
		this.purchaseAmount3 = purchaseAmount3;
	}
	
	public BigDecimal getAveragePrice3() {
		return averagePrice3;
	}
	
	public void setAveragePrice3(BigDecimal averagePrice3) {
		this.averagePrice3 = averagePrice3;
	}
	
	public Integer getCreateUserId() {
		return createUserId;
	}
	
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	
	public String getCreateUserName() {
		return createUserName;
	}
	
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	
	public Integer getLastmodifyUserId() {
		return lastmodifyUserId;
	}
	
	public void setLastmodifyUserId(Integer lastmodifyUserId) {
		this.lastmodifyUserId = lastmodifyUserId;
	}
	
	public String getLastmodifyUserName() {
		return lastmodifyUserName;
	}
	
	public void setLastmodifyUserName(String lastmodifyUserName) {
		this.lastmodifyUserName = lastmodifyUserName;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getModifyTime() {
		return modifyTime;
	}
	
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	

}