package com.fuhuadata.domain;

import com.fuhuadata.util.DateJsonDeserializer;
import com.fuhuadata.util.DateJsonSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * 客户百科信息
 * Created by intanswer on 2017/1/13.
 */
public class CustomerEncyclopedia {

        private String encyId;//百科编号

        private String customerId;//企业id

        private String companyInfo;//企业简介

        private String isFull;//完整度

        private String developHis;//企业发展历程

        private String sellNetwork;//销售网络

        private String customField;//自定义信息json串

        private Integer createUserId;//创建人id

        private String createUserName;//创建人姓名

        private Date createTime;//创建时间

        private Integer lastmodifyUserId;//最后编辑人id

        private String lastmodifyUserName;//最后编辑人姓名

        private Date modifyTime;//最后编辑时间

        private String remarks;//备注



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

        @JsonSerialize(using = DateJsonSerializer.class)
        public Date getCreateTime() {
            return createTime;
        }

        @JsonDeserialize(using = DateJsonDeserializer.class)
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

        @JsonSerialize(using = DateJsonSerializer.class)
        public Date getModifyTime() {
            return modifyTime;
        }

        @JsonDeserialize(using = DateJsonDeserializer.class)
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
}
