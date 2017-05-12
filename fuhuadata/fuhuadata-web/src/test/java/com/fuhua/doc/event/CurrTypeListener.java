package com.fuhua.doc.event;

import com.fuhuadata.service.mybatis.CurrencyRateService;
import com.fuhuadata.service.util.SpringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * <p>User: wangjie
 * <p>Date: 5/11/2017
 */
@ContextConfiguration({"classpath:spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CurrTypeListener {

    @Autowired
    CurrencyRateService rateService;

    @Test
    public void testSpringGetByName() {
        Object bean = SpringUtils.getBean("com.fuhuadata.service.impl.mybatis.CurrencyRateServiceImpl");

        assertNotNull(bean);
    }

    @Test
    public void testAutowired() {
        assertNotNull(rateService);
    }
}
