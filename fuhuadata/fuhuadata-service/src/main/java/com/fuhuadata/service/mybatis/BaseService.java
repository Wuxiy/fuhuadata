package com.fuhuadata.service.mybatis;

import com.fuhuadata.dao.datasource.DataSource;
import com.fuhuadata.domain.mybatis.BaseEntity;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
@DataSource("mysql")
public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {

    E get(ID id);

    Optional<E> getOpt(ID id);

    E get(E entity);

    Optional<E> getOpt(E entity);

    List<E> list(E entity);

    /**
     * 获取所有记录
     * @return
     */
    List<E> list();

    List<E> listByExample(Object example);

    int save(E entity);

    int saveSelective(E entity);

    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列
     * @param entices
     * @return
     */
    int saveList(List<E> entices);

    /**
     * 批量插入，使用 batch 方式
     * @param entices
     * @return
     */
    List<ID> saveBatch(List<E> entices);

    /**
     * 保存或更新
     * @param entity
     * @return
     */
    int saveOrUpdateSelective(E entity);

    int update(E entity);

    int update(List<E> entices);

    int updateSelective(E entity);

    int updateBatch(List<E> entices);

    int updateBatchSelective(List<E> entices);

    int delete(ID id);

    int delete(E entity);

    int delete(Example example);
}
