package com.fuhuadata.service.task.listener;

import com.fuhuadata.service.mybatis.CurrencyRateService;
import com.fuhuadata.service.task.event.CurrtypeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>User: wangjie
 * <p>Date: 5/10/2017
 */
@Component("com.fuhuadata.service.task.listener.CurrTypeListener")
public class CurrTypeListener {

    private static Logger logger = LoggerFactory.getLogger(CurrTypeListener.class);

    private CurrencyRateService currencyRateService;

    @Resource
    public void setCurrencyRateService(CurrencyRateService currencyRateService) {
        this.currencyRateService = currencyRateService;
    }

    @Async
    @EventListener
    public void generateCurrRateToday(CurrtypeEvent event) {
        logger.info("NC 币种档案同步后，生成当天汇率信息");

        try {
            currencyRateService.generateTodayRate();
        } catch (Exception e) {
            logger.error("生成当天汇率信息出错", e);
        }
    }
}
