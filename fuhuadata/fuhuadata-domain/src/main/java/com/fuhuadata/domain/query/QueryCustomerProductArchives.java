package com.fuhuadata.domain.query;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangbo
 * @date 2017-02-03 15:51:13
 */
public class QueryCustomerProductArchives extends PageBase {
	/**客户产品id**/
	private Integer id;

	/**标准产品id**/
	private Integer productId;

	/**产品规格id**/
	private Integer wareId;

	/**订单id**/
	private Integer orderId;

	/**客户编号id**/
	private String customerId;

	/**产品名称**/
	private String name;

	private String customerProductName;
	/**品牌**/
	private String brand;

	/**主产品数量**/
	private BigDecimal mainProductAmount;

	/**主产品单位,0L,1KG**/
	private Integer mainProductUnit;

	/**从产品数量**/
	private BigDecimal subProductAmount;

	/**从产品单位0L,1KG**/
	private Integer subProductUnit;

	/**换算率**/
	private BigDecimal convertRate;

	/**价格计算类型,0自产类，1原药制剂自产类加工，2原药采购制剂加工，3贸易类，4其他**/
	private Integer priceType;

	/**价委会指导价**/
	private BigDecimal advisePrice;

	/**采购价格**/
	private BigDecimal purchasePrice;

	/**交货时间**/
	private Date deliveryTime;

	/**内运方式,0空，1汽运+江运，2汽运，3江运**/
	private Integer InternalTransportMode;

	/**内运费单价**/
	private BigDecimal InternalTransportPrice;

	/**加工厂id**/
	private String factoryId;

	/**加工厂名称**/
	private String factoryName;

	/**明佣计费方式,0从价，1从量，2无**/
	private Integer straightEmployingWay;

	/**明佣比例**/
	private BigDecimal straightEmployingScale;

	/**明佣标准**/
	private String straightEmployingStandard;

	/**暗佣计费方式，0从价，1从量，2无**/
	private Integer potentialEmployingWay;

	/**暗佣比例**/
	private BigDecimal potentialEmployingScale;

	/**暗佣标准**/
	private String potentialEmployingStandard;

	/**单据类型,0信用证条款单据，0非信用证条款单据**/
	private Integer documentaryType;

	/**单据要求,json格式数据**/
	private String documentaryRequire;

	/**其他单据要求**/
	private String otherDocumentaryRequire;

	/**对船公司要求**/
	private String shippingAgentRequire;

	/**装箱要求**/
	private String packageRequire;

	/**出运货物货物类型，0普通，1危险品**/
	private Integer goodsType;

	/**免用箱期**/
	private Integer mianxiangqi;

	/**免推期**/
	private Integer miantuiqi;

	/**柜子规格**/
	private Integer cupboardType;

	/**整柜数量**/
	private Integer cupboardPerNumber;

	/**柜数**/
	private BigDecimal cupboardNumber;

	/**海运费估算**/
	private BigDecimal oceanFreight;

	/**港杂费**/
	private BigDecimal portSurcharge;

	/**出口退税率**/
	private BigDecimal taxFree;

	/**毛利率**/
	private BigDecimal grossMargin;

	/**其他费用单价**/
	private BigDecimal otherCost;

	/**最低销售价**/
	private BigDecimal minSellPrice;

	/**合同单价**/
	private BigDecimal contractPrice;

	/**转化状态 0未未转化，1已转化**/
	private Integer transformState;


	/**加工成分及费用json**/
	private String compositionCost;

	/**包装其他要求**/
	private String pakageOtherRequirement;

	/**附加单价**/
	private BigDecimal additionalPrice;

	/**单耗**/
	private BigDecimal consumption;

	/**包装图片要求**/
	private String imgInfo;

	/**包装要求**/
	private String pakageInfo;

	/**包材要求**/
	private String materialInfo;




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

	//单位耗用比例
	private BigDecimal unitUseRate;
	//佣金单价
	private BigDecimal commissionPrice;
	//资金利息单价
	private BigDecimal capitalInterestPrice;

	public BigDecimal getUnitUseRate() {
		return unitUseRate;
	}

