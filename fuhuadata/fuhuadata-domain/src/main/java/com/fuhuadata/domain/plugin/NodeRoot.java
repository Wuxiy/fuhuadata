package com.fuhuadata.domain.plugin;

import com.fuhuadata.vo.BaseTreeVo;

import java.io.Serializable;

/**
 * <p>User: wangjie
 * <p>Date: 4/16/2017
 */
public class NodeRoot<N extends BaseTreeVo<ID>, ID extends Serializable> implements TreeRoot<N, ID> {

    @Override
    public boolean isRoot(N node) {
        return node.isRoot();
    }
}
