package com.fuhuadata.domain.query;

import com.fuhuadata.domain.query.PageBase;

import java.sql.Date;
/**
 * 费率
 * Created by young on 2017/2/9.
 */
public class RateQuery extends PageBase{

    private Integer rateId;

    private Integer type;//币种、毛利率、其他费率类型

    private String kind;//种类类型（table第一列）

    private String rate;//费率（table第二列）

    private Date termofValidity;//有效期

    private String remarks;//备注

    private String searchKey;

    public Integer getRateId(){
        return rateId;
    }

    public void setRateId(Integer rateId){
        this.rateId = rateId;
    }

    public Integer getType(){
        return type;
    }

    public void setType(Integer type){
        this.type = type;
    }

    public String getKind(){
        return kind;
    }

    public void setKind(String kind){
        this.kind = kind;
    }

    public String getRate(){
        return rate;
    }

    public void setRate(String rate){
        this.rate = rate;
    }

    public Date getTermofvalidity(){
        return termofValidity;
    }

    public void setTermofvalidity(Date termofValidity){
        this.termofValidity = termofValidity;
    }

    public String getRemarks(){
        return remarks;
    }

    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

}
