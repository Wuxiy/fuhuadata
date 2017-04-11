package com.fuhuadata.vo.Price;

import java.math.BigDecimal;

/**
 * 原药采购加工类价格明细
 * Created by hexingfu on 2017/4/11.
 */
public class ProcurementProcessingVO extends Price{

    //美元汇率
    private BigDecimal dollarCurrencyRate;
    //出口退税率
    private BigDecimal exportRebateRate;

    public BigDecimal getDollarCurrencyRate() {
        return dollarCurrencyRate;
    }

    public void setDollarCurrencyRate(BigDecimal dollarCurrencyRate) {
        this.dollarCurrencyRate = dollarCurrencyRate;
    }

    public BigDecimal getExportRebateRate() {
        return exportRebateRate;
    }

    public void setExportRebateRate(BigDecimal exportRebateRate) {
        this.exportRebateRate = exportRebateRate;
    }
}

