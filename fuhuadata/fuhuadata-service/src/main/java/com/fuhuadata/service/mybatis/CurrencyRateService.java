package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.CurrencyRate;
import com.fuhuadata.domain.mybatis.Currtype;
import com.fuhuadata.domain.query.CurrencyRateQuery;
import com.fuhuadata.vo.CurrencyRateVO;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/10/2017
 */
public interface CurrencyRateService extends BaseService<CurrencyRate, Integer> {

    /**
     * 生成当天的汇率信息
     */
    void generateTodayRate();

    /**
     * 生成当天美元汇率
     *
     * @param currtype
     */
    void generateTodayUsdRate(Currtype currtype);

    /**
     * 生成当天对人民币汇率
     *
     * @param currtype
     */
    void generateTodayCnyRate(Currtype currtype);

    /**
     * 获取最新的汇率信息
     *
     * @param currencyCode   币种
     * @param toCurrencyCode 待转换的汇率
     * @return
     */
    CurrencyRate getNewestRate(String currencyCode, String toCurrencyCode);

    /**
     * 获取汇率信息
     * @param query
     * @return
     */
    List<CurrencyRateVO> listNewestUsdAndCnyRate(CurrencyRateQuery query);
}
