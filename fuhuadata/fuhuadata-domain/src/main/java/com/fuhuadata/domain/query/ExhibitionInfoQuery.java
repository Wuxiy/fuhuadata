package com.fuhuadata.domain.query;


/**
 * 展会动态信息
 * Created by intanswer on 2017/1/13.
 */
public class ExhibitionInfoQuery{

    private int startRow;
    private int pageSize;
    private Integer exhibitionId;//展会id

    private String exhibitionName;//展会名称

    private String sponsor;//主办方

    private String organizer;//承办单位

    private String region;//所属区域


    private String exhibitionInfo;//展会介绍

    private String searchKey;//查询

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


    public String getExhibitionInfo() {
        return exhibitionInfo;
    }

    public void setExhibitionInfo(String exhibitionInfo) {
        this.exhibitionInfo = exhibitionInfo;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
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
}
