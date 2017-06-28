package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.Dept;
import com.fuhuadata.domain.mybatis.Organization;
import com.fuhuadata.vo.MixNodeVO;

import java.util.List;
import java.util.Optional;

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

    Dept getByCode(String code);

    /**
     * 根据 ncId 获取部门
     * @param pkDep
     * @return
     */
    Dept getByNcId(String pkDep);

    Optional<Dept> getOptByNcId(String pkDep);

    /**
     * 获取部门 MixNodeVo
     * @param pkDep
     * @return
     */
    MixNodeVO getMixNodeByNcId(String pkDep);

    /**
     * 组织，部门树根据 pid 获取上级节点，可能为部门 pk 也可能为组织 code
     * @param pid
     * @return
     */
    MixNodeVO getOrgOrDepPNode(String pid);

    /**
     * 将部门转换为组织部门树节点
     * @param dept
     * @return
     */
    MixNodeVO convertToNode(Dept dept);
}
