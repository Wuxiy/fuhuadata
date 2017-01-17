package com.fuhuadata.domain.query;
import java.util.Date;

/**
 * @author wangbo
 * @date 2017-01-12 13:41:04
 */
public class QueryCustomerSaleProduct extends PageBase {

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
	private String yearSales;
	
    /**销售目的国**/
	private String destinationCountry;
	
    /**主要采购商**/
	private String mainPruchaser;
	
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
	
	public String getYearSales() {
		return yearSales;
	}
	
	public void setYearSales(String yearSales) {
		this.yearSales = yearSales;
	}
	
	public String getDestinationCountry() {
		return destinationCountry;
	}
	
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	
	public String getMainPruchaser() {
		return mainPruchaser;
	}
	
	public void setMainPruchaser(String mainPruchaser) {
		this.mainPruchaser = mainPruchaser;
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