package com.fuhuadata.vo.Price;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hexingfu on 2017/4/10.
 */
public class Price implements Serializable{
    //总单价
    private BigDecimal total;
    //总单价明细
    private Detail detail;
    //价格计算类型,0自产类，1原药制剂自产类加工，2原药采购制剂加工，3贸易类，4其他
    private int type;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
