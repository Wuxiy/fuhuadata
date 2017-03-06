package com.fuhuadata.domain;

import com.fuhuadata.util.DateJsonDeserializer;
import com.fuhuadata.util.DateJsonSerializer;
import com.fuhuadata.util.JsonUtils;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
import java.math.BigDecimal;

/**
 * 标准产品档案
 * @author wangbo
 * @date 2017-01-24 10:45:54
 */
public class ProductInfo{

    /**标准产品id**/
	private Integer productId;
	
    /**一级产品id**/
	private Integer bigCategoryId;

	/**二级产品id**/
	private Integer midCategoryId;

	/**三级产品id**/
	private Integer smallCategoryId;

    /**`**/
	private String categoryName;

	/**产品名称**/
	private String name;

	/**主计量单位**/
	private String  measurement;
	
    /**产品浓度含量,和父级名称一起生成名称**/
	private BigDecimal concentration;

	
    /**0无，1异丙胺盐，2铵盐，3钾盐，4二甲铵盐，5其他**/
	private Integer saltType;
	
    /**其他盐类名称**/
	private String otherSaltName;
	
    /**执行标准，-1全部，0国际标准，1国家标准，2行业标准，3福华通达企业标准，4其他**/
	private Integer executeStandard;
	
    /**执行标准号**/
	private String executeNumer;
	
    /**执行标准备注说明**/
	private String executeRemarks;
	
    /**产品特点**/
	private String productFeature;

    /**加工成分,序列化数据格式**/
	private String processingComponents;
	
    /**理化指标,序列化数据格式**/
	private String physicalProperities;


	
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
	
	
	public ProductInfo() {
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public BigDecimal getConcentration() {
		return concentration;
	}
	
	public void setConcentration(BigDecimal concentration) {
		this.concentration = concentration;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	public Integer getSaltType() {
		return saltType;
	}
	
	public void setSaltType(Integer saltType) {
		this.saltType = saltType;
	}
	
	public String getOtherSaltName() {
		return otherSaltName;
	}
	
	public void setOtherSaltName(String otherSaltName) {
		this.otherSaltName = otherSaltName;
	}
	
	public Integer getExecuteStandard() {
		return executeStandard;
	}
	
	public void setExecuteStandard(Integer executeStandard) {
		this.executeStandard = executeStandard;
	}
	
	public String getExecuteNumer() {
		return executeNumer;
	}
	
	public void setExecuteNumer(String executeNumer) {
		this.executeNumer = executeNumer;
	}
	
	public String getExecuteRemarks() {
		return executeRemarks;
	}
	
	public void setExecuteRemarks(String executeRemarks) {
		this.executeRemarks = executeRemarks;
	}
	
	public String getProductFeature() {
		return productFeature;
	}
	
	public void setProductFeature(String productFeature) {
		this.productFeature = productFeature;
	}

	public String getProcessingComponents() {
		return processingComponents;
	}
	
	public void setProcessingComponents(String processingComponents) {
		this.processingComponents = processingComponents;
	}
	
	public String getPhysicalProperities() {
		return physicalProperities;
	}
	
	public void setPhysicalProperities(String physicalProperities) {
		this.physicalProperities = physicalProperities;
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

	@JsonSerialize(using = DateJsonSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}
	@JsonDeserialize(using = DateJsonDeserializer.class)
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonSerialize(using = DateJsonSerializer.class)
	public Date getModifyTime() {
		return modifyTime;
	}

	@JsonDeserialize(using = DateJsonDeserializer.class)
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getBigCategoryId() {
		return bigCategoryId;
	}

	public void setBigCategoryId(Integer bigCategoryId) {
		this.bigCategoryId = bigCategoryId;
	}

	public Integer getMidCategoryId() {
		return midCategoryId;
	}

	public void setMidCategoryId(Integer midCategoryId) {
		this.midCategoryId = midCategoryId;
	}

	public Integer getSmallCategoryId() {
		return smallCategoryId;
	}

	public void setSmallCategoryId(Integer smallCategoryId) {
		this.smallCategoryId = smallCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
}