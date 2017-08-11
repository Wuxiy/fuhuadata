package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.UserArea;
import com.fuhuadata.service.mybatis.AreaClService;
import com.fuhuadata.service.mybatis.UserAreaService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
    public int saveUserArea(String userCode, List<String> areaIds) {
        if (userCode == null || areaIds.size() == 0) {
            return 0;
        }

        List<UserArea> userAreas = Lists.newArrayList();
        for (String areaId : areaIds) {

            UserArea userArea = new UserArea();
            userArea.setUserCode(userCode);
            userArea.setAreaId(areaId);

            userAreas.add(userArea);
        }

        deleteAreaByUserId(userCode);
        return saveList(userAreas);
    }

    @Override
    public int deleteAreaByUserId(String userCode) {
        Example example = new Example(UserArea.class);
        example.createCriteria().andEqualTo("userCode", userCode);

        return delete(example);
    }

    @Override
    public List<String> listAreaIdsByUserId(String userId) {

        if (StringUtils.isEmpty(userId)) {
            return Collections.emptyList();
        }

        Example example = newExample();
        example.createCriteria().andEqualTo("userCode", userId);

        List<UserArea> userAreas = this.listByExample(example);
        return userAreas.stream()
                .map(UserArea::getAreaId)
                .collect(toList());
    }

    @Override
    public List<String> listUserIdsByAreaId(String areaId) {

        if (StringUtils.isEmpty(areaId)) {
            return Collections.emptyList();
        }

        Example example = newExample();
        example.createCriteria().andEqualTo("areaId", areaId);
        List<UserArea> userAreas = this.listByExample(example);

        return userAreas.stream()
                .map(UserArea::getUserCode)
                .collect(toList());
    }
}
