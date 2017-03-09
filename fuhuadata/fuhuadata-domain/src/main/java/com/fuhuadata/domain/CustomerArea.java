package com.fuhuadata.domain;

import java.io.Serializable;

/**
 * 客户地区目录dao实体
 * Created by hexingfu on 2017/3/9.
 */
public class CustomerArea implements Serializable{

    /**区域id**/
    private String areaId;
    /**区域名称**/
    private String areaName;
    /**大区id**/
    private String areaClassId;
    /**大域名称**/
    private String areaClassName;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaClassId() {
        return areaClassId;
    }

    public void setAreaClassId(String areaClassId) {
        this.areaClassId = areaClassId;
    }

    public String getAreaClassName() {
        return areaClassName;
    }

    public void setAreaClassName(String areaClassName) {
        this.areaClassName = areaClassName;
    }
}
