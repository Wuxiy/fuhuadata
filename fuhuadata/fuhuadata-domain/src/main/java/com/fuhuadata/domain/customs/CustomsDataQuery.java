package com.fuhuadata.domain.customs;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/27/2017
 */
public class CustomsDataQuery {

    private LocalDate startDate;

    private LocalDate endDate;

    private List<Integer> destCountryIds;

    private String statType;

    private String categoryType;

    private Integer categoryId;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Integer> getDestCountryIds() {
        return destCountryIds;
    }

    public void setDestCountryIds(List<Integer> destCountryIds) {
        this.destCountryIds = destCountryIds;
    }

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
