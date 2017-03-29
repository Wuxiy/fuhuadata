package com.fuhuadata.domain.mybatis;

import java.io.Serializable;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
public abstract class BaseEntity<ID extends Serializable> {

    public abstract void setId(ID id);

    public abstract ID getId();

    @Override
    public String toString() {
        return "BaseEntity{}";
    }
}
