package com.fuhuadata.domain.query;

/**
 * @author wangbo
 * @date 2017-01-16 17:17:06
 */
public class QueryWarehouseInfo extends PageBase {
    /**
     * 关联货代id
     */
    private Integer forwardingId;

    public Integer getForwardingId() {
        return forwardingId;
    }

    public void setForwardingId(Integer forwardingId) {
        this.forwardingId = forwardingId;
    }
}