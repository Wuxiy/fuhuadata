package com.fuhuadata.vo;

/**
 * 理化指标
 * Created by intanswer on 2017/3/7.
 */
public class PhysicalProperities {
    private String index;//指标
    private String value;//值
    private String remarks;//备注

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
