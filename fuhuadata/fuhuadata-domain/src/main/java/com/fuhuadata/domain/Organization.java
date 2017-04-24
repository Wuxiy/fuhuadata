package com.fuhuadata.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Created：2017-03-21
 * @Author hexingfu
 * @Version:1.0
 * @Description:POrganization
*/
public class Organization implements Serializable {
        
        private Integer orgId;
    
        private String parentId;//父级ncid
    
        private String name;
    
        private String ncId;

        private String code;

        private String pcode;//父级code
    
        private Integer isSaleRole;
    
        private String createTime;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

    public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNcId() {
        return ncId;
    }
    public void setNcId(String ncId) {
        this.ncId = ncId;
    }
    public Integer getIsSaleRole() {
        return isSaleRole;
    }
    public void setIsSaleRole(Integer isSaleRole) {
        this.isSaleRole = isSaleRole;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
