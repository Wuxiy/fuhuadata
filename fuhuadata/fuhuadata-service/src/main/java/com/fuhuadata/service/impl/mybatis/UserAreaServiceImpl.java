package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.domain.mybatis.UserArea;
import com.fuhuadata.service.mybatis.AreaClassService;
import com.fuhuadata.service.mybatis.UserAreaService;
import com.fuhuadata.vo.MixNodeVO;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 4/1/2017
 */
@Service
public class UserAreaServiceImpl extends BaseServiceImpl<UserArea, Integer>
        implements UserAreaService {

    private AreaClassService areaClassService;

    @Autowired
    private void setAreaClassService(AreaClassService areaClassService) {
        this.areaClassService = areaClassService;
    }

    @Override
    public int saveUserArea(Integer userId, List<String> areaIds) {
        if (userId == null || areaIds.size() == 0) {
            return 0;
        }

        Map<String, MixNodeVO> classes = areaClassService.getAllAreaClassNodesMap();

        List<UserArea> userAreas = Lists.newArrayList();
        for (String areaId : areaIds) {
            if (classes.get(areaId) != null) {
                continue;
            }

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
