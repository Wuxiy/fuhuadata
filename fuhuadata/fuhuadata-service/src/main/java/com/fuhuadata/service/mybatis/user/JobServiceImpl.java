package com.fuhuadata.service.mybatis.user;

import com.fuhuadata.domain.mybatis.Job;
import com.fuhuadata.service.impl.mybatis.BaseServiceImpl;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>User: wangjie
 * <p>Date: 7/11/2017
 */
@Service
public class JobServiceImpl extends BaseServiceImpl<Job, Integer>
        implements JobService {
    
    @Override
    public Set<String> listUserCodeByDeptPks(List<String> deptPks) {

        Example example = newExample();
        example.createCriteria()
                .andIn("pkDept", deptPks);
        List<Job> jobs = listByExample(example);

        List<String> userCodes = jobs.stream()
                .map(Job::getPsncode)
                .collect(Collectors.toList());

        return Sets.newHashSet(userCodes);
    }
}
