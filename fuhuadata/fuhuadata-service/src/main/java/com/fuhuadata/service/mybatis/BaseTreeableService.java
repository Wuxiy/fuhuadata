package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.domain.plugin.Treeable;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
public interface BaseTreeableService<E extends BaseEntity<ID> & Treeable<ID>, ID extends Serializable>
        extends BaseService<E, ID> {

    /**
     * 获取根节点
     *
     * @return
     */
    E getRoot();

    /**
     * 新建子节点
     *
     * @param parent
     * @param child
     */
    int appendChild(E parent, E child);

    void deleteSelfAndChildren(E self);

    /**
     * 查询节点的子子孙孙
     *
     * @param parentIds 父节点id集合
     * @param example
     * @return
     */
    List<E> findChildrenByParentIds(List<ID> parentIds, Example example);

    /**
     * 查询节点的子子孙孙
     *
     * @param parents
     * @param example
     * @return
     */
    List<E> findChildren(List<E> parents, Example example);

}
