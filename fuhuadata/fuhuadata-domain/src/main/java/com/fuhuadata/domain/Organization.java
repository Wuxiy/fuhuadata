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
    
        private Integer parentId;
    
        private String name;
    
        private String ncId;
    
        private Integer isSaleRole;
    
        private String createTime;

    public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public Integer getParentId() {
        return parentId;
    }
    public void setParentId(Integer parentId) {
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
