package com.fuhuadata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
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
    /**规格id**/
    private Integer wareId;

    /**报关产品编码**/
    private String customsClearanceId;
    /**报关产品名称**/
    private String customsClearanceName;
    /**客户id**/
    private String customerId;

    /**产品名称**/
    @NotBlank
    private String name;

    /**客户商品名**/
    private String customerProductName;

    /**品牌**/
    private String brand;

    /**主产品数量**/
    @NotNull
    private BigDecimal mainProductAmount;

    /**主产品单位**/
    @NotBlank
    private String mainProductUnit;

    /**辅产品数量**/
    private BigDecimal subProductAmount;

    /**辅产品单位**/
    private Integer subProductUnit;

    /**换算率**/
    private BigDecimal convertRate;

    /**价格计算类型,01自产类，02原药制剂自产类加工，03贸易类，04原药采购制剂加工，09其他**/
    @NotBlank
    private String priceType;

    /**价委会指导价**/
    @NotNull
    private BigDecimal advisePrice;

    /**采购价格**/
    @NotNull
    private BigDecimal purchasePrice;

    /**交货时间**/
    @NotBlank
    private String deliveryTime;

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
    private BigDecimal cupboardNumber;

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
    //加工费
    private BigDecimal processCost;

    /**其他费用单价**/
    private BigDecimal otherCost;

    /**最低销售单价**/
    private BigDecimal minPrice;

    /**合同单价**/
    private BigDecimal contractPrice;

    /** 转化状态,0未转化，1已转化**/
    private Integer transformState;

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


    /**内部供货单位id**/
    private String internalSupplyId;

    /**内部供货单位**/
    private String internalSupplyName;
    //单位耗用比例
    private BigDecimal unitUseRate;
    //佣金单价
    private BigDecimal commissionPrice;
    //资金利息单价
    private BigDecimal capitalInterestPrice;


    //==============非本表字段，用于前端显示=======================
    //规格
    private String specification;
    //型号
    private String model;

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

    //=====================================

    public BigDecimal getCapitalInterestPrice() {
        return capitalInterestPrice;
    }

    public void setCapitalInterestPrice(BigDecimal capitalInterestPrice) {
        this.capitalInterestPrice = capitalInterestPrice;
    }

    public BigDecimal getCommissionPrice() {
        return commissionPrice;
    }

    public void setCommissionPrice(BigDecimal commissionPrice) {
        this.commissionPrice = commissionPrice;
    }

    public BigDecimal getUnitUseRate() {
        return unitUseRate;
    }

    public void setUnitUseRate(BigDecimal unitUseRate) {
        this.unitUseRate = unitUseRate;
    }

    public BigDecimal getProcessCost() {
        return processCost;
    }

    public void setProcessCost(BigDecimal processCost) {
        this.processCost = processCost;
    }

    public String getInternalSupplyId() {
        return internalSupplyId;
    }

    public void setInternalSupplyId(String internalSupplyId) {
        this.internalSupplyId = internalSupplyId;
    }

    public String getInternalSupplyName() {
        return internalSupplyName;
    }

    public void setInternalSupplyName(String internalSupplyName) {
        this.internalSupplyName = internalSupplyName;
    }

    public Integer getWareId() {
        return wareId;
    }

    public void setWareId(Integer wareId) {
        this.wareId = wareId;
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

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
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

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
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

    public String getMainProductUnit() {
        return mainProductUnit;
    }

    public void setMainProductUnit(String mainProductUnit) {
        this.mainProductUnit = mainProductUnit;
    }
}
