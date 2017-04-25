package com.fuhuadata.domain.plugin;

import com.fuhuadata.domain.mybatis.AreaCl;
import com.fuhuadata.vo.AreaClVo;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/24/2017
 */
public class AreaClTrees extends Trees<AreaClVo, AreaCl, String> {

    public AreaClTrees(List<AreaCl> flatItems) {
        super(flatItems);
    }

    @Override
    AreaClVo convertToTree(AreaCl item) {
        return AreaClVo.from(item);
    }
}
