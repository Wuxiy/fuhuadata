package com.fuhuadata.homesales.user.service;

import com.fuhuadata.homesales.user.domain.Area;
import com.fuhuadata.service.mybatis.BaseTreeableService;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 7/26/2017
 */
public interface AreaService extends BaseTreeableService<Area, Integer> {

    /**
     * 获取用户所管辖地区
     * @param userId
     * @return
     */
    List<Area> listMngAreasByUserId(String userId);

    /**
     * 获取节点的子节点
     * @param area
     * @return
     */
    List<Area> listChildren(Area area);

    /**
     * 获取节点的子节点
     * @param areaId
     * @return
     */
    List<Area> listChildren(String areaId);

    /**
     * 获取节点的子孙节点
     * @param area
     * @return
     */
    List<Area> listAllChildren(Area area);

    /**
     * 获取节点的子子孙孙
     * @param areaId
     * @return
     */
    List<Area> listAllChildren(String areaId);
}
