package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.dao.mapper.AreaClMapper;
import com.fuhuadata.domain.mybatis.AreaCl;
import com.fuhuadata.service.mybatis.AreaClService;
import com.fuhuadata.service.mybatis.UserAreaService;
import com.fuhuadata.vo.AreaClVo;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 4/24/2017
 */
@Service
public class AreaClServiceImpl extends BaseTreeableServiceImpl<AreaCl, String>
        implements AreaClService {

    private UserAreaService userAreaService;

    private void setUserAreaService(UserAreaService userAreaService) {
        this.userAreaService = userAreaService;
    }

    private AreaClMapper getAreaClMapper() {
        return (AreaClMapper) baseMapper;
    }

    @Override
    public int countNextIndex(String parentId) {
        return 0;
    }

    @Override
    public void deleteSelfAndChildren(AreaCl self) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int updateChildrenParentIds(String newChildrenParentIds, String oldChildrenParentIds) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<AreaCl> listSelfAndNextSiblings(String parentId, int weight) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<AreaClVo> getAreaTreeNodes() {
        List<AreaCl> areaCls = getAreaClMapper().listForeignAreas();

        return Lists.transform(areaCls, new Function<AreaCl, AreaClVo>() {
            @Override
            public AreaClVo apply(AreaCl input) {
                return AreaClVo.from(input);
            }
        });
    }

    @Override
    public List<AreaClVo> getAreaTreeByUserCode(String userCode) {
        List<AreaCl> areaChildNodes = getAreasByUserCode(userCode);// 用户关联地区的叶子节点
        List<AreaCl> allNodes = getAncestorOfNodes(areaChildNodes);// 叶子节点和其所有祖先，完整的树节点

        return Lists.transform(allNodes, new Function<AreaCl, AreaClVo>() {
            @Override
            public AreaClVo apply(AreaCl input) {
                return AreaClVo.from(input);
            }
        });
    }

    @Override
    public List<AreaCl> getAreasByUserCode(String userCode) {
        if (userCode == null) {
            return Collections.emptyList();
        }

        return getAreaClMapper().listAreasByUserCode(userCode);
    }

    @Override
    public List<AreaClVo> getAreaNodesByUserCode(String userCode) {
        if (userCode == null) {
            return Collections.emptyList();
        }

        List<AreaClVo> nodes = Lists.newArrayList();
        List<AreaCl> areas = getAreasByUserCode(userCode);
        for (AreaCl areaCl : areas) {
            nodes.add(AreaClVo.from(areaCl));
        }
        return nodes;
    }

    @Override
    public List<AreaCl> getAncestorOfNodes(List<AreaCl> childNodes) {

        List<AreaCl> allNodes = Lists.newArrayList();
        Map<String, AreaCl> ancestorLookup = Maps.newHashMap();

        for (AreaCl areaCl : childNodes) {

            while (areaCl != null) {
                if (ancestorLookup.get(areaCl.getId()) == null) {
                    allNodes.add(areaCl);
                    ancestorLookup.put(areaCl.getId(), areaCl);
                }

                areaCl = getById(areaCl.getParentId());
            }
        }

        return allNodes;
    }

    @Override
    public AreaCl getById(String id) {
        return get(id);
    }

    @Override
    public AreaCl getByAreaCode(String areaCode) {
        Example example = new Example(AreaCl.class);
        example.createCriteria().andEqualTo("code", areaCode);

        List<AreaCl> areaCls = listByExample(example);
        if (areaCls.size() == 1) {
            return areaCls.get(0);
        }
        return null;
    }

}
