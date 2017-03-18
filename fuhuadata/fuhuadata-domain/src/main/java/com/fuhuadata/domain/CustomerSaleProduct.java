package com.fuhuadata.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangbo
 * @date 2017-01-12 13:41:04
 */
public class CustomerSaleProduct implements Serializable{

    /**主键id**/
	private Integer id;
	
    /**客户id**/
	private String customerId;
	
    /**年**/
	private String year;
	
    /**标准产品id(外键)**/
	private Integer productId;
	
    /**产品名称**/
	private String productName;
	
    /**品牌**/
	private String brand;
	
    /**营销手段**/
	private String marketingMethod;
	
    /**年销量**/
	private String yearSalesTotal;
	
    /**销售目的国**/
	private String destinationCountry1;

	/**销售目的国**/
	private String destinationCountry2;

	/**销售目的国**/
	private String destinationCountry3;

	/**年销量**/
	private String yearSales1;

	/**年销量**/
	private String yearSales2;

	/**年销量**/
	private String yearSales3;

	/**市场份额**/
	private String marketShare1;

	/**市场份额**/
	private String marketShare2;

	/**市场份额**/
	private String marketShare3;
	

    /**创建者id**/
	private Integer createUserId;
	
    /**创建者姓名**/
	private String createUserName;
	
    /**上一次修改者id**/
	private Integer lastmodifyUserId;
	
    /**上一次修改者姓名**/
	private String lastmodifyUserName;
	
    /**创建时间**/
	private String createTime;
	
    /**修改时间**/
	private String modifyTime;
	
	
	public CustomerSaleProduct() {
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMarketingMethod() {
		return marketingMethod;
	}

	public void setMarketingMethod(String marketingMethod) {
		this.marketingMethod = marketingMethod;
	}

	public String getYearSalesTotal() {
		return yearSalesTotal;
	}

	public void setYearSalesTotal(String yearSalesTotal) {
		this.yearSalesTotal = yearSalesTotal;
	}

	public String getDestinationCountry1() {
		return destinationCountry1;
	}

	public void setDestinationCountry1(String destinationCountry1) {
		this.destinationCountry1 = destinationCountry1;
	}

	public String getDestinationCountry2() {
		return destinationCountry2;
	}

	public void setDestinationCountry2(String destinationCountry2) {
		this.destinationCountry2 = destinationCountry2;
	}

	public String getDestinationCountry3() {
		return destinationCountry3;
	}

	public void setDestinationCountry3(String destinationCountry3) {
		this.destinationCountry3 = destinationCountry3;
	}

	public String getYearSales1() {
		return yearSales1;
	}

	public void setYearSales1(String yearSales1) {
		this.yearSales1 = yearSales1;
	}

	public String getYearSales2() {
		return yearSales2;
	}

	public void setYearSales2(String yearSales2) {
		this.yearSales2 = yearSales2;
	}

	public String getYearSales3() {
		return yearSales3;
	}

	public void setYearSales3(String yearSales3) {
		this.yearSales3 = yearSales3;
	}

	public String getMarketShare1() {
		return marketShare1;
	}

	public void setMarketShare1(String marketShare1) {
		this.marketShare1 = marketShare1;
	}

	public String getMarketShare2() {
		return marketShare2;
	}

	public void setMarketShare2(String marketShare2) {
		this.marketShare2 = marketShare2;
	}

	public String getMarketShare3() {
		return marketShare3;
	}

	public void setMarketShare3(String marketShare3) {
		this.marketShare3 = marketShare3;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
}