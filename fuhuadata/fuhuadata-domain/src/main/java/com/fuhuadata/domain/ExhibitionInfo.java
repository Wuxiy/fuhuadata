package com.fuhuadata.domain;

import com.fuhuadata.util.DateJsonDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.Date;


/**
 * 展会动态
 * Created by intanswer on 2017/1/13.
 */
@SuppressWarnings("serial")
public class ExhibitionInfo{
    private Integer exhibitionId;//展会id

    private String exhibitionName;

    private String sponsor;//主办方

    private String organizer;//承办单位

    private String region;//所属区域

    private String country;

    private String city;

    private Date startDate;

    private Date finishDate;

    private String exhibitionAddr;

    private String exhibitionLink;

    private String creator;

    private Date createTime;

    private String exhibitionInfo;//展会介绍

    public Integer getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(Integer exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public void setExhibitionName(String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getStartDate() {
        return startDate;
    }

    @JsonDeserialize(using=DateJsonDeserializer.class)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    @JsonDeserialize(using=DateJsonDeserializer.class)
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getExhibitionAddr() {
        return exhibitionAddr;
    }

    public void setExhibitionAddr(String exhibitionAddr) {
        this.exhibitionAddr = exhibitionAddr;
    }

    public String getExhibitionLink() {
        return exhibitionLink;
    }

    public void setExhibitionLink(String exhibitionLink) {
        this.exhibitionLink = exhibitionLink;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @JsonDeserialize(using=DateJsonDeserializer.class)
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExhibitionInfo() {
        return exhibitionInfo;
    }

    public void setExhibitionInfo(String exhibitionInfo) {
        this.exhibitionInfo = exhibitionInfo;
    }
}
