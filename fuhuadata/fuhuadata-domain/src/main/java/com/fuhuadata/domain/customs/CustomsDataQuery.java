package com.fuhuadata.domain.customs;

import com.alibaba.fastjson.JSON;
import com.fuhuadata.domain.validation.groups.GroupOne;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * GroupOne:柱状图必须有按年份 or 按月份
 * <p>User: wangjie
 * <p>Date: 6/27/2017
 */
public class CustomsDataQuery {

    @NotNull(groups = GroupOne.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @NotNull(groups = GroupOne.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    /**
     * 出口国家、出口企业ids
     */
    @NotNull(groups = GroupOne.class)
    private List<Integer> statIds;

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
     * year=按年份，month=按月份
     */
    @NotNull(groups = GroupOne.class)
    private String timeType;

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

    public List<Integer> getStatIds() {
        return statIds;
    }

    public void setStatIds(List<Integer> statIds) {
        this.statIds = statIds;
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

    public StatCategory getStatCategory() {
        return statCategory;
    }

    public void setStatCategory(StatCategory statCategory) {
        this.statCategory = statCategory;
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

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }
}
