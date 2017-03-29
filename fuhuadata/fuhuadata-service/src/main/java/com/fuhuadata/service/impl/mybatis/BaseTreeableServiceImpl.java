package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.domain.plugin.Treeable;
import com.fuhuadata.service.mybatis.BaseTreeableService;
import com.google.common.base.Objects;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 3/23/2017
 */
public abstract class BaseTreeableServiceImpl<E extends BaseEntity<ID> & Treeable<ID>, ID extends Serializable>
        extends BaseServiceImpl<E, ID> implements BaseTreeableService<E, ID> {

    @Override
    public int appendChild(E parent, E child) {
        if (parent == null) {
            parent = getRoot();
        }

        child.setParentId(parent.getId());
        child.setParentIds(parent.makeSelfAsNewParentIds());

        // 不能修改 id 为 0
        if (child.getId() != null && Objects.equal(child.getId(), 0)) {
            return updateSelective(child);
        }
        return save(child);
    }

    @Override
    public List<E> findChildrenByParentIds(List<ID> parentIds, Example example) {
        if (parentIds.isEmpty()) {
            return Collections.emptyList();
        }

        Example idsExam = new Example(entityClass);
        idsExam.createCriteria().andIn("menuId", parentIds);
        idsExam.setOrderByClause(example.getOrderByClause());
        List<E> parents = listByExample(idsExam);

        return findChildren(parents, example);
    }

    @Override
    public List<E> findChildren(List<E> parents, Example example) {

        if (parents.isEmpty()) {
            return Collections.emptyList();
        }

        for (E parent : parents) {
            example.or(example.createCriteria()
                    .andLike("parentIds", parent.makeSelfAsNewParentIds() + "%"));
        }

        return listByExample(example);
    }
}
