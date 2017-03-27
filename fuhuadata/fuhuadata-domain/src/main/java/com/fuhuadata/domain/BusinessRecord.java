package com.fuhuadata.domain;

import java.util.Date;

/**
 * 商机跟进
 * Created by intanswer on 2017/3/24.
 */
public class BusinessRecord {
    private Integer id;

    private String businessId;//商机id

    private String followContent;//跟进内容

    private String followEffect;//跟进效果

    private Integer businessProcess;//商机阶段,0信息搜集，1线索跟进，2需求挖掘

    private Integer createUserId;

    private String createUserName;

    private Integer lastmodifyUserId;

    private String lastmodifyUserName;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getFollowContent() {
        return followContent;
    }

    public void setFollowContent(String followContent) {
        this.followContent = followContent;
    }

    public String getFollowEffect() {
        return followEffect;
    }

    public void setFollowEffect(String followEffect) {
        this.followEffect = followEffect;
    }

    public Integer getBusinessProcess() {
        return businessProcess;
    }

    public void setBusinessProcess(Integer businessProcess) {
        this.businessProcess = businessProcess;
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
