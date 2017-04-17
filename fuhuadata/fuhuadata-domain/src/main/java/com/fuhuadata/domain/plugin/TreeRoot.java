package com.fuhuadata.domain.plugin;

import com.fuhuadata.vo.BaseTreeVo;

import java.io.Serializable;

/**
 * <p>User: wangjie
 * <p>Date: 4/16/2017
 */
public interface TreeRoot<N extends BaseTreeVo<ID>, ID extends Serializable> {

    boolean isRoot(N node);
}
