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
        child.setWeight(countNextIndex(parent.getId()));
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

    @Override
    public void move(E source, E target, String moveType) {
        // 根节点不能移动
        if (source == null || target == null || source.isRoot()) {
            return;
        }

        // 如何是兄弟节点，直接交换 index 即可
        boolean isSibling = Objects.equal(source.getParentId(), target.getParentId());
        boolean isNextOrPrevMove = "next".equals(moveType) || "prev".equals(moveType);
        if (isSibling && isNextOrPrevMove && Math.abs(source.getWeight() - target.getWeight()) == 1) {

            //无需移动
            if ("next".equals(moveType) && source.getWeight() > target.getWeight()) {
                return;
            }
            if ("prev".equals(moveType) && source.getWeight() < target.getWeight()) {
                return;
            }

            int sourceWeight = source.getWeight();
            source.setWeight(target.getWeight());
            target.setWeight(sourceWeight);

            updateSelective(source);
            updateSelective(target);
            return;
        }

        // 移动到目标节点之后
        if ("next".equals(moveType)) {
            List<E> siblings = listSelfAndNextSiblings(target.getParentId(), target.getWeight());
            siblings.remove(0);// 将 target 自己移除

            if (siblings.size() == 0) {// 如果没有兄弟了，直接设置 source 为 target 的兄弟
                int nextWeight = countNextIndex(target.getParentId());
                updateSelftAndChild(source, target.getParentId(), target.getParentIds(), nextWeight);
                return;
            } else {// 如果有兄弟，那么就是把 source 移动到第一个兄弟之前
                moveType = "prev";
                target = siblings.get(0);
            }
        }

        if ("prev".equals(moveType)) {

            List<E> siblings = listSelfAndNextSiblings(target.getParentId(), target.getWeight());
            // 兄弟节点中包含 source 节点
            if (siblings.contains(source)) {
                // 1 2 [3 source] 4
                siblings = siblings.subList(0, siblings.indexOf(source) + 1);
                int firstWeight = siblings.get(0).getWeight();
                for (int i = 0; i < siblings.size() - 1; i++) {
                    siblings.get(i).setWeight(siblings.get(i + 1).getWeight());
                }
                siblings.get(siblings.size() - 1).setWeight(firstWeight);
                update(siblings);
            } else {
                // 1 2 3 4  [5 new]
                int nextWeight = countNextIndex(target.getParentId());
                int firstWeight = siblings.get(0).getWeight();
                for (int i = 0; i < siblings.size() - 1; i++) {
                    siblings.get(i).setWeight(siblings.get(i + 1).getWeight());
                }
                siblings.get(siblings.size() - 1).setWeight(nextWeight);
                source.setWeight(firstWeight);
                update(siblings);
                updateSelftAndChild(source, target.getParentId(), target.getParentIds(), source.getWeight());
            }

            return;
        }

        //否则作为最后孩子节点
        int nextWeight = countNextIndex(target.getId());
        updateSelftAndChild(source, target.getId(), target.makeSelfAsNewParentIds(), nextWeight);
    }

    @Override
    public void move(ID sourceId, ID targetId, String moveType) {
        E source = get(sourceId);
        E target = get(targetId);

        move(source, target, moveType);
    }

    /**
     * 把源节点全部变更为目标节点
     *
     * @param source
     * @param newParentIds
     */
    private int updateSelftAndChild(E source, ID newParentId, String newParentIds, int newWeight) {
        String oldSourceChildrenParentIds = source.makeSelfAsNewParentIds();
        source.setParentId(newParentId);
        source.setParentIds(newParentIds);
        source.setWeight(newWeight);
        updateSelective(source);
        String newSourceChildrenParentIds = source.makeSelfAsNewParentIds();
        return updateChildrenParentIds(newSourceChildrenParentIds, oldSourceChildrenParentIds);
    }
}
