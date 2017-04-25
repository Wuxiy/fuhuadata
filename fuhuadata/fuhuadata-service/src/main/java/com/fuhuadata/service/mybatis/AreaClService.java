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
     * @param userId
     * @return
     */
    List<AreaClVo> getAreaTreeByUserId(Integer userId);

    /**
     * 获取用户关联地区 id
     * @param userId
     * @return
     */
    List<AreaCl> getAreasByUserId(Integer userId);

    /**
     *
     * @param userId
     * @return
     */
    List<AreaClVo> getAreaNodesByUserId(Integer userId);

    /**
     * 获取子节点的所有祖先节点
     * @param childNodes
     * @return
     */
    List<AreaCl> getAncestorOfNodes(List<AreaCl> childNodes);

    AreaCl getById(String id);

    AreaCl getByAreaCode(String areaCode);
}
