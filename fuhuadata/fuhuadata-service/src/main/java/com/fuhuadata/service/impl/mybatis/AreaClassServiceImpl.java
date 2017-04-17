package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.constant.AreaType;
import com.fuhuadata.dao.mapper.AreaClassMapper;
import com.fuhuadata.domain.mybatis.AreaClass;
import com.fuhuadata.service.mybatis.AreaClassService;
import com.fuhuadata.vo.MixNodeVO;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 4/14/2017
 */
@Service
public class AreaClassServiceImpl extends BaseServiceImpl<AreaClass, Integer>
        implements AreaClassService {

    private AreaClassMapper getAreaClassMapper() {
        return (AreaClassMapper) baseMapper;
    }

    @Override
    public List<AreaClass> listAreaClass() {
        return list();
    }

    @Override
    public List<MixNodeVO> listAllAreaClassNodes() {
        List<MixNodeVO> nodes = Lists.newArrayList();
        List<AreaClass> areaClasses = listAreaClass();

        for (AreaClass areaClass : areaClasses) {
            nodes.add(convertToNode(areaClass));
        }

        return nodes;
    }

    @Override
    public Map<String, MixNodeVO> getAllAreaClassNodesMap() {
        Map<String, MixNodeVO> result = Maps.newHashMap();
        List<AreaClass> areaClasses = listAreaClass();

        for (AreaClass areaClass : areaClasses) {
            MixNodeVO nodeVO = convertToNode(areaClass);
            result.put(nodeVO.getCid(), nodeVO);
        }

        return ImmutableMap.<String, MixNodeVO>builder().putAll(result).build();
    }

    private MixNodeVO convertToNode(AreaClass areaClass) {
        MixNodeVO nodeVO = new MixNodeVO(AreaType.CLASS.key);

        nodeVO.setCid(String.valueOf(areaClass.getId()));
        nodeVO.setCname(areaClass.getName());
        nodeVO.setPid("0");
        nodeVO.setNcId(String.valueOf(areaClass.getAreaclassId()));

        return nodeVO;
    }
}
