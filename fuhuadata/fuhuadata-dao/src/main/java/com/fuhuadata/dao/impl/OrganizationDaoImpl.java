package com.fuhuadata.dao.impl;

import com.fuhuadata.dao.OrganizationDao;
import com.fuhuadata.domain.Organization;
import com.fuhuadata.domain.query.QueryOrganization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hexingfu on 2017/3/22.
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    private static  final String GETLIST = "Organization.getOrganizationListByQuery";

    public List<Organization> getOrganizationListByQuery(QueryOrganization queryOrganization) {
        return sqlMapClientTemplate.queryForList(GETLIST,queryOrganization);
    }
}
