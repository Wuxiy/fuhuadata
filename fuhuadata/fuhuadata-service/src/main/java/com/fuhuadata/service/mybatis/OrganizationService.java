package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.vo.MixNodeVO;
import com.fuhuadata.vo.OrganizationVO;

import java.util.List;
import java.util.Optional;

/**
 * <p>User: wangjie
 * <p>Date: 4/11/2017
 */
public interface OrganizationService extends BaseService<Organization, Integer> {

    /**
     * 获取组织树
     *
     * @return
     */
    List<OrganizationVO> listOrgTree();

    /**
     * 获取组织树，并放入缓存
     *
     * @return
     */
    List<MixNodeVO> listOrgNodes();

    /**
     * 获取所有组织
     *
     * @return
     */
    List<Organization> listOrgs();

    /**
     * 根据 ncId 获取组织
     *
     * @param ncId
     * @return
     */
    Organization getByNcId(String ncId);

    /**
     * 根据 ncId 获取组织
     *
     * @param ncId
     * @return
     */
    Optional<Organization> getOptByNcId(String ncId);

    /**
     * 根据 code 获取组织
     *
     * @param code
     * @return
     */
    Organization getByCode(String code);

    /**
     * 根据 code 获取组织
     *
     * @param code
     * @return
     */
    Optional<Organization> getOptByCode(String code);

    /**
     * 将组织转换为组织部门树节点
     *
     * @param org
     * @return
     */
    MixNodeVO convertToNode(Organization org);
}
