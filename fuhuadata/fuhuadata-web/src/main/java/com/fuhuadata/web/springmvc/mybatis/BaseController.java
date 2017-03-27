package com.fuhuadata.web.springmvc.mybatis;

import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.util.ReflectUtils;

import java.io.Serializable;

/**
 * <p>User: wangjie
 * <p>Date: 3/24/2017
 */
public abstract class BaseController<E extends BaseEntity<ID>, ID extends Serializable> {

    /**
     * 实体类型
     */
    protected final Class<E> entityClass;

    public BaseController() {
        this.entityClass = ReflectUtils.findParameterizedType(getClass(), 0);
    }

    protected E newEntity() {
        try {
            return entityClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("can not instantiated entity : " + this.entityClass, e);
        }
    }
}
