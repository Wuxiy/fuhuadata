package com.fuhuadata.domain.plugin;

import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.vo.OrganizationVO;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/11/2017
 */
public class OrganizationTrees extends Trees<OrganizationVO, Organization, String> {

    public OrganizationTrees(List<Organization> flatItems) {
        super(flatItems);
    }

    @Override
    OrganizationVO convertToTree(Organization item) {

        OrganizationVO organizationVO = new OrganizationVO();
        organizationVO.setRoot(item.isRoot());
        organizationVO.setCid(item.getNcId());
        organizationVO.setCode(item.getCode());
        organizationVO.setCname(item.getName());
        organizationVO.setPid(item.getParentId());
        organizationVO.setNcId(item.getNcId());
        return organizationVO;
    }
}
