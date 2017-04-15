package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.constant.AreaType;
import com.fuhuadata.dao.mapper.AreaCodeMapper;
import com.fuhuadata.domain.mybatis.AreaCode;
import com.fuhuadata.service.mybatis.AreaClassService;
import com.fuhuadata.service.mybatis.AreaCodeService;
import com.fuhuadata.vo.MixNodeVO;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 4/14/2017
 */
@Service
public class AreaCodeServiceImpl extends BaseServiceImpl<AreaCode, String>
        implements AreaCodeService {

    private AreaClassService areaClassService;

    @Autowired
    public void setAreaClassService(AreaClassService areaClassService) {
        this.areaClassService = areaClassService;
    }

    private AreaCodeMapper getCodeMapper() {
        return (AreaCodeMapper) baseMapper;
    }

    @Override
    public List<AreaCode> listAreaCodesByUserId(Integer userId) {
        if (userId == null) {
            return Lists.newArrayList();
        }

        return getCodeMapper().listCodesByUserId(userId);
    }

    @Override
    public List<MixNodeVO> listAreaCodeNodesByUserId(Integer userId) {
        final List<AreaCode> areaCodes = listAreaCodesByUserId(userId);

        return Lists.transform(areaCodes, new Function<AreaCode, MixNodeVO>() {
            @Override
            public MixNodeVO apply(AreaCode input) {
                return convertToNode(input);
            }
        });
    }

    @Override
    public List<MixNodeVO> getAreaTreeArraysByUserId(Integer userId) {
        Map<String, MixNodeVO> classMap = areaClassService.getAllAreaClassNodesMap();
        List<MixNodeVO> codeNodes = listAreaCodeNodesByUserId(userId);
        List<MixNodeVO> treeNodes = Lists.newArrayList(codeNodes);
        HashSet<String> parentIds = Sets.newHashSet();

        for (MixNodeVO codeNode : codeNodes) {
            String pid = codeNode.getPid();

            while (StringUtils.isNotBlank(pid) && !"0".equals(pid)) {
                MixNodeVO parent = classMap.get(pid);
                if (parent != null && !parentIds.contains(pid)) {
                    treeNodes.add(parent);
                    parentIds.add(pid);
                    pid = parent.getPid();
                } else {
                    break;
                }
            }
        }

        return treeNodes;
    }

    private MixNodeVO convertToNode(AreaCode code) {
        MixNodeVO nodeVO = new MixNodeVO(AreaType.CODE.key);

        String pid = code.getParentId();
        if (StringUtils.isBlank(pid)) {
            pid = code.getAreaclassId() != null ? String.valueOf(code.getAreaclassId()) : null;
        }

        nodeVO.setCid(code.getId());
        nodeVO.setCname(code.getName());
        nodeVO.setPid(pid);
        nodeVO.setNcId(code.getId());

        return nodeVO;
    }
}
