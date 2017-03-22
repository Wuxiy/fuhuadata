package com.fuhuadata.vo;

import com.fuhuadata.util.DateJsonDeserializer;
import com.fuhuadata.util.DateJsonSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 沟通记录
 * Created by intanswer on 2017/3/21.
 */
public class VisitRecordVO {
    private Integer visitRecordId;
    private String linkmanId;//联系人id
    private String name;//拜访对象
    private BigDecimal activityExpens;//活动费用
    private String activityGift;//活动礼物
    private Date  startTime;//开始时间
    private Date endTime;//结束时间
    private Integer activityType;//活动类型：0远程沟通，1出差拜访，2展会邀请，3工厂参观，4商务宴请，5其他（备注内容）
    private String activityAddress;//活动地址
    private String activitySummary;//活动摘要

    public String getLinkmanId() {
        return linkmanId;
    }

    public void setLinkmanId(String linkmanId) {
        this.linkmanId = linkmanId;
    }


    public String getActivityGift() {
        return activityGift;
    }

    public void setActivityGift(String activityGift) {
        this.activityGift = activityGift;
    }

    @JsonSerialize(using = DateJsonSerializer.class)
    public Date getStartTime() {
        return startTime;
    }

    @JsonDeserialize(using = DateJsonDeserializer.class)
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @JsonSerialize(using = DateJsonSerializer.class)
    public Date getEndTime() {
        return endTime;
    }


    @JsonDeserialize(using = DateJsonDeserializer.class)
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    public String getActivitySummary() {
        return activitySummary;
    }

    public void setActivitySummary(String activitySummary) {
        this.activitySummary = activitySummary;
    }

    public BigDecimal getActivityExpens() {
        return activityExpens;
    }

    public void setActivityExpens(BigDecimal activityExpens) {
        this.activityExpens = activityExpens;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVisitRecordId() {
        return visitRecordId;
    }

    public void setVisitRecordId(Integer visitRecordId) {
        this.visitRecordId = visitRecordId;
    }
}
