package com.fuhuadata.domain.customs;

import com.alibaba.fastjson.JSON;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 6/27/2017
 */
public class CustomsDataQuery {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    private List<Integer> destCountryIds;

    /**
     * 美元总价、美元单价、法定数量
     */
    @NotBlank
    private String statType;

    /**
     * 类型或产品
     */
    @NotBlank
    private String categoryType;

    @NotNull
    private Integer categoryId;

    /**
     * 出口国家、出口企业
     */
    private StatCategory statCategory;

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

    public static void main(String[] args) {

        CustomsDataQuery query = new CustomsDataQuery();
        query.setStartDate(LocalDate.of(2015, Month.JANUARY, 1));
        query.setEndDate(LocalDate.of(2015, Month.JANUARY, 1));
        query.setStatType("dollar_total");
        query.setCategoryType("type");
        query.setCategoryId(1);

        System.out.println(JSON.toJSONString(query));
    }

    public StatCategory getStatCategory() {
        return statCategory;
    }

    public void setStatCategory(StatCategory statCategory) {
        this.statCategory = statCategory;
    }
}
