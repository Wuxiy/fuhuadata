package com.fuhuadata.service.util;

import com.fuhuadata.vo.MixNodeVO;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * <p>User: wangjie
 * <p>Date: 4/12/2017
 */
public class UserTreeCache {

    private static Cache<String, MixNodeVO> cache = CacheBuilder.newBuilder().build();

    public static MixNodeVO get(String key) {
        return cache.getIfPresent(key);
    }

    public static void put(String key, MixNodeVO value) {
        cache.put(key, value);
    }
}
