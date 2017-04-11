package com.fuhuadata.vo.Price;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hexingfu on 2017/4/11.
 */
public class Price implements Serializable {

    //价格
    protected BigDecimal price;
    //价格明细列表
    protected List<PriceDetail> detailList;
    //折合原币价格
    protected BigDecimal convertedCurrency;
    //信保赔付率
    private BigDecimal trustPaymentRatio;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<PriceDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<PriceDetail> detailList) {
        this.detailList = detailList;
    }

    public BigDecimal getConvertedCurrency() {
        return convertedCurrency;
    }

    public void setConvertedCurrency(BigDecimal convertedCurrency) {
        this.convertedCurrency = convertedCurrency;
    }

    public BigDecimal getTrustPaymentRatio() {
        return trustPaymentRatio;
    }

    public void setTrustPaymentRatio(BigDecimal trustPaymentRatio) {
        this.trustPaymentRatio = trustPaymentRatio;
    }
}
