package com.fuhuadata.homesales.user.service;

import com.fuhuadata.homesales.user.domain.Area;
import com.fuhuadata.service.impl.mybatis.BaseTreeableServiceImpl;
import com.fuhuadata.service.mybatis.UserAreaService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 7/26/2017
 */
@Service("com.fuhuadata.homesales.user.service.AreaServiceImpl")
public class AreaServiceImpl extends BaseTreeableServiceImpl<Area, Integer> implements AreaService {

    @Resource
    UserAreaService userAreaService;

    @Override
    public int countNextIndex(Integer parentId) {
        return 0;
    }

    @Override
    public void deleteSelfAndChildren(Area self) {

    }

    @Override
    public int updateChildrenParentIds(String newChildrenParentIds, String oldChildrenParentIds) {
        return 0;
    }

    @Override
    public List<Area> listSelfAndNextSiblings(Integer parentId, int weight) {
        return null;
    }

    @Override
    public List<Area> listMngAreasByUserId(String userId) {

        if (StringUtils.isEmpty(userId)) {
            return Collections.emptyList();
        }

        List<Area> areas = Lists.newArrayList();
        List<String> areaIds = userAreaService.listAreaIdsByUserId(userId);

        areaIds.forEach(areaId -> {
          areas.add(this.get(Integer.valueOf(areaId)));
          areas.addAll(listAllChildren(areaId));
        });

        return areas;
    }

    @Override
    public List<Area> listChildren(Area area) {

        if (area == null) {
            return Collections.emptyList();
        }

        return listChildren(String.valueOf(area.getId()));
    }

    @Override
    public List<Area> listChildren(String areaId) {

        if (StringUtils.isEmpty(areaId)) {
            return Collections.emptyList();
        }

        Example example = newExample();
        example.createCriteria()
                .andEqualTo("parentId", areaId);
        return listByExample(example);
    }

    @Override
    public List<Area> listAllChildren(Area area) {

        if (area == null) {
            return Collections.emptyList();
        }

        return listAllChildren(String.valueOf(area.getId()));
    }

    @Override
    public List<Area> listAllChildren(String areaId) {

        if (StringUtils.isEmpty(areaId)) {
            return Collections.emptyList();
        }

        List<Area> children = Lists.newArrayList();

        List<Area> areas = listChildren(areaId);
        children.addAll(areas);

        // 递归查找子孙节点
        areas.forEach(child -> children.addAll(listAllChildren(child)));

        return children;
    }
}
