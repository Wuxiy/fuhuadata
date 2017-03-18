package com.fuhuadata.domain.query;

import java.io.Serializable;

/**
 * Created by hexingfu on 2017/3/17.
 */
public class QueryOrder implements Serializable{

    private String departmentId;//部门id
    private String ncOrderId;//NC系统外销合同号
    private String startTime;//合同签订时间开始范围
    private String endTime;//合同签订时间结束范围

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getNcOrderId() {
        return ncOrderId;
    }

    public void setNcOrderId(String ncOrderId) {
        this.ncOrderId = ncOrderId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
