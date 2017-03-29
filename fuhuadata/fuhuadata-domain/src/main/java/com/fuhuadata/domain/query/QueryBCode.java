package com.fuhuadata.domain.query;

import java.util.Date;

/**
 * 业务流水编码，基础档案编码
 */
public class QueryBCode {
    private Integer id;

    private Integer cType;

    private Integer needReset;

    private String cDate;

    private Integer currentVal;

    private Date lastModifyTime;

    public QueryBCode(Integer cType,String cDate){
        this.cType = cType;
        this.cDate = cDate;
    }

    public Integer getId() {
        return id;
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public Integer getNeedReset() {
        return needReset;
    }

    public void setNeedReset(Integer needReset) {
        this.needReset = needReset;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public Integer getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(Integer currentVal) {
        this.currentVal = currentVal;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}