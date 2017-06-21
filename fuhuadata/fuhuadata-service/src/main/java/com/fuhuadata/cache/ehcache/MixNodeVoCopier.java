package com.fuhuadata.cache.ehcache;

import com.fuhuadata.vo.MixNodeVO;
import org.ehcache.impl.copy.ReadWriteCopier;

/**
 * <p>User: wangjie
 * <p>Date: 6/7/2017
 */
public class MixNodeVoCopier extends ReadWriteCopier<Object> {

    @Override
    public Object copy(Object obj) {

        if (obj instanceof MixNodeVO) {
            return MixNodeVO.cloneNode((MixNodeVO) obj);
        } else {
            return obj;
        }
    }
}
