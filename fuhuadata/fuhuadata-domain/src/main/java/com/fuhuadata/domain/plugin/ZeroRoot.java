package com.fuhuadata.domain.plugin;

import com.fuhuadata.vo.BaseTreeVo;
import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * <p>User: wangjie
 * <p>Date: 4/16/2017
 */
public class ZeroRoot<N extends BaseTreeVo<ID>, ID extends Serializable>
        implements TreeRoot<N, ID> {

    @Override
    public boolean isRoot(N node) {
        return node.getPid() == null || Objects.equal(node.getPid(), 0);
    }
}
