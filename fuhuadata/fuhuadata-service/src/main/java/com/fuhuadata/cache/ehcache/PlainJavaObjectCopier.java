package com.fuhuadata.cache.ehcache;

import com.fuhuadata.domain.mybatis.BaseEntity;
import org.apache.commons.beanutils.BeanUtils;
import org.ehcache.impl.copy.ReadWriteCopier;

/**
 * <p>User: wangjie
 * <p>Date: 6/12/2017
 */
public class PlainJavaObjectCopier extends ReadWriteCopier<Object> {

    @Override
    public Object copy(Object obj) {

        if (obj instanceof BaseEntity) {
            try {
                return BeanUtils.cloneBean(obj);
            } catch (Exception e) {
                throw new RuntimeException("克隆实体失败", e);
            }
        } else {
            return obj;
        }
    }
}
