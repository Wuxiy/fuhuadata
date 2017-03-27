package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {

    E get(ID id);

    E get(E entity);

    List<E> getAll(E entity);

    List<E> getAll();

    List<E> getAllByExample(Object example);

    int add(E entity);

    int addSelective(E entity);

    int update(E entity);

    int updateSelective(E entity);

    int delete(ID id);

    int delete(E entity);
}
