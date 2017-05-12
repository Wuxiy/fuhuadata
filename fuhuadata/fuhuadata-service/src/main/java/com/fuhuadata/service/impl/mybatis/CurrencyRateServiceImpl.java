package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.constant.Currency;
import com.fuhuadata.domain.mybatis.CurrencyRate;
import com.fuhuadata.domain.mybatis.Currtype;
import com.fuhuadata.domain.query.CurrencyRateQuery;
import com.fuhuadata.service.mybatis.CurrencyRateService;
import com.fuhuadata.service.mybatis.CurrtypeService;
import com.fuhuadata.vo.CurrencyRateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 5/10/2017
 */
@Service("com.fuhuadata.service.impl.mybatis.CurrencyRateServiceImpl")
public class CurrencyRateServiceImpl extends BaseServiceImpl<CurrencyRate, Integer>
        implements CurrencyRateService {

    private CurrtypeService currtypeService;

    @Autowired
    public void setCurrtypeService(CurrtypeService currtypeService) {
        this.currtypeService = currtypeService;
    }

    @Override
    public void generateTodayRate() {

        List<Currtype> currencies = currtypeService.list();

        for (Currtype currtype : currencies) {
            generateTodayUsdRate(currtype);
            generateTodayCnyRate(currtype);
        }
    }

    @Override
    public void generateTodayUsdRate(Currtype currtype) {

        Currtype usdCurr = currtypeService.getByCode(Currency.USD.code);
        CurrencyRate todyRate = generateTodayRate(currtype, usdCurr);

        saveSelective(todyRate);
    }

    private CurrencyRate generateTodayRate(Currtype currtype, Currtype toCurr) {
        CurrencyRate newestRate = getNewestRate(currtype.getCode(), toCurr.getCode());

        CurrencyRate todayRate = new CurrencyRate();
        todayRate.setPkCurrtype(currtype.getPkCurrtype());
        todayRate.setCurrName(currtype.getName());
        todayRate.setCurrCode(currtype.getCode());
        todayRate.setToPk(toCurr.getPkCurrtype());
        todayRate.setToCode(toCurr.getCode());
        todayRate.setToName(toCurr.getName());
        todayRate.setRealTime(new Date());

        if (newestRate != null) {
            todayRate.setRate(newestRate.getRate());
            todayRate.setShowTime(newestRate.getShowTime());
        } else {
            todayRate.setRate(new BigDecimal(0));
            todayRate.setShowTime(new Date());
        }

        return todayRate;
    }

    @Override
    public void generateTodayCnyRate(Currtype currtype) {

        Currtype usdCurr = currtypeService.getByCode(Currency.CNY.code);
        CurrencyRate todayRate = generateTodayRate(currtype, usdCurr);

        saveSelective(todayRate);
    }

    @Override
    public CurrencyRate getNewestRate(String currencyCode, String toCurrencyCode) {

        Example example = newExample();
        example.orderBy("real_time desc");// 根据最新时间倒叙
        example.createCriteria().andEqualTo("currCode", currencyCode)
                .andEqualTo("toCode", toCurrencyCode);

        List<CurrencyRate> currencyRates = listByExample(example);
        if (currencyRates.size() > 0) {
            return currencyRates.get(0);
        }
        return null;
    }

    @Override
    public List<CurrencyRateVO> listNewestUsdAndCnyRate(CurrencyRateQuery query) {
        return null;
    }
}
