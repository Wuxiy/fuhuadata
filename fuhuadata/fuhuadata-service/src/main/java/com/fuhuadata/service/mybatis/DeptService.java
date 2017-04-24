package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.Dept;
import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.vo.MixNodeVO;

import java.util.List;

/**
 * <p>User: wangjie
 * <p>Date: 4/11/2017
 */
public interface DeptService extends BaseService<Dept, Integer> {

    /**
     * 获取组织，部门树
     * @return
     */
    List<MixNodeVO> getOrgDeptTree();

    /**
     * 获取所有部门节点
     * @return
     */
    List<MixNodeVO> listDeptNodes();

    /**
     * 获取组织下的部门树
     * @param orgId
     * @return
     */
    List<MixNodeVO> getDeptTree(Integer orgId);

    /**
     * 获取组织下的部门树
     * @param orgCode
     * @return
     */
    List<MixNodeVO> getDeptTree(String orgCode);

    /**
     * 获取组织下的部门树
     * @param org
     * @return
     */
    List<MixNodeVO> getDeptTree(Organization org);

    /**
     * 根据组织 ncid 获取部门集合
     * @param pkOrg
     * @return
     */
    List<Dept> listDepts(String pkOrg);

    /**
     * 根据组织 id 获取部门集合
     * @param orgId
     * @return
     */
    List<Dept> listDepts(Integer orgId);
}
