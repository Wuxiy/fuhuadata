package com.fuhuadata.domain.query;

import com.fuhuadata.domain.query.PageBase;

/**
 * 运费成本query
 * Created by intanswer on 2017/1/17.
 */
public class FreightCostQuery extends PageBase {

    private Integer freightId;

    private String processFactory;//加工产

    private String unitCost;//单价

    private String departureCity;//起运城市

    private String destinationCity;//目的城市

    private String remarks;//备注

    private String searchKey;

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public String getProcessFactory() {
        return processFactory;
    }

    public void setProcessFactory(String processFactory) {
        this.processFactory = processFactory;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity ;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
