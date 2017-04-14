package com.fuhuadata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 客户百科信息
 * Created by intanswer on 2017/1/13.
 */
public class CustomerEncyclopedia {

        private String encyId;//百科编号

        private String customerId;//企业id

        /**客户基本信息**/

        private String fullName;

        private String shortName;

        private Integer companyType;//企业类别 0：客户，1：竞对

        private String customerAreaId;

        private String customerArea;

        private Integer customerLevel;

        private String enterpriseNature;

        private String country;


        private String companyInfo;//企业简介

        private String isFull;//完整度

        private String developHis;//企业发展历程

        private String sellNetwork;//销售网络

        private String customField;//自定义信息json串

        private Integer createUserId;//创建人id

        private String createUserName;//创建人姓名

         @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date createTime;//创建时间

        private Integer lastmodifyUserId;//最后编辑人id

        private String lastmodifyUserName;//最后编辑人姓名

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date modifyTime;//最后编辑时间

        private String remarks;//备注


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getCustomerAreaId() {
        return customerAreaId;
    }

    public void setCustomerAreaId(String customerAreaId) {
        this.customerAreaId = customerAreaId;
    }

    public String getCustomerArea() {
        return customerArea;
    }

    public void setCustomerArea(String customerArea) {
        this.customerArea = customerArea;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
            this.createUserName = createUserName ;
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
            this.lastmodifyUserName = lastmodifyUserName ;
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
            this.remarks = remarks ;
        }

    public String getSellNetwork() {
        return sellNetwork;
    }

    public void setSellNetwork(String sellNetwork) {
        this.sellNetwork = sellNetwork;
    }

    public String getDevelopHis() {
        return developHis;
    }

    public void setDevelopHis(String developHis) {
        this.developHis = developHis;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getEncyId() {
        return encyId;
    }

    public void setEncyId(String encyId) {
        this.encyId = encyId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public String getIsFull() {
        return isFull;
    }

    public void setIsFull(String isFull) {
        this.isFull = isFull;
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField;
    }
}
