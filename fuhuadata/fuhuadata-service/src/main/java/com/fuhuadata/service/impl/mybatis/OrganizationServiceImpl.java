package com.fuhuadata.service.impl.mybatis;

import com.fuhuadata.constant.NodeType;
import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.domain.plugin.OrganizationTrees;
import com.fuhuadata.service.mybatis.OrganizationService;
import com.fuhuadata.vo.MixNodeVO;
import com.fuhuadata.vo.OrganizationVO;
import org.springframework.aop.framework.AopContext;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * <p>User: wangjie
 * <p>Date: 4/11/2017
 */
@Service("com.fuhuadata.service.impl.mybatis.OrganizationServiceImpl")
public class OrganizationServiceImpl extends BaseServiceImpl<Organization, Integer>
        implements OrganizationService {

    @Override
    public List<OrganizationVO> listOrgTree() {
        List<Organization> orgs = ((OrganizationService) AopContext.currentProxy()).list();

        return new OrganizationTrees(orgs).convertToTreeList();
    }

    @Override
    public List<MixNodeVO> listOrgNodes() {
        List<Organization> orgs = ((OrganizationService) AopContext.currentProxy()).list();

        return orgs.stream()
                .map(this::convertToNode)
                .collect(toList());
    }

    @Override
    public List<Organization> listOrgs() {
        return ((OrganizationService) AopContext.currentProxy()).list();
    }

    @Override
    public Organization getByNcId(String ncId) {
        Example example = new Example(Organization.class);
        example.createCriteria().andEqualTo("ncId", ncId);

        List<Organization> orgs = listByExample(example);
        if (orgs.size() == 1) {
            return orgs.get(0);
        }

        return null;
    }

    @Override
    public Optional<Organization> getOptByNcId(String ncId) {

        return Optional.ofNullable(((OrganizationService) AopContext.currentProxy()).getByNcId(ncId));
    }

    @Override
    public Organization getByCode(String code) {

        Organization group = getGroup();

        if (StringUtils.isEmpty(code)) {
            return null;
        } else if (group.getCode().equals(code)) {

            return group;
        }

        Example example = new Example(Organization.class);
        example.createCriteria().andEqualTo("code", code);

        List<Organization> organizations = listByExample(example);
        if (organizations.size() == 1) {
            return organizations.get(0);
        }

        return null;
    }

    private Organization getGroup() {
        Organization organization = new Organization();
        organization.setCode("0001");
        organization.setName("福华集团");
        return organization;
    }

    @Override
    public Optional<Organization> getOptByCode(String code) {

        return Optional.ofNullable(((OrganizationService) AopContext.currentProxy()).getByCode(code));
    }

    @Override
    public MixNodeVO convertToNode(Organization org) {

        MixNodeVO nodeVO = new MixNodeVO(NodeType.ORG.key);

        nodeVO.setCid(org.getNcId());
        nodeVO.setCode(org.getCode());
        nodeVO.setCname(org.getName());
        nodeVO.setPid(org.getParentId());
        nodeVO.setNcId(org.getNcId());
        nodeVO.setRoot(org.isRoot());
        nodeVO.setIsParent(true);

        return nodeVO;
    }
}
