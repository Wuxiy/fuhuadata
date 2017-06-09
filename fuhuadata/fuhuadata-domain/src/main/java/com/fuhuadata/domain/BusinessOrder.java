package com.fuhuadata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商机报价基本信息
 * Created by hexingfu on 2017/3/16.
 */
public class BusinessOrder implements Serializable{

    private String orderId;//订单编号
    private String ncOrderId;//NC外销合同号
    private String businessId;//商机编号
    private String customerId;//客户编号
    private String customerDutyParagraph;//客户税号
    private String billToCustomer;//收票客户
    private String salesManId;//业务员id
    private String salesManName;//业务员姓名
    @NotBlank
    private String departmentId;//部门id
    private String departmentName;//部门名称

    @NotBlank
    private String saleOrganizationId;//销售组织id
    private String saleOrganizationName;//销售组织名称
    private String destinationPort;//目的港code
    private String shipmentPort;//起运港code
    private String destinationPortName;//目的港
    private String shipmentPortName;//起运港
    @NotBlank
    private String collectionAgreement;//收款协议
    @NotNull
    private Integer tradeType;//贸易方式 0一般贸易，1其他
    @NotBlank
    private String tradeTerm;//贸易术语
    @NotBlank
    private String currency;//币种编码
    @NotBlank
    private String tradeCountry;//贸易国别code
    private String tradeCountryName;//贸易国别
    @NotNull
    private Integer isCreditRisk;//是否使用信用险

    @NotNull
    private BigDecimal prepayRate;//预付款比例
    @NotNull
    private BigDecimal nusdexchgrate;//原币对美元汇率
    @NotNull
    private BigDecimal nexchangerate;//原币对本币汇率
    private Date lastdelydate;//最迟交货期
    @NotNull
    private BigDecimal premiumRate;//保险费率
    private BigDecimal  guaranteeRate;//信保费率
    @NotNull
    private BigDecimal discountRate;//资金利率
    @NotNull
    private BigDecimal lossRate;//汇损费率
    private BigDecimal saleRate;//销售费用率
    private BigDecimal managementRate;//管理费用率
    private BigDecimal grossRate;//毛利率
    private BigDecimal creditRate;//信保赔付率
    private Integer transportFlag;//是否可转运,0否，1是
    private Integer partialShipmentFalg;//是否可分批出运
    private Integer status;//订单状态：-1：报价失败  0：报价中 1：已转化成订单 2：数据已上报到NC

    private String failureAnalysis;//失败原因分析

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dealTime;//nc系统合同签订时间
    private String deliverInfo;//交单地址等信息 json格式
    private String expressInfo;//寄件信息 json格式
    private String dueTime;//应付款时间
    private BigDecimal amountPayable;//应付款金额
    private BigDecimal floorPrice;//最低销售价
    private BigDecimal maintenanceFee;//维护费
    private BigDecimal netProfit;//净利润
    private String actualPaymentTime;//实际付款时间

    private BigDecimal grossProfit;//毛利润

    private BigDecimal actualAmountPaid;//实际付款金额
    private BigDecimal unpaidAmount;//未付金额
    private Integer isComplaint;//是否投诉 0:否 1：是
    private Integer isPledge;//是否质押 0:否 1：是
    private Integer isModifyPrice;//'是否调价0:否 1：是
    private BigDecimal claimAmount;//索赔金额
    private Integer createUserId;//'创建者id
    private String createUserName;//创建者姓名
    private Integer lastmodifyUserId;//上一次修改者id
    private String lastmodifyUserName;//上一次修改者姓名
    private String createTime;//创建时间
    private String modifyTime;//创建时间
    private String exchangeTermsDetail;//收汇条款明细
    private String latestDeliveryTime;//最迟交货时间
    private String merchandiser;//跟单员pk
    private String merchandiserName;//跟单员name

    public String getMerchandiser() {
        return merchandiser;
    }

    public void setMerchandiser(String merchandiser) {
        this.merchandiser = merchandiser;
    }

    public String getMerchandiserName() {
        return merchandiserName;
    }

    public void setMerchandiserName(String merchandiserName) {
        this.merchandiserName = merchandiserName;
    }

    public String getExchangeTermsDetail() {
        return exchangeTermsDetail;
    }

    public void setExchangeTermsDetail(String exchangeTermsDetail) {
        this.exchangeTermsDetail = exchangeTermsDetail;
    }

    public String getLatestDeliveryTime() {
        return latestDeliveryTime;
    }