	public void setUnitUseRate(BigDecimal unitUseRate) {
		this.unitUseRate = unitUseRate;
	}

	public BigDecimal getCommissionPrice() {
		return commissionPrice;
	}

	public void setCommissionPrice(BigDecimal commissionPrice) {
		this.commissionPrice = commissionPrice;
	}

	public BigDecimal getCapitalInterestPrice() {
		return capitalInterestPrice;
	}

	public void setCapitalInterestPrice(BigDecimal capitalInterestPrice) {
		this.capitalInterestPrice = capitalInterestPrice;
	}

	public Integer getWareId() {
		return wareId;
	}

	public void setWareId(Integer wareId) {
		this.wareId = wareId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerProductName() {
		return customerProductName;
	}

	public void setCustomerProductName(String customerProductName) {
		this.customerProductName = customerProductName;
	}

	public String getCompositionCost() {
		return compositionCost;
	}

	public void setCompositionCost(String compositionCost) {
		this.compositionCost = compositionCost;
	}

	public String getPakageOtherRequirement() {
		return pakageOtherRequirement;
	}

	public void setPakageOtherRequirement(String pakageOtherRequirement) {
		this.pakageOtherRequirement = pakageOtherRequirement;
	}

	public BigDecimal getAdditionalPrice() {
		return additionalPrice;
	}

	public void setAdditionalPrice(BigDecimal additionalPrice) {
		this.additionalPrice = additionalPrice;
	}

	public BigDecimal getConsumption() {
		return consumption;
	}

	public void setConsumption(BigDecimal consumption) {
		this.consumption = consumption;
	}

	public String getImgInfo() {
		return imgInfo;
	}

	public void setImgInfo(String imgInfo) {
		this.imgInfo = imgInfo;
	}

	public String getPakageInfo() {
		return pakageInfo;
	}

	public void setPakageInfo(String pakageInfo) {
		this.pakageInfo = pakageInfo;
	}

	public String getMaterialInfo() {
		return materialInfo;
	}

	public void setMaterialInfo(String materialInfo) {
		this.materialInfo = materialInfo;
	}

	public QueryCustomerProductArchives() {
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	public BigDecimal getMainProductAmount() {
		return mainProductAmount;
	}

	public void setMainProductAmount(BigDecimal mainProductAmount) {
		this.mainProductAmount = mainProductAmount;
	}

	public Integer getMainProductUnit() {
		return mainProductUnit;
	}

	public void setMainProductUnit(Integer mainProductUnit) {
		this.mainProductUnit = mainProductUnit;
	}

	public BigDecimal getSubProductAmount() {
		return subProductAmount;
	}

	public void setSubProductAmount(BigDecimal subProductAmount) {
		this.subProductAmount = subProductAmount;
	}

	public Integer getSubProductUnit() {
		return subProductUnit;
	}

	public void setSubProductUnit(Integer subProductUnit) {
		this.subProductUnit = subProductUnit;
	}

	public BigDecimal getConvertRate() {
		return convertRate;
	}

	public void setConvertRate(BigDecimal convertRate) {
		this.convertRate = convertRate;
	}

	public Integer getPriceType() {
		return priceType;
	}

	public void setPriceType(Integer priceType) {
		this.priceType = priceType;
	}

	public BigDecimal getAdvisePrice() {
		return advisePrice;
	}

	public void setAdvisePrice(BigDecimal advisePrice) {
		this.advisePrice = advisePrice;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getInternalTransportMode() {
		return InternalTransportMode;
	}

	public void setInternalTransportMode(Integer InternalTransportMode) {
		this.InternalTransportMode = InternalTransportMode;
	}

	public BigDecimal getInternalTransportPrice() {
		return InternalTransportPrice;
	}

	public void setInternalTransportPrice(BigDecimal InternalTransportPrice) {
		this.InternalTransportPrice = InternalTransportPrice;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public Integer getStraightEmployingWay() {
		return straightEmployingWay;
	}

	public void setStraightEmployingWay(Integer straightEmployingWay) {
		this.straightEmployingWay = straightEmployingWay;
	}

	public BigDecimal getStraightEmployingScale() {
		return straightEmployingScale;
	}

	public void setStraightEmployingScale(BigDecimal straightEmployingScale) {
		this.straightEmployingScale = straightEmployingScale;
	}

	public String getStraightEmployingStandard() {
		return straightEmployingStandard;
	}

	public void setStraightEmployingStandard(String straightEmployingStandard) {
		this.straightEmployingStandard = straightEmployingStandard;
	}

	public Integer getPotentialEmployingWay() {
		return potentialEmployingWay;
	}

	public void setPotentialEmployingWay(Integer potentialEmployingWay) {
		this.potentialEmployingWay = potentialEmployingWay;
	}

	public BigDecimal getPotentialEmployingScale() {
		return potentialEmployingScale;
	}

	public void setPotentialEmployingScale(BigDecimal potentialEmployingScale) {
		this.potentialEmployingScale = potentialEmployingScale;
	}

	public String getPotentialEmployingStandard() {
		return potentialEmployingStandard;
	}

	public void setPotentialEmployingStandard(String potentialEmployingStandard) {
		this.potentialEmployingStandard = potentialEmployingStandard;
	}

	public Integer getDocumentaryType() {
		return documentaryType;
	}

	public void setDocumentaryType(Integer documentaryType) {
		this.documentaryType = documentaryType;
	}

	public String getDocumentaryRequire() {
		return documentaryRequire;
	}

	public void setDocumentaryRequire(String documentaryRequire) {
		this.documentaryRequire = documentaryRequire;
	}

	public String getOtherDocumentaryRequire() {
		return otherDocumentaryRequire;
	}

	public void setOtherDocumentaryRequire(String otherDocumentaryRequire) {
		this.otherDocumentaryRequire = otherDocumentaryRequire;
	}

	public String getShippingAgentRequire() {
		return shippingAgentRequire;
	}

	public void setShippingAgentRequire(String shippingAgentRequire) {
		this.shippingAgentRequire = shippingAgentRequire;
	}

	public String getPackageRequire() {
		return packageRequire;
	}

	public void setPackageRequire(String packageRequire) {
		this.packageRequire = packageRequire;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getMianxiangqi() {
		return mianxiangqi;
	}

	public void setMianxiangqi(Integer mianxiangqi) {
		this.mianxiangqi = mianxiangqi;
	}

	public Integer getMiantuiqi() {
		return miantuiqi;
	}

	public void setMiantuiqi(Integer miantuiqi) {
		this.miantuiqi = miantuiqi;
	}

	public Integer getCupboardType() {
		return cupboardType;
	}

	public void setCupboardType(Integer cupboardType) {
		this.cupboardType = cupboardType;
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

	public BigDecimal getOceanFreight() {
		return oceanFreight;
	}

	public void setOceanFreight(BigDecimal oceanFreight) {
		this.oceanFreight = oceanFreight;
	}

	public BigDecimal getPortSurcharge() {
		return portSurcharge;
	}

	public void setPortSurcharge(BigDecimal portSurcharge) {
		this.portSurcharge = portSurcharge;
	}

	public BigDecimal getTaxFree() {
		return taxFree;
	}

	public void setTaxFree(BigDecimal taxFree) {
		this.taxFree = taxFree;
	}

	public BigDecimal getOtherCost() {
		return otherCost;
	}

	public void setOtherCost(BigDecimal otherCost) {
		this.otherCost = otherCost;
	}

	public BigDecimal getMinSellPrice() {
		return minSellPrice;
	}

	public void setMinSellPrice(BigDecimal minSellPrice) {
		this.minSellPrice = minSellPrice;
	}

	public BigDecimal getContractPrice() {
		return contractPrice;
	}

	public void setContractPrice(BigDecimal contractPrice) {
		this.contractPrice = contractPrice;
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


	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getGrossMargin() {
		return grossMargin;
	}

	public void setGrossMargin(BigDecimal grossMargin) {
		this.grossMargin = grossMargin;
	}

	public Integer getTransformState() {
		return transformState;
	}

	public void setTransformState(Integer transformState) {
		this.transformState = transformState;
	}
}