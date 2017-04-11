package com.fuhuadata.vo.Price;

import java.math.BigDecimal;
import java.util.List;

/**
 * 自产类价格明细
 * Created by hexingfu on 2017/4/11.
 */
public class SelfProductionVO extends Price{
    //原币汇率
    private BigDecimal currencyExchangeRate;

    public BigDecimal getCurrencyExchangeRate() {
        return currencyExchangeRate;
    }

    public void setCurrencyExchangeRate(BigDecimal currencyExchangeRate) {
        this.currencyExchangeRate = currencyExchangeRate;
    }
}
