package com.fuhuadata.dao;

import com.fuhuadata.domain.Organization;
import com.fuhuadata.domain.query.QueryOrganization;

import java.util.List;

/**
 * Created by hexingfu on 2017/3/21.
 */
public interface OrganizationDao {

    /**
     * 根据条件查询组织列表
     * @param queryOrganization
     * @return
     */
    public List<Organization> getOrganizationListByQuery(QueryOrganization queryOrganization);
}
