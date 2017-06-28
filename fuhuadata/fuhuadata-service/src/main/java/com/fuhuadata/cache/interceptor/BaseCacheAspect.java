package com.fuhuadata.cache.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import javax.annotation.Resource;

/**
 * <p>User: wangjie
 * <p>Date: 6/8/2017
 */
public class BaseCacheAspect implements InitializingBean {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private CacheManager cacheManager;
    private Cache cache;
    protected String cacheName;

    @Resource
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public CacheManager getCacheManager() {
        return this.cacheManager;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public String getCacheName() {
        return this.cacheName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String cacheName = getCacheName();
        if (StringUtils.isEmpty(cacheName)) {
            throw new RuntimeException("CacheName must specified.");
        }

        this.cache = getCacheManager().getCache(cacheName);
    }

    public void clear() {
        logger.debug("cacheName:{}, cache clear", cacheName);
        this.cache.clear();
    }

    public void evict(Object key) {
        logger.debug("cacheName:{}, evict key:{}", cacheName, key);
        this.cache.evict(key);
    }

    public <T> T get(Object key) {
        logger.debug("cacheName:{}, get key:{}", cacheName, key);
        if (key == null) {
            return null;
        }
        Cache.ValueWrapper value = cache.get(key);
        if (value == null) {
            return null;
        }
        return (T) value.get();
    }

    public void put(Object key, Object value) {
        logger.debug("cacheName:{}, put key:{}", cacheName, key);
        this.cache.put(key, value);
    }
}
