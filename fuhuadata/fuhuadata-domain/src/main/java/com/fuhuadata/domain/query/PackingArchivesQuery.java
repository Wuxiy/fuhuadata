package com.fuhuadata.domain.query;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by intanswer on 2017/1/23.
 */
public class PackingArchivesQuery extends PageBase{
    private Integer packingId;

    private Integer bigCategoryId;//：内包材，外包材，辅材

    private Integer smallCategoryId;//:主材-平桶类

    private String packName;//包材名称

    private String size;//尺寸 格式：150*150*150

    private String spec;//规格

    private String specUnit;//规格单位 （纸箱-瓶/箱，袋/箱）（瓶桶-L,KG）

    private String quality;//材质

    private String qualityIndex;//质量指标

    private String qualityTargetValue;//质量指标数值

    private BigDecimal unitPrice;//单价

    private BigDecimal consumption;//单耗

    private Date priceEndDate;//价格有效期  yyyy/mm/dd

    private String suitableType;//适用剂型（原药，水剂，颗粒剂）

    private String bRemarks;//备注

    private Integer status;//状态 0:已禁用 1:已启用

    private String associatedPackingId;//关联包材（主材会有关联外包装和辅材）

    private String imagePath;//图片路径


    public Integer getPackingId() {
        return packingId;
    }

    public void setPackingId(Integer packingId) {
        this.packingId = packingId;
    }



    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSpecUnit() {
        return specUnit;
    }

    public void setSpecUnit(String specUnit) {
        this.specUnit = specUnit;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getQualityIndex() {
        return qualityIndex;
    }

    public void setQualityIndex(String qualityIndex) {
        this.qualityIndex = qualityIndex;
    }

    public String getQualityTargetValue() {
        return qualityTargetValue;
    }

    public void setQualityTargetValue(String qualityTargetValue) {
        this.qualityTargetValue = qualityTargetValue;
    }

    public Date getPriceEndDate() {
        return priceEndDate;
    }

    public void setPriceEndDate(Date priceEndDate) {
        this.priceEndDate = priceEndDate;
    }

    public String getSuitableType() {
        return suitableType;
    }

    public void setSuitableType(String suitableType) {
        this.suitableType = suitableType;
    }

    public String getbRemarks() {
        return bRemarks;
    }

    public void setbRemarks(String bRemarks) {
        this.bRemarks = bRemarks;
    }

    public String getAssociatedPackingId() {
        return associatedPackingId;
    }

    public void setAssociatedPackingId(String associatedPackingId) {
        this.associatedPackingId = associatedPackingId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }

    public Integer getBigCategoryId() {
        return bigCategoryId;
    }

    public void setBigCategoryId(Integer bigCategoryId) {
        this.bigCategoryId = bigCategoryId;
    }

    public Integer getSmallCategoryId() {
        return smallCategoryId;
    }

    public void setSmallCategoryId(Integer smallCategoryId) {
        this.smallCategoryId = smallCategoryId;
    }
}
