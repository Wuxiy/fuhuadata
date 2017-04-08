package com.fuhuadata.domain.query;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by intanswer on 2017/3/24.
 */
public class QueryBusinessInfo {

    private int startRow;
    private int pageSize;

    /**地区id**/
    private String areaId;
    /**大区分类id**/
    private String areaClassId;

    private String  businessId;
    private String businessName;

    private String customerId;
    private String customerName;

    /**1:战略客户,2:大客户 3:重要客户 4:一般客户 5:风险客户**/
    private Integer customerLevel;

    /**企业性质 1：工厂 2：分销商 3：经销商 4：终端客户 5：其他**/
    private String enterpriseNature;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private Integer remainDays;//剩余时间

    /**商机来源，0展会，1门户网站，2农药店考察，3客户介绍，4主动联系，5其他**/
    private Integer businessFrom;

    private BigDecimal  expectIncome;//预计收益

    /**商机状态（0:待报价，1：失败，2：已转化）**/
    private Integer businessState;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }

    public String getEnterpriseNature() {
        return enterpriseNature;
    }

    public void setEnterpriseNature(String enterpriseNature) {
        this.enterpriseNature = enterpriseNature;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRemainDays() {
        return remainDays;
    }

    public void setRemainDays(Integer remainDays) {
        this.remainDays = remainDays;
    }

    public Integer getBusinessFrom() {
        return businessFrom;
    }

    public void setBusinessFrom(Integer businessFrom) {
        this.businessFrom = businessFrom;
    }

    public BigDecimal getExpectIncome() {
        return expectIncome;
    }

    public void setExpectIncome(BigDecimal expectIncome) {
        this.expectIncome = expectIncome;
    }

    public Integer getBusinessState() {
        return businessState;
    }

    public void setBusinessState(Integer businessState) {
        this.businessState = businessState;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaClassId() {
        return areaClassId;
    }

    public void setAreaClassId(String areaClassId) {
        this.areaClassId = areaClassId;
    }
}
