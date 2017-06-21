package com.fuhuadata.service.util;

import com.fuhuadata.vo.MixNodeVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>User: wangjie
 * <p>Date: 4/12/2017
 */
@Component
public class UserTreeCache implements InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(UserTreeCache.class);

    @Resource
    private CacheManager cacheManager;
    private Cache cache;
    protected final String cacheName = "sys-orgDepCache";

    public MixNodeVO get(String key) {
        logger.debug("cacheName:{}, get key:{}", cacheName, key);
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        Cache.ValueWrapper valueWrapper = cache.get(key);
        if (valueWrapper == null) {
            return null;
        }
        return (MixNodeVO) valueWrapper.get();
    }

    public void put(String key, MixNodeVO value) {
        logger.debug("cacheName:{}, put key:{}", cacheName, key);
        cache.put(key, value);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        cache = cacheManager.getCache(cacheName);
    }
}
