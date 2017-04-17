package com.fuhuadata.service.mybatis;

import com.fuhuadata.domain.mybatis.Dept;
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
}
