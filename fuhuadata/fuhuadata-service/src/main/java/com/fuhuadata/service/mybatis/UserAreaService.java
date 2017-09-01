package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.UserArea;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/1/2017
 */
public interface UserAreaService extends BaseService<UserArea, Integer> {

    /**
     * 为用户添加地区
     * @param userId
     * @param areaIds
     */
    int saveUserArea(String userId, List<String> areaIds);

    int deleteAreaByUserId(String userCode);

    /**
     * 获取用户关联地区ids
     * @param userId
     * @return
     */
    List<String> listAreaIdsByUserId(String userId);

    /**
     * 获取地区关联用户ids
     * @param areaId
     * @return
     */
    List<String> listUserIdsByAreaId(String areaId);

}
