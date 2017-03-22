package com.fuhuadata.service;

import com.fuhuadata.domain.Organization;
import com.fuhuadata.domain.query.QueryOrganization;
import com.fuhuadata.vo.CategoryTree;

import java.util.List;

public interface OrganizationService {

    /**
     * 根据条件查询组织列表
     * @param queryOrganization
     * @return
     */
    public List<Organization> getOrganizationListByQuery(QueryOrganization queryOrganization);

    /**
     * 根据条件查询组织树
     * @param queryOrganization
     * @return
     */
    public List<CategoryTree> getOrganizationTreeByQuery(QueryOrganization queryOrganization);

}