package com.fuhuadata.domain.query;

import com.fuhuadata.domain.query.PageBase;

import java.sql.Date;

/**
 * 客户百科信息
 * Created by intanswer on 2017/1/13.
 */
public class CustomerEncyclopediaQuery extends PageBase {
    private Integer encyId;//百科编号

    private String companyName;//企业全称

    private String type;//企业类型

    private String isFull;//完整度

    private String area;//所属片区

    private String country;//国家

    private String companyProperty;//企业性质

    private Integer registFund;//注册资金

    private String registAddr;//注册地址

    private String businessScope;//经营范围

    private Integer createUserId;//创建人id

    private String createUserName;//创建人姓名

    private Date createTime;//创建时间

    private Integer lastmodifyUserId;//最后编辑人id

    private String lastmodifyUserName;//最后编辑人姓名

    private Date modifyTime;//最后编辑时间

    private String remarks;//备注

    private String searchKey;//


    public Integer getEncyId() {
        return encyId;
    }

    public void setEncyId(Integer encyId) {
        this.encyId = encyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsFull() {
        return isFull;
    }

    public void setIsFull(String isFull) {
        this.isFull = isFull;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(String companyProperty) {
        this.companyProperty = companyProperty;
    }

    public Integer getRegistFund() {
        return registFund;
    }

    public void setRegistFund(Integer registFund) {
        this.registFund = registFund;
    }

    public String getRegistAddr() {
        return registAddr;
    }

    public void setRegistAddr(String registAddr) {
        this.registAddr = registAddr;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
