package com.fuhuadata.domain.query;

import com.fuhuadata.domain.query.PageBase;

/**
 * 港杂费成本
 * Created by intanswer on 2017/1/17.
 */
public class PortChargesCostQuery extends PageBase {

    private Integer id;

    private String item;//项目

    private String generalChemicals;//一般化工品

    private String dangerousProduct;//危险品

    private String searchKey;
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

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
