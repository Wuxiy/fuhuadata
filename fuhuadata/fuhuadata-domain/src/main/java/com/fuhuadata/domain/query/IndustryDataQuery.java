package com.fuhuadata.domain.query;

/**
 * 行业数据
 * Created by intanswer on 2017/1/19.
 */
public class IndustryDataQuery {
    private Integer id;

    private String year;//年份

    private String businessName;//经营单位名称

    private String exportContinent;//出口洲

    private Integer exportGross;//出口总量

    private Integer saleTotal;//销售总量

    private String exportCountry;//出口国

    private Float average;//均价

    private String month;//月份

    private String exportShare;//出口份额

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getExportContinent() {
        return exportContinent;
    }

    public void setExportContinent(String exportContinent) {
        this.exportContinent = exportContinent;
    }

    public Integer getExportGross() {
        return exportGross;
    }

    public void setExportGross(Integer exportGross) {
        this.exportGross = exportGross;
    }

    public Integer getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(Integer saleTotal) {
        this.saleTotal = saleTotal;
    }

    public String getExportCountry() {
        return exportCountry;
    }

    public void setExportCountry(String exportCountry) {
        this.exportCountry = exportCountry ;
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getExportShare() {
        return exportShare;
    }

    public void setExportShare(String exportShare) {
        this.exportShare = exportShare;
    }
}
