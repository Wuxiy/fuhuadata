package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.AreaCl;
import com.fuhuadata.vo.AreaClVo;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/24/2017
 */
public interface AreaClService extends BaseTreeableService<AreaCl, String> {

    List<AreaClVo> getAreaTreeNodes();

    /**
     * 获取用户关联地区树
     * @param userCode
     * @return
     */
    List<AreaClVo> getAreaTreeByUserCode(String userCode);

    /**
     * 获取用户关联地区 id
     * @param userCode
     * @return
     */
    List<AreaCl> getAreasByUserCode(String userCode);

    /**
     *
     * @param userCode
     * @return
     */
    List<AreaClVo> getAreaNodesByUserCode(String userCode);

    /**
     * 获取子节点的所有祖先节点
     * @param childNodes
     * @return
     */
    List<AreaCl> getAncestorOfNodes(List<AreaCl> childNodes);

    AreaCl getById(String id);

    AreaCl getByAreaCode(String areaCode);
}
