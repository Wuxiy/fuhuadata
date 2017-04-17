package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.vo.MixNodeVO;
import com.fuhuadata.vo.OrganizationVO;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/11/2017
 */
public interface OrganizationService extends BaseTreeableService<Organization, Integer> {

    /**
     * 获取组织树
     * @return
     */
    List<OrganizationVO> listOrgTree();

    /**
     * 获取组织树，并放入缓存
     * @return
     */
    List<MixNodeVO> listOrgNodes();
}
