package com.fuhuadata.domain.plugin;

import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.vo.OrganizationVO;

import java.util.HashSet;
import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/11/2017
 */
public class OrganizationTrees extends Trees<OrganizationVO, Organization, Integer> {

    public OrganizationTrees(List<Organization> flatItems, HashSet<Integer> parentIds) {
        super(flatItems, parentIds);
    }

    @Override
    OrganizationVO convertToTree(Organization item) {

        OrganizationVO organizationVO = new OrganizationVO();
        organizationVO.setCid(item.getId());
        organizationVO.setCname(item.getName());
        organizationVO.setPid(item.getParentId());
        organizationVO.setNcId(item.getNcId());
        return organizationVO;
    }

    @Override
    protected boolean isParent(OrganizationVO node) {
        return node.getPid() != null && node.getPid() == 0;
    }
}
