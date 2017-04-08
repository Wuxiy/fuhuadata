package com.fuhuadata.domain.plugin;

import com.fuhuadata.domain.mybatis.BaseEntity;
import com.fuhuadata.util.ReflectUtils;
import com.fuhuadata.vo.BaseTreeVo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 4/3/2017
 */
public abstract class Trees<T extends BaseTreeVo<ID>,
        E extends BaseEntity<ID> & Treeable<ID>,
        ID extends Serializable> {

    private final Class<T> voClass;

    private List<E> flatItems;

    private HashSet<ID> parentIds;

    {
        voClass = ReflectUtils.findParameterizedType(getClass(), 0);
    }

    public Trees(List<E> flatItems, HashSet<ID> parentIds) {
        this.flatItems = flatItems;
        this.parentIds = parentIds;
    }

    /**
     * 将扁平的 List 转换为树结构
     * @return
     */
    public List<T> convertToTreeList() {
        List<T> roots = Lists.newArrayList();
        Map<ID, T> lookup = Maps.newHashMap();

        for (E item : this.flatItems) {
            T node = convertToTree(item);
            ID id = node.getCid();

            if (lookup.get(id) != null) {
                // 如果存在，则前面作为父节点被添加过
                // 需要同步
                node.setNodes(lookup.get(id).getNodes());
            }
            lookup.put(id, node);

            if (isParent(id)) {
                // 父节点
                roots.add(node);
            } else {
                // 检查父节点是否在 Map 中创建，
                // 如果没有则创建
                findOrNewParent(lookup, node);
            }
        }

        return roots;
    }

    abstract T convertToTree(E item);

    private void findOrNewParent(Map<ID, T> lookup, T node) {
        ID pid = node.getPid();
        T parentNode = lookup.get(pid);
        if (parentNode == null) {
            parentNode = newVoInstance();
            parentNode.setCid(pid);
            lookup.put(pid, parentNode);
        }

        parentNode.addChildNode(node);
    }

    private boolean isParent(ID id) {
        return this.parentIds.contains(id);
    }

    private T newVoInstance() {
        try {
            return voClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("can not instantiated entity : " + this.voClass, e);
        }
    }
}
