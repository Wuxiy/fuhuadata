package com.fuhuadata.domain;

/**
 * 港杂费成本
 * Created by intanswer on 2017/1/17.
 */
public class PortChargesCost {
    private Integer portId;
    private String item;//项目

    private String generalChemicals;//一般化工品

    private String dangerousProduct;//危险品

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getGeneralChemicals() {
        return generalChemicals;
    }

    public void setGeneralChemicals(String generalChemicals) {
        this.generalChemicals = generalChemicals;
    }

    public String getDangerousProduct() {
        return dangerousProduct;
    }

    public void setDangerousProduct(String dangerousProduct) {
        this.dangerousProduct = dangerousProduct;
    }

    public Integer getPortId() {
        return portId;
    }

    public void setPortId(Integer portId) {
        this.portId = portId;
    }
}
