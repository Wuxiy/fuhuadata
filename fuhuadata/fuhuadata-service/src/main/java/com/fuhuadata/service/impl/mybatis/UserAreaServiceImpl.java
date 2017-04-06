package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.UserArea;
import com.fuhuadata.service.mybatis.UserAreaService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/1/2017
 */
@Service
public class UserAreaServiceImpl extends BaseServiceImpl<UserArea, Integer>
        implements UserAreaService {

    @Override
    public void saveUserArea(Integer userId, List<String> areaIds) {
        if (userId == null || areaIds.size() == 0) {
            return;
        }

        List<UserArea> userAreas = Lists.newArrayList();
        for (String areaId : areaIds) {
            UserArea userArea = new UserArea();
            userArea.setUserId(userId);
            userArea.setAreaId(areaId);

            userAreas.add(userArea);
        }

        deleteAreaByUserId(userId);
        saveList(userAreas);
    }

    @Override
    public int deleteAreaByUserId(Integer userId) {
        Example example = new Example(UserArea.class);
        example.createCriteria().andEqualTo("userId", userId);

        return delete(example);
    }
}
