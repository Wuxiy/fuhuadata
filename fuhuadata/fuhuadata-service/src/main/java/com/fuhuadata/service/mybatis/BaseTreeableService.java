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
     * 获取下一个菜单顺序
     * @param parentId
     * @return
     */
    int countNextIndex(ID parentId);

    /**
     * 新建子节点
     *  @param parent
     * @param child
     */
    ID appendChild(E parent, E child);

    /**
     * 删除节点，同时删除子节点
     * @param self
     */
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

    /**
     * 移动节点
     * @param source
     * @param target
     * @param moveType
     */
    void move(E source, E target, String moveType);

    /**
     * 移动节点
     * @param sourceId
     * @param targetId
     * @param moveType
     */
    void move(ID sourceId, ID targetId, String moveType);

    /**
     * 更新
     * @param newChildrenParentIds
     * @param oldChildrenParentIds
     * @return
     */
    int updateChildrenParentIds(String newChildrenParentIds, String oldChildrenParentIds);

    List<E> listSelfAndNextSiblings(ID parentId, int weight);

}
