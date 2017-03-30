package com.fuhuadata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商机订单产品
 * Created by intanswer on 2017/3/28.
 */
public class BusinessOrderProduct {
    /**编号**/
    private Integer id;

    /**订单编号**/
    private String orderId;

    /**客户产品id**/
    private Integer archiveProductId;

    /**标准产品id**/
    private Integer productId;
    /**报关产品编码**/
    private String customsClearanceId;
    /**报关产品名称**/
    private String customsClearanceName;
    /**客户id**/
    private String customerId;

    /**产品名称**/
    private String name;

    /**客户商品名**/
    private String customerProductName;

    /**品牌**/
    private String brand;

    /**主产品数量**/
    private BigDecimal mainProductAmount;

    /**主产品单位**/
    private Integer mainProductUnit;

    /**辅产品数量**/
    private BigDecimal subProductAmount;

    /**辅产品单位**/
    private Integer subProductUnit;

    /**换算率**/
    private BigDecimal convertRate;

    /**价格计算类型**/
    private Integer priceType;

    /**价委会指导价**/
    private BigDecimal advisePrice;

    /**采购价格**/
    private BigDecimal purchasePrice;

    /**交货时间**/
    private Date deliveryTime;

    /**内运方式**/
    private Integer internalTransportMode;

    /**内运费单价**/
    private BigDecimal internalTransportPrice;

    /**加工厂id**/
    private String factoryId;

    /**加工厂名称**/
    private String factoryName;

    /**明佣计费方式**/
    private Integer straightEmployingWay;

    /**明佣比例**/
    private BigDecimal straightEmployingScale;

    /**明佣标准**/
    private String straightEmployingStandard;

    /**暗佣计费方式**/
    private Integer potentialEmployingWay;

    /**暗佣比例**/
    private BigDecimal potentialEmployingScale;

    /**暗佣标准**/
    private String potentialEmployingStandard;

    /**单据类型**/
    private Integer documentaryType;

    /**单据要求**/
    private String documentaryRequire;

    /**其他单据要求**/
    private String otherDocumentaryRequire;

    /**对船公司要求**/
    private String shippingAgentRequire;

    /**装箱要求**/
    private String packageRequire;

    /**出运货物**/
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
    private Integer cupboardNumber;

    /**海运费单价**/
    private BigDecimal oceanFreight;

    /**港杂费单价**/
    private BigDecimal portSurcharge;

    /**出口退税率**/
    private BigDecimal taxFree;

    /**出口退税方式1:按销售价退税 2：按采购价 3：不退税**/
    private Integer taxType;

    /**毛利率**/
    private BigDecimal grossMargin;

    /**其他费用单价**/
    private BigDecimal otherCost;

    /**最低销售单价**/
    private BigDecimal minPrice;

    /**合同单价**/
    private BigDecimal contractPrice;

    /**转化状态**/
    private Integer transformState;

    /**加工成分及费用**/
    private String compositionCost;

    /**包装其他要求**/
    private String pakageOtherRequirement;

    /**附加单价**/
    private BigDecimal additionalPrice;

    /**单耗**/
    private BigDecimal consumption;

    /**包装图片信息**/
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

    /**创建者时间**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**修改时间**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;
    /**主包材id**/
    private Integer mainPackingId;

    public Integer getMainPackingId() {
        return mainPackingId;
    }

    public void setMainPackingId(Integer mainPackingId) {
        this.mainPackingId = mainPackingId;
    }

    public Integer getTaxType() {
        return taxType;
    }

    public void setTaxType(Integer taxType) {
        this.taxType = taxType;
    }

    public String getCustomsClearanceId() {
        return customsClearanceId;
    }

    public void setCustomsClearanceId(String customsClearanceId) {
        this.customsClearanceId = customsClearanceId;
    }

    public String getCustomsClearanceName() {
        return customsClearanceName;
    }

    public void setCustomsClearanceName(String customsClearanceName) {
        this.customsClearanceName = customsClearanceName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getArchiveProductId() {
        return archiveProductId;
    }

    public void setArchiveProductId(Integer archiveProductId) {
        this.archiveProductId = archiveProductId;
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

    public String getCustomerProductName() {
        return customerProductName;
    }

    public void setCustomerProductName(String customerProductName) {
        this.customerProductName = customerProductName;
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
        return internalTransportMode;
    }

    public void setInternalTransportMode(Integer internalTransportMode) {
        this.internalTransportMode = internalTransportMode;
    }

    public BigDecimal getInternalTransportPrice() {
        return internalTransportPrice;
    }

    public void setInternalTransportPrice(BigDecimal internalTransportPrice) {
        this.internalTransportPrice = internalTransportPrice;
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

    public Integer getCupboardNumber() {
        return cupboardNumber;
    }

    public void setCupboardNumber(Integer cupboardNumber) {
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

    public BigDecimal getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(BigDecimal grossMargin) {
        this.grossMargin = grossMargin;
    }

    public BigDecimal getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(BigDecimal otherCost) {
        this.otherCost = otherCost;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public Integer getTransformState() {
        return transformState;
    }

    public void setTransformState(Integer transformState) {
        this.transformState = transformState;
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
