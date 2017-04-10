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
    void saveUserArea(Integer userId, List<String> areaIds);

    int deleteAreaByUserId(Integer userId);
}