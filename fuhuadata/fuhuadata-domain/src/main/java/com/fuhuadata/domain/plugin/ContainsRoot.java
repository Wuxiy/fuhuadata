package com.fuhuadata.domain.plugin;

import com.fuhuadata.vo.BaseTreeVo;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>User: wangjie
 * <p>Date: 4/16/2017
 */
public class ContainsRoot<N extends BaseTreeVo<ID>, ID extends Serializable>
        implements TreeRoot<N, ID> {

    private Set<ID> parentIds;

    public ContainsRoot(Set<ID> parentIds) {
        this.parentIds = parentIds;
    }

    @Override
    public boolean isRoot(N node) {
        return parentIds == null || parentIds.contains(node.getCid());
    }
}
