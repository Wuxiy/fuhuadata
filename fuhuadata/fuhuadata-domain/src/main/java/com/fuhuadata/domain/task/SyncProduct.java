package com.fuhuadata.domain.task;

import java.io.Serializable;

/**
 * 同步product_info
 * Created by hexingfu on 2017/5/9.
 */
public class SyncProduct implements Serializable {
    //nc分类code
    private Integer ncCategoryId;
    //产品名称
    private String name;
    //主计量单位
    private String measurement;

    public Integer getNcCategoryId() {
        return ncCategoryId;
    }

    public void setNcCategoryId(Integer ncCategoryId) {
        this.ncCategoryId = ncCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
}
