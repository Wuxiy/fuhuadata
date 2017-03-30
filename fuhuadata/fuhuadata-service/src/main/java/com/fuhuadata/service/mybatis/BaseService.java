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

    List<E> list(E entity);

    List<E> list();

    List<E> listByExample(Object example);

    int save(E entity);

    int saveSelective(E entity);

    int update(E entity);

    int update(List<E> entices);

    int updateSelective(E entity);

    int updateBatch(List<E> entices);

    int delete(ID id);

    int delete(E entity);
}
