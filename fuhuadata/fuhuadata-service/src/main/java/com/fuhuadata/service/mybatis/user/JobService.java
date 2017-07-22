package com.fuhuadata.service.mybatis.user;

import com.fuhuadata.domain.mybatis.Job;
import com.fuhuadata.service.mybatis.BaseService;

import java.util.List;
import java.util.Set;

/**
 * <p>User: wangjie
 * <p>Date: 7/11/2017
 */
public interface JobService extends BaseService<Job, Integer> {

    /**
     * 获取组织下的用户code
     * @param deptPks
     * @return 去除重复的user code
     */
    Set<String> listUserCodeByDeptPks(List<String> deptPks);
}
