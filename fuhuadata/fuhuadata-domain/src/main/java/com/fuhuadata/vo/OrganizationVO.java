package com.fuhuadata.vo;

/**
 * <p>User: wangjie
 * <p>Date: 4/11/2017
 */
public class OrganizationVO extends BaseTreeVo<Integer> {

    private String ncId;

    @Override
    public boolean getIsParent() {
        return true;
    }

    public String getNcId() {
        return ncId;
    }

    public void setNcId(String ncId) {
        this.ncId = ncId;
    }
}