    public void setLatestDeliveryTime(String latestDeliveryTime) {
        this.latestDeliveryTime = latestDeliveryTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getNcOrderId() {
        return ncOrderId;
    }

    public void setNcOrderId(String ncOrderId) {
        this.ncOrderId = ncOrderId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerDutyParagraph() {
        return customerDutyParagraph;
    }

    public void setCustomerDutyParagraph(String customerDutyParagraph) {
        this.customerDutyParagraph = customerDutyParagraph;
    }

    public String getBillToCustomer() {
        return billToCustomer;
    }

    public void setBillToCustomer(String billToCustomer) {
        this.billToCustomer = billToCustomer;
    }

    public String getSalesManId() {
        return salesManId;
    }

    public void setSalesManId(String salesManId) {
        this.salesManId = salesManId;
    }

    public String getSalesManName() {
        return salesManName;
    }

    public void setSalesManName(String salesManName) {
        this.salesManName = salesManName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSaleOrganizationId() {
        return saleOrganizationId;
    }

    public void setSaleOrganizationId(String saleOrganizationId) {
        this.saleOrganizationId = saleOrganizationId;
    }

    public String getSaleOrganizationName() {
        return saleOrganizationName;
    }

    public void setSaleOrganizationName(String saleOrganizationName) {
        this.saleOrganizationName = saleOrganizationName;
    }

    public String getDestinationPortName() {
        return destinationPortName;
    }

    public void setDestinationPortName(String destinationPortName) {
        this.destinationPortName = destinationPortName;
    }

    public String getShipmentPortName() {
        return shipmentPortName;
    }

    public void setShipmentPortName(String shipmentPortName) {
        this.shipmentPortName = shipmentPortName;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public String getShipmentPort() {
        return shipmentPort;
    }

    public void setShipmentPort(String shipmentPort) {
        this.shipmentPort = shipmentPort;
    }

    public String getCollectionAgreement() {
        return collectionAgreement;
    }

    public void setCollectionAgreement(String collectionAgreement) {
        this.collectionAgreement = collectionAgreement;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeTerm() {
        return tradeTerm;
    }

    public void setTradeTerm(String tradeTerm) {
        this.tradeTerm = tradeTerm;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTradeCountry() {
        return tradeCountry;
    }

    public void setTradeCountry(String tradeCountry) {
        this.tradeCountry = tradeCountry;
    }

    public Integer getIsCreditRisk() {
        return isCreditRisk;
    }

    public void setIsCreditRisk(Integer isCreditRisk) {
        this.isCreditRisk = isCreditRisk;
    }

    public BigDecimal getPrepayRate() {
        return prepayRate;
    }

    public void setPrepayRate(BigDecimal prepayRate) {
        this.prepayRate = prepayRate;
    }

    public BigDecimal getNusdexchgrate() {
        return nusdexchgrate;
    }

    public void setNusdexchgrate(BigDecimal nusdexchgrate) {
        this.nusdexchgrate = nusdexchgrate;
    }

    public BigDecimal getNexchangerate() {
        return nexchangerate;
    }

    public void setNexchangerate(BigDecimal nexchangerate) {
        this.nexchangerate = nexchangerate;
    }

    public Date getLastdelydate() {
        return lastdelydate;
    }

    public void setLastdelydate(Date lastdelydate) {
        this.lastdelydate = lastdelydate;
    }

    public BigDecimal getPremiumRate() {
        return premiumRate;
    }

    public void setPremiumRate(BigDecimal premiumRate) {
        this.premiumRate = premiumRate;
    }

    public BigDecimal getGuaranteeRate() {
        return guaranteeRate;
    }

    public void setGuaranteeRate(BigDecimal guaranteeRate) {
        this.guaranteeRate = guaranteeRate;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public BigDecimal getLossRate() {
        return lossRate;
    }

    public void setLossRate(BigDecimal lossRate) {
        this.lossRate = lossRate;
    }

    public BigDecimal getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(BigDecimal saleRate) {
        this.saleRate = saleRate;
    }

    public BigDecimal getManagementRate() {
        return managementRate;
    }

    public void setManagementRate(BigDecimal managementRate) {
        this.managementRate = managementRate;
    }

    public BigDecimal getGrossRate() {
        return grossRate;
    }

    public void setGrossRate(BigDecimal grossRate) {
        this.grossRate = grossRate;
    }

    public BigDecimal getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(BigDecimal creditRate) {
        this.creditRate = creditRate;
    }

    public Integer getTransportFlag() {
        return transportFlag;
    }

    public void setTransportFlag(Integer transportFlag) {
        this.transportFlag = transportFlag;
    }

    public Integer getPartialShipmentFalg() {
        return partialShipmentFalg;
    }

    public void setPartialShipmentFalg(Integer partialShipmentFalg) {
        this.partialShipmentFalg = partialShipmentFalg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFailureAnalysis() {
        return failureAnalysis;
    }

    public void setFailureAnalysis(String failureAnalysis) {
        this.failureAnalysis = failureAnalysis;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getDeliverInfo() {
        return deliverInfo;
    }

    public void setDeliverInfo(String deliverInfo) {
        this.deliverInfo = deliverInfo;
    }

    public String getExpressInfo() {
        return expressInfo;
    }

    public void setExpressInfo(String expressInfo) {
        this.expressInfo = expressInfo;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }

    public BigDecimal getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(BigDecimal amountPayable) {
        this.amountPayable = amountPayable;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    public BigDecimal getMaintenanceFee() {
        return maintenanceFee;
    }

    public void setMaintenanceFee(BigDecimal maintenanceFee) {
        this.maintenanceFee = maintenanceFee;
    }

    public BigDecimal getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }

    public String getActualPaymentTime() {
        return actualPaymentTime;
    }

    public void setActualPaymentTime(String actualPaymentTime) {
        this.actualPaymentTime = actualPaymentTime;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    public BigDecimal getActualAmountPaid() {
        return actualAmountPaid;
    }

    public void setActualAmountPaid(BigDecimal actualAmountPaid) {
        this.actualAmountPaid = actualAmountPaid;
    }

    public BigDecimal getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(BigDecimal unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    public Integer getIsComplaint() {
        return isComplaint;
    }

    public void setIsComplaint(Integer isComplaint) {
        this.isComplaint = isComplaint;
    }

    public Integer getIsPledge() {
        return isPledge;
    }

    public void setIsPledge(Integer isPledge) {
        this.isPledge = isPledge;
    }

    public Integer getIsModifyPrice() {
        return isModifyPrice;
    }

    public void setIsModifyPrice(Integer isModifyPrice) {
        this.isModifyPrice = isModifyPrice;
    }

    public BigDecimal getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(BigDecimal claimAmount) {
        this.claimAmount = claimAmount;
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

    public String getTradeCountryName() {
        return tradeCountryName;
    }

    public void setTradeCountryName(String tradeCountryName) {
        this.tradeCountryName = tradeCountryName;
    }
}
