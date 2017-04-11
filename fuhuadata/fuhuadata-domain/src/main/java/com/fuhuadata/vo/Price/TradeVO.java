package com.fuhuadata.vo.Price;

import java.math.BigDecimal;

/**
 * 贸易类价格明细
 * Created by hexingfu on 2017/4/11.
 */
public class TradeVO extends Price{
    //原币汇率
    private BigDecimal currencyExchangeRate;
    //出口退税率
    private BigDecimal exportRebateRate;

    public BigDecimal getCurrencyExchangeRate() {
        return currencyExchangeRate;
    }

    public void setCurrencyExchangeRate(BigDecimal currencyExchangeRate) {
        this.currencyExchangeRate = currencyExchangeRate;
    }

    public BigDecimal getExportRebateRate() {
        return exportRebateRate;
    }

    public void setExportRebateRate(BigDecimal exportRebateRate) {
        this.exportRebateRate = exportRebateRate;
    }
}
