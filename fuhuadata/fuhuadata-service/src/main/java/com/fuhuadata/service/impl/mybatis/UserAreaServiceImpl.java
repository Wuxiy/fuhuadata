package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.UserArea;
import com.fuhuadata.service.mybatis.AreaClService;
import com.fuhuadata.service.mybatis.UserAreaService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
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

    private AreaClService areaClService;

    @Autowired
    private void setAreaClService(AreaClService areaClService) {
        this.areaClService = areaClService;
    }

    @Override
    public int saveUserArea(Integer userId, List<String> areaIds) {
        if (userId == null || areaIds.size() == 0) {
            return 0;
        }

        List<UserArea> userAreas = Lists.newArrayList();
        for (String areaId : areaIds) {

            UserArea userArea = new UserArea();
            userArea.setUserId(userId);
            userArea.setAreaId(areaId);

            userAreas.add(userArea);
        }

        deleteAreaByUserId(userId);
        return saveList(userAreas);
    }

    @Override
    public int deleteAreaByUserId(Integer userId) {
        Example example = new Example(UserArea.class);
        example.createCriteria().andEqualTo("userId", userId);

        return delete(example);
    }
}
