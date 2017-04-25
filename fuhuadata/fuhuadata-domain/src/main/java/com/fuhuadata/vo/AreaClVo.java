package com.fuhuadata.vo;

import com.fuhuadata.domain.mybatis.AreaCl;

/**
 * <p>User: wangjie
 * <p>Date: 4/24/2017
 */
public class AreaClVo extends BaseTreeVo<String> {

    public static AreaClVo from(AreaCl item) {
        AreaClVo areaClVo = new AreaClVo();
        areaClVo.setCid(item.getPkAreacl());
        areaClVo.setCode(item.getCode());
        areaClVo.setCname(item.getName());
        areaClVo.setPid(item.getPkFatherarea());

        return areaClVo;
    }

}
