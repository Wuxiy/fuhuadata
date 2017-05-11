package com.fuhua.doc.service;

import com.fuhua.test.BaseIT;
import com.fuhuadata.service.mybatis.CurrencyRateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>User: wangjie
 * <p>Date: 5/10/2017
 */
public class CurrencyRateServiceIT extends BaseIT {

    @Autowired
    CurrencyRateService rateService;

    @Test
    public void testGenerateTodayRate() {
        rateService.generateTodayRate();
    }
}
