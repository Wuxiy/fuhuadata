package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.constant.NodeType;
import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.domain.plugin.OrganizationTrees;
import com.fuhuadata.service.mybatis.OrganizationService;
import com.fuhuadata.service.util.UserTreeCache;
import com.fuhuadata.vo.MixNodeVO;
import com.fuhuadata.vo.OrganizationVO;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/11/2017
 */
@Service("com.fuhuadata.service.impl.mybatis.OrganizationServiceImpl")
public class OrganizationServiceImpl extends BaseTreeableServiceImpl<Organization, Integer>
        implements OrganizationService {

    @Override
    public int countNextIndex(Integer parentId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteSelfAndChildren(Organization self) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int updateChildrenParentIds(String newChildrenParentIds, String oldChildrenParentIds) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Organization> listSelfAndNextSiblings(Integer parentId, int weight) {
        return Collections.emptyList();
    }

    @Override
    public List<OrganizationVO> listOrgTree() {
        List<Organization> orgs = list();
        orgs.add(getRoot());
        HashSet<Integer> parentIds = Sets.newHashSet(getRoot().getId());

        return new OrganizationTrees(orgs, parentIds).convertToTreeList();
    }

    @Override
    public List<MixNodeVO> listOrgNodes() {
        List<Organization> orgs = list();
        List<MixNodeVO> nodes = Lists.newArrayList();

        for (Organization org : orgs) {
            MixNodeVO nodeVO = convertToNode(org);

            UserTreeCache.put(nodeVO.getCid(), nodeVO);// 添加到缓存
            UserTreeCache.put(nodeVO.getNcId(), nodeVO);

            nodes.add(nodeVO);
        }
        return nodes;
    }

    @Override
    public List<Organization> listOrgs() {
        return list();
    }

    @Override
    public Organization getByCode(String ncId) {
        Example example = new Example(Organization.class);
        example.createCriteria().andEqualTo("ncId", ncId);

        List<Organization> orgs = listByExample(example);
        if (orgs.size() == 0) {
            return orgs.get(0);
        }

        return null;
    }

    private MixNodeVO convertToNode(Organization org) {

        MixNodeVO nodeVO = new MixNodeVO(NodeType.ORG.key);

        nodeVO.setCid(String.valueOf(org.getId()));
        nodeVO.setCname(org.getName());
        nodeVO.setPid(String.valueOf(org.getParentId()));
        nodeVO.setNcId(org.getNcId());
        nodeVO.setIsParent(true);

        return nodeVO;
    }
}
